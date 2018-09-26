package it.redhat.hacep.playground.rules.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.redhat.hacep.model.Fact;

public abstract class JsonFact implements Fact {
	private static final long serialVersionUID = -8496222462870211407L;
	private static final ObjectMapper mapper = new ObjectMapper();

	protected transient Object mutex = new Object();
	protected transient volatile JsonNode objTree = null;

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

	// if the field name is not a number, this returns 0
	public Long getNumberField(String fieldName) {
		return getField(fieldName).asLong();
	}

	public String getTextField(String fieldName) {
		return getField(fieldName).asText();
	}

	protected JsonNode getField(String fieldName) {
		return getObjTree().at(fieldName.startsWith("/") ? fieldName : "/" + fieldName);
	}

	// this is thread-safe and performant
	protected JsonNode getObjTree() {
		// access field only once if already set
		JsonNode result = objTree;
		if (result == null) {
			synchronized (mutex) {
				result = objTree;
				if (result == null) {
					try {
						objTree = result = mapper.readTree(jsonString);
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
		}

		return result;
	}
}