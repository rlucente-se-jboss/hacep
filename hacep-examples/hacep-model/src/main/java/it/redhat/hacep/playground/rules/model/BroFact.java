package it.redhat.hacep.playground.rules.model;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import it.redhat.hacep.model.Fact;
import it.redhat.hacep.model.Key;
import it.redhat.hacep.playground.cache.BroFactKey;

public class BroFact implements Fact {
	private static final long serialVersionUID = -5793428853725499162L;

	// common set of fields for HACEP used for equals and hashCode
	protected long id;
	protected String _at_system; // @system
	protected Date ts;

	/*
	 * text fields
	 */
	protected String _at_proc; // @proc
	protected String _at_stream; // @stream
	protected String conn_state;
	protected String history;
	protected String id_orig_h;
	protected String id_resp_h;
	protected String level;
	protected String message;
	protected String name;
	protected String orig_l2_addr;
	protected String peer;
	protected String proto;
	protected String qclass_name;
	protected String qtype_name;
	protected String query;
	protected String rcode_name;
	protected String resp_l2_addr;
	protected String service;
	protected String src_name;
	protected String uid;

	/*
	 * number fields
	 */
	protected Long Z;
	protected Long active_dns_requests;
	protected Long active_files;
	protected Long active_icmp_conns;
	protected Long active_tcp_conns;
	protected Long active_timers;
	protected Long active_udp_conns;
	protected Long bytes_recv;
	protected Long dns_requests;
	protected Long duration;
	protected Long events_proc;
	protected Long events_queued;
	protected Long files;
	protected Long icmp_conns;
	protected Long id_orig_p;
	protected Long id_resp_p;
	protected Long mem;
	protected Long missed_bytes;
	protected Long orig_bytes;
	protected Long orig_ip_bytes;
	protected Long orig_pkts;
	protected Long pkt_lag;
	protected Long pkts_dropped;
	protected Long pkts_link;
	protected Long pkts_proc;
	protected Long qclass;
	protected Long qtype;
	protected Long rcode;
	protected Long reassem_file_size;
	protected Long reassem_frag_size;
	protected Long reassem_tcp_size;
	protected Long reassem_unknown_size;
	protected Long resp_bytes;
	protected Long resp_ip_bytes;
	protected Long resp_pkts;
	protected Long rtt;
	protected Long tcp_conns;
	protected Long timers;
	protected Long trans_id;
	protected Long udp_conns;

	public BroFact() {	
	}
	
	@JsonIgnore
	@Override
	public Instant getInstant() {
		return ts.toInstant();
	}

	@Override
	public Key extractKey() {
		return new BroFactKey(String.valueOf(id), _at_system);
	}

	@JsonIgnore
	public long getId() {
		return id;
	}

	@JsonIgnore
	public void setId(long id) {
		this.id = id;
	}

	@JsonGetter("@system")
	public String get_at_system() {
		return _at_system;
	}

