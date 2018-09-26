package it.redhat.hacep.playground.rules.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.redhat.hacep.model.Fact;

public abstract class JsonFact implements Fact {
	private static final long serialVersionUID = -8496222462870211407L;
	private static final ObjectMapper mapper = new ObjectMapper();

	protected transient volatile JsonNode objTree = null;
	protected transient volatile Map<String, JsonPointer> jsonPtrMap = null;

	protected long id;
	protected String jsonString;

	public JsonFact(long id, String jsonString) {
		this.id = id;
		this.jsonString = jsonString;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	// if the returned value is not a number, this returns 0
	public Long getNumberField(String jsonPath) {
		return getField(jsonPath).asLong();
	}

	public String getTextField(String jsonPath) {
		return getField(jsonPath).asText();
	}

	public boolean hasField(String jsonPath) {
		return !getField(jsonPath).isMissingNode();
	}

	protected JsonNode getField(String jsonPath) {
		String fullJsonPath = jsonPath.startsWith("/") ? jsonPath : "/" + jsonPath;

		Map<String, JsonPointer> map = getJSONPointerMap();
		JsonPointer jsonPtr = map.get(fullJsonPath);

		if (jsonPtr == null) {
			jsonPtr = JsonPointer.valueOf(fullJsonPath);
			jsonPtrMap.put(fullJsonPath, jsonPtr);
		}

		return parseObjTree().at(jsonPtr);
	}

	// this is thread-safe and performant
	protected Map<String, JsonPointer> getJSONPointerMap() {
		// access field only once if already set
		Map<String, JsonPointer> result = jsonPtrMap;
		if (result == null) {
			synchronized (jsonString) {
				result = jsonPtrMap;
				if (result == null) {
					jsonPtrMap = result = new ConcurrentHashMap<String, JsonPointer>();
				}
			}
		}

		return result;
	}

	// this is thread-safe and performant
	protected JsonNode parseObjTree() {
		// access field only once if already set
		JsonNode result = objTree;
		if (result == null) {
			synchronized (jsonString) {
				result = objTree;
				if (result == null) {
					try {
						objTree = result = mapper.readTree(jsonString);
					} catch (Exception e) {
						// TODO don't eat exceptions!
						e.printStackTrace(System.err);
					}
				}
			}
		}

		return result;
	}
}
