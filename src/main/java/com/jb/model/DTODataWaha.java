package com.jb.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DTODataWaha {

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
    public String stickerSentTs;
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
