package com.jb.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DTOJsonWaha {
    public String id;
    public long timestamp;
    public String event;
    public String session;
    public Metadata metadata;
    public Me me;
    public DTOPayloadWaha payload;
    public String engine;
    public Environment environment;
    
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Metadata {
    
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Me {
    public String id;
    public String pushName;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Media {
    public DTODataWaha _data;
    public Id id;
    public int ack;
    public boolean hasMedia;
    public String body;
    public String type;
    public long timestamp;
    public String from;
    public String to;
    public String author;
    public String deviceType;
    public boolean isForwarded;
    public int forwardingScore;
    public boolean isStatus;
    public boolean isStarred;
    public boolean fromMe;
    public boolean hasQuotedMsg;
    public boolean hasReaction;
    public List<Object> vCards;
    public List<Object> mentionedIds;
    public List<Object> groupMentions;
    public boolean isGif;
    public List<Object> links;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Id {
    public boolean fromMe;
    public String remote;
    public String id;
    public String participant;
    public String _serialized;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Environment {
    public String version;
    public String engine;
    public String tier;
    public String browser;
}