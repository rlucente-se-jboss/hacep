package it.redhat.hacep.playground.rules.model;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import it.redhat.hacep.model.Key;
import it.redhat.hacep.playground.cache.SuricataFactKey;

public class SuricataFact extends JsonFact {	
	private static final long serialVersionUID = 9149568997022967738L;

	// minimal set of fields for HACEP
	protected String hostname;
	protected Date timestamp;
	
	public SuricataFact(long id, String jsonString, String hostname, Date timestamp) {
		super(id, jsonString);
		this.hostname = hostname;
		this.timestamp = timestamp;
	}

	@Override
	public Instant getInstant() {
		return timestamp.toInstant();
	}

	@Override
	public Key extractKey() {
		return new SuricataFactKey(String.valueOf(id), hostname);
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
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
        if (!(o instanceof SuricataFact)) return false;
        SuricataFact suricataFact = (SuricataFact) o;
        return id == suricataFact.id &&
                Objects.equals(hostname, suricataFact.hostname) &&
                Objects.equals(timestamp, suricataFact.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hostname, timestamp);
    }

    @Override
    public String toString() {
        return "SuricataFact{" +
                "id=" + id +
                ", hostname=" + hostname +
                ", timestamp=" + timestamp +
                '}';
    }
}
