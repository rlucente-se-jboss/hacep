package it.redhat.hacep.playground.rules.model;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import it.redhat.hacep.model.Fact;
import it.redhat.hacep.model.Key;
import it.redhat.hacep.playground.cache.SuricataFactKey;

public class SuricataFact implements Fact {
	private static final long serialVersionUID = 9149568997022967738L;

	// common set of fields for HACEP used for equals and hashCode
	protected long id;
	protected String hostname; // JSON path "/host/name"
	protected Date _at_timestamp; // JSON path "/@timestamp"

	/*
	 * text fields
	 */
	protected String app_proto;
	protected String dest_ip;
	protected String event_type;
	protected String kafka_topic;
	protected String proto;
	protected String source;
	protected String src_ip;
	protected Date timestamp;

	/*
	 * numeric fields
	 */
	protected Long dest_port;
	protected Long flow_id;
	protected Long icmp_code;
	protected Long icmp_type;
	protected Long offset;
	protected Long src_port;

	// catch all for remaining JSON values
	protected Map<String, Object> properties = new HashMap<>();

	public SuricataFact() {
	}

	@Override
	public Instant getInstant() {
		return timestamp.toInstant();
	}

	@Override
	public Key extractKey() {
		return new SuricataFactKey(String.valueOf(id), hostname);
	}

	@JsonIgnore
	public long getId() {
		return id;
	}

	@JsonIgnore
	public String getIdAsString() {
		return Long.toString(id);
	}

	@JsonIgnore
	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public String getHostname() {
		return hostname;
	}

	@JsonIgnore
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	@JsonGetter("@timestamp")
	public Date get_at_timestamp() {
		return _at_timestamp;
	}

	@JsonSetter("@timestamp")
	public void set_at_timestamp(Date _at_timestamp) {
		this._at_timestamp = _at_timestamp;
	}

	public String getApp_proto() {
		return app_proto;
	}

	public void setApp_proto(String app_proto) {
		this.app_proto = app_proto;
	}

	public String getDest_ip() {
		return dest_ip;
	}

	public void setDest_ip(String dest_ip) {
		this.dest_ip = dest_ip;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getKafka_topic() {
		return kafka_topic;
	}

	public void setKafka_topic(String kafka_topic) {
		this.kafka_topic = kafka_topic;
	}

	public String getProto() {
		return proto;
	}

	public void setProto(String proto) {
		this.proto = proto;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSrc_ip() {
		return src_ip;
	}

	public void setSrc_ip(String src_ip) {
		this.src_ip = src_ip;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getDest_port() {
		return dest_port;
	}

	public void setDest_port(Long dest_port) {
		this.dest_port = dest_port;
	}

	public Long getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(Long flow_id) {
		this.flow_id = flow_id;
	}

	public Long getIcmp_code() {
		return icmp_code;
	}

	public void setIcmp_code(Long icmp_code) {
		this.icmp_code = icmp_code;
	}

	public Long getIcmp_type() {
		return icmp_type;
	}

	public void setIcmp_type(Long icmp_type) {
		this.icmp_type = icmp_type;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public Long getSrc_port() {
		return src_port;
	}

	public void setSrc_port(Long src_port) {
		this.src_port = src_port;
	}

	public Object get(String fieldName){
        return this.properties.get(fieldName);
    }
	
    @JsonAnySetter
    public void set(String fieldName, Object value){
        this.properties.put(fieldName, value);
    }

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof SuricataFact))
			return false;
		SuricataFact suricataFact = (SuricataFact) o;
		return id == suricataFact.id && Objects.equals(hostname, suricataFact.hostname)
				&& Objects.equals(_at_timestamp, suricataFact._at_timestamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, hostname, _at_timestamp);
	}

	@Override
	public String toString() {
		return "SuricataFact{" + "id=" + id + ", hostname=" + hostname + ", _at_timestamp=" + _at_timestamp + '}';
	}

	@JsonProperty("host")
	private void unpackNameFromNestedObject(Map<String, String> host) {
	    hostname = host.get("name");
	}
}
