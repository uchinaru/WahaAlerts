package models;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class JsonWahaModel {
    public String id;
    public long timestamp;
    public String event;
    public String session;
    public Metadata metadata;
    public Me me;
    public PayloadModel payload;
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
    public Data _data;
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
class Data {
    public Id id;
    public boolean viewed;
    public String body;
    public String type;
    public long t;
    public String notifyName;
    public String from;
    public String to;
    public String author;
    public int ack;
    public boolean invis;
    public boolean isNewMsg;
    public boolean star;
    public boolean kicNotified;
    public boolean recvFresh;
    public boolean isFromTemplate;
    public boolean pollInvalidated;
    public boolean isSentCagPollCreation;
    public Object latestEditMsgKey;
    public Object latestEditSenderTimestampMs;
    public List<Object> mentionedJidList;
    public List<Object> groupMentions;
    public boolean isEventCanceled;
    public boolean eventInvalidated;
    public boolean isVcardOverMmsDocument;
    public boolean isForwarded;
    public boolean isQuestion;
    public Object questionReplyQuotedMessage;
    public boolean hasReaction;
    public String viewMode;
    public Map<String, Integer> messageSecret;
    public boolean productHeaderImageRejected;
    public int lastPlaybackProgress;
    public boolean isDynamicReplyButtonsMsg;
    public boolean isCarouselCard;
    public Object parentMsgId;
    public Object callSilenceReason;
    public boolean isVideoCall;
    public Object callDuration;
    public Object callCreator;
    public Object callParticipants;
    public Object isCallLink;
    public Object callLinkToken;
    public boolean isMdHistoryMsg;
    public int stickerSentTs;
    public boolean isAvatar;
    public int lastUpdateFromServerTs;
    public Object invokedBotWid;
    public Object bizBotType;
    public Object botResponseTargetId;
    public Object botPluginType;
    public Object botPluginReferenceIndex;
    public Object botPluginSearchProvider;
    public Object botPluginSearchUrl;
    public Object botPluginSearchQuery;
    public boolean botPluginMaybeParent;
    public Object botReelPluginThumbnailCdnUrl;
    public Object botMessageDisclaimerText;
    public Object botMsgBodyType;
    public Object reportingTokenInfo;
    public Object requiresDirectConnection;
    public Object bizContentPlaceholderType;
    public boolean hostedBizEncStateMismatch;
    public boolean senderOrRecipientAccountTypeHosted;
    public boolean placeholderCreatedWhenAccountIsHosted;
    public boolean galaxyFlowDisabled;
    public List<Object> links;
    public String thumbnail;
    public String deprecatedMms3Url;
    public List<Object> interactiveAnnotations;
    public String faviconMMSMetadata;
    public String caption;
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