	@JsonSetter("@system")
	public void set_at_system(String _at_system) {
		this._at_system = _at_system;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	@JsonGetter("@proc")
	public String get_at_proc() {
		return _at_proc;
	}

	@JsonSetter("@proc")
	public void set_at_proc(String _at_proc) {
		this._at_proc = _at_proc;
	}

	@JsonGetter("@stream")
	public String get_at_stream() {
		return _at_stream;
	}

	@JsonSetter("@stream")
	public void set_at_stream(String _at_stream) {
		this._at_stream = _at_stream;
	}

	public String getConn_state() {
		return conn_state;
	}

	public void setConn_state(String conn_state) {
		this.conn_state = conn_state;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getId_orig_h() {
		return id_orig_h;
	}

	public void setId_orig_h(String id_orig_h) {
		this.id_orig_h = id_orig_h;
	}

	public String getId_resp_h() {
		return id_resp_h;
	}

	public void setId_resp_h(String id_resp_h) {
		this.id_resp_h = id_resp_h;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrig_l2_addr() {
		return orig_l2_addr;
	}

	public void setOrig_l2_addr(String orig_l2_addr) {
		this.orig_l2_addr = orig_l2_addr;
	}

	public String getPeer() {
		return peer;
	}

	public void setPeer(String peer) {
		this.peer = peer;
	}

	public String getProto() {
		return proto;
	}

	public void setProto(String proto) {
		this.proto = proto;
	}

	public String getQclass_name() {
		return qclass_name;
	}

	public void setQclass_name(String qclass_name) {
		this.qclass_name = qclass_name;
	}

	public String getQtype_name() {
		return qtype_name;
	}

	public void setQtype_name(String qtype_name) {
		this.qtype_name = qtype_name;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getRcode_name() {
		return rcode_name;
	}

	public void setRcode_name(String rcode_name) {
		this.rcode_name = rcode_name;
	}

	public String getResp_l2_addr() {
		return resp_l2_addr;
	}

	public void setResp_l2_addr(String resp_l2_addr) {
		this.resp_l2_addr = resp_l2_addr;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSrc_name() {
		return src_name;
	}

	public void setSrc_name(String src_name) {
		this.src_name = src_name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getZ() {
		return Z;
	}

	public void setZ(Long z) {
		Z = z;
	}

	public Long getActive_dns_requests() {
		return active_dns_requests;
	}

	public void setActive_dns_requests(Long active_dns_requests) {
		this.active_dns_requests = active_dns_requests;
	}

	public Long getActive_files() {
		return active_files;
	}

	public void setActive_files(Long active_files) {
		this.active_files = active_files;
	}

	public Long getActive_icmp_conns() {
		return active_icmp_conns;
	}

	public void setActive_icmp_conns(Long active_icmp_conns) {
		this.active_icmp_conns = active_icmp_conns;
	}

	public Long getActive_tcp_conns() {
		return active_tcp_conns;
	}

	public void setActive_tcp_conns(Long active_tcp_conns) {
		this.active_tcp_conns = active_tcp_conns;
	}

	public Long getActive_timers() {
		return active_timers;
	}

	public void setActive_timers(Long active_timers) {
		this.active_timers = active_timers;
	}

	public Long getActive_udp_conns() {
		return active_udp_conns;
	}

	public void setActive_udp_conns(Long active_udp_conns) {
		this.active_udp_conns = active_udp_conns;
	}

	public Long getBytes_recv() {
		return bytes_recv;
	}

	public void setBytes_recv(Long bytes_recv) {
		this.bytes_recv = bytes_recv;
	}

	public Long getDns_requests() {
		return dns_requests;
	}

	public void setDns_requests(Long dns_requests) {
		this.dns_requests = dns_requests;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getEvents_proc() {
		return events_proc;
	}

	public void setEvents_proc(Long events_proc) {
		this.events_proc = events_proc;
	}

	public Long getEvents_queued() {
		return events_queued;
	}

	public void setEvents_queued(Long events_queued) {
		this.events_queued = events_queued;
	}

	public Long getFiles() {
		return files;
	}

	public void setFiles(Long files) {
		this.files = files;
	}

	public Long getIcmp_conns() {
		return icmp_conns;
	}

	public void setIcmp_conns(Long icmp_conns) {
		this.icmp_conns = icmp_conns;
	}

	public Long getId_orig_p() {
		return id_orig_p;
	}

	public void setId_orig_p(Long id_orig_p) {
		this.id_orig_p = id_orig_p;
	}

	public Long getId_resp_p() {
		return id_resp_p;
	}

	public void setId_resp_p(Long id_resp_p) {
		this.id_resp_p = id_resp_p;
	}

	public Long getMem() {
		return mem;
	}

	public void setMem(Long mem) {
		this.mem = mem;
	}

	public Long getMissed_bytes() {
		return missed_bytes;
	}

	public void setMissed_bytes(Long missed_bytes) {
		this.missed_bytes = missed_bytes;
	}

	public Long getOrig_bytes() {
		return orig_bytes;
	}

	public void setOrig_bytes(Long orig_bytes) {
		this.orig_bytes = orig_bytes;
	}

	public Long getOrig_ip_bytes() {
		return orig_ip_bytes;
	}

	public void setOrig_ip_bytes(Long orig_ip_bytes) {
		this.orig_ip_bytes = orig_ip_bytes;
	}

	public Long getOrig_pkts() {
		return orig_pkts;
	}

	public void setOrig_pkts(Long orig_pkts) {
		this.orig_pkts = orig_pkts;
	}

	public Long getPkt_lag() {
		return pkt_lag;
	}

	public void setPkt_lag(Long pkt_lag) {
		this.pkt_lag = pkt_lag;
	}

	public Long getPkts_dropped() {
		return pkts_dropped;
	}

	public void setPkts_dropped(Long pkts_dropped) {
		this.pkts_dropped = pkts_dropped;
	}

	public Long getPkts_link() {
		return pkts_link;
	}

	public void setPkts_link(Long pkts_link) {
		this.pkts_link = pkts_link;
	}

	public Long getPkts_proc() {
		return pkts_proc;
	}

	public void setPkts_proc(Long pkts_proc) {
		this.pkts_proc = pkts_proc;
	}

	public Long getQclass() {
		return qclass;
	}

	public void setQclass(Long qclass) {
		this.qclass = qclass;
	}

	public Long getQtype() {
		return qtype;
	}

	public void setQtype(Long qtype) {
		this.qtype = qtype;
	}

	public Long getRcode() {
		return rcode;
	}

	public void setRcode(Long rcode) {
		this.rcode = rcode;
	}

	public Long getReassem_file_size() {
		return reassem_file_size;
	}

	public void setReassem_file_size(Long reassem_file_size) {
		this.reassem_file_size = reassem_file_size;
	}

	public Long getReassem_frag_size() {
		return reassem_frag_size;
	}

	public void setReassem_frag_size(Long reassem_frag_size) {
		this.reassem_frag_size = reassem_frag_size;
	}

	public Long getReassem_tcp_size() {
		return reassem_tcp_size;
	}

	public void setReassem_tcp_size(Long reassem_tcp_size) {
		this.reassem_tcp_size = reassem_tcp_size;
	}

	public Long getReassem_unknown_size() {
		return reassem_unknown_size;
	}

	public void setReassem_unknown_size(Long reassem_unknown_size) {
		this.reassem_unknown_size = reassem_unknown_size;
	}

	public Long getResp_bytes() {
		return resp_bytes;
	}

	public void setResp_bytes(Long resp_bytes) {
		this.resp_bytes = resp_bytes;
	}

	public Long getResp_ip_bytes() {
		return resp_ip_bytes;
	}

	public void setResp_ip_bytes(Long resp_ip_bytes) {
		this.resp_ip_bytes = resp_ip_bytes;
	}

	public Long getResp_pkts() {
		return resp_pkts;
	}

	public void setResp_pkts(Long resp_pkts) {
		this.resp_pkts = resp_pkts;
	}

	public Long getRtt() {
		return rtt;
	}

	public void setRtt(Long rtt) {
		this.rtt = rtt;
	}

	public Long getTcp_conns() {
		return tcp_conns;
	}

	public void setTcp_conns(Long tcp_conns) {
		this.tcp_conns = tcp_conns;
	}

	public Long getTimers() {
		return timers;
	}

	public void setTimers(Long timers) {
		this.timers = timers;
	}

	public Long getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(Long trans_id) {
		this.trans_id = trans_id;
	}

	public Long getUdp_conns() {
		return udp_conns;
	}

	public void setUdp_conns(Long udp_conns) {
		this.udp_conns = udp_conns;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof BroFact))
			return false;
		BroFact broFact = (BroFact) o;
		return id == broFact.id && Objects.equals(_at_system, broFact._at_system)
				&& Objects.equals(ts, broFact.ts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, _at_system, ts);
	}

	@Override
    public String toString() {
        return "BroFact{" +
                "id=" + id +
                ", @system=" + _at_system +
                ", ts=" + ts +
                '}';
    }
}
