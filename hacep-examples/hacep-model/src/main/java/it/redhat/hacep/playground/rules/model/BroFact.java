package it.redhat.hacep.playground.rules.model;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import it.redhat.hacep.model.Key;
import it.redhat.hacep.playground.cache.BroFactKey;

public class BroFact extends JsonFact {	
	private static final long serialVersionUID = -5793428853725499162L;

	// minimal set of fields for HACEP
	protected String system;
	protected Date timestamp;
	
	public BroFact(long id, String jsonString, String system, Date timestamp) {
		super(id, jsonString);
		this.system = system;
		this.timestamp = timestamp;
	}

	@Override
	public Instant getInstant() {
		return timestamp.toInstant();
	}

	@Override
	public Key extractKey() {
		return new BroFactKey(String.valueOf(id), system);
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BroFact)) return false;
        BroFact broFact = (BroFact) o;
        return id == broFact.id &&
                Objects.equals(system, broFact.system) &&
                Objects.equals(timestamp, broFact.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, system, timestamp);
    }

    @Override
    public String toString() {
        return "BroFact{" +
                "id=" + id +
                ", system=" + system +
                ", timestamp=" + timestamp +
                '}';
    }
}
