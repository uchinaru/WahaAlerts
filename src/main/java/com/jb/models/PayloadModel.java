package com.jb.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties
public class PayloadModel {

    public String id;
    public long timestamp;
    public String from;
    public boolean fromMe;
    public String participant;
    public String source;
    public String to;
    public String body;
    public JsonNode replyTo;
    public boolean hasMedia;
    public Media media;
    public int ack;
    public String ackName;
    public List<Object> vCards;
    public DataWahaModel _data;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public boolean isFromMe() {
		return fromMe;
	}
	public void setFromMe(boolean fromMe) {
		this.fromMe = fromMe;
	}
	public String getParticipant() {
		return participant;
	}
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public boolean isHasMedia() {
		return hasMedia;
	}
	public void setHasMedia(boolean hasMedia) {
		this.hasMedia = hasMedia;
	}
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	public int getAck() {
		return ack;
	}
	public void setAck(int ack) {
		this.ack = ack;
	}
	public String getAckName() {
		return ackName;
	}
	public void setAckName(String ackName) {
		this.ackName = ackName;
	}
	public List<Object> getvCards() {
		return vCards;
	}
	public void setvCards(List<Object> vCards) {
		this.vCards = vCards;
	}
	
	public JsonNode getReplyTo() {
		return replyTo;
	}
	public void setReplyTo(JsonNode replyTo) {
		this.replyTo = replyTo;
	}
	public DataWahaModel get_data() {
		return _data;
	}
	public void set_data(DataWahaModel _data) {
		this._data = _data;
	}
}
