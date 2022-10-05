/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account.usage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;
import com.twilio.http.HttpMethod;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Objects;



@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Trigger extends Resource {
    private static final long serialVersionUID = 180476898929579L;

    public static TriggerCreator creator(final URI callbackUrl, final String triggerValue, final Trigger.UsageCategory usageCategory){
        return new TriggerCreator(callbackUrl, triggerValue, usageCategory);
    }
    public static TriggerCreator creator(final String accountSid, final URI callbackUrl, final String triggerValue, final Trigger.UsageCategory usageCategory){
        return new TriggerCreator(accountSid, callbackUrl, triggerValue, usageCategory);
    }

    public static TriggerFetcher fetcher(final String sid){
        return new TriggerFetcher(sid);
    }
    public static TriggerFetcher fetcher(final String accountSid, final String sid){
        return new TriggerFetcher(accountSid, sid);
    }

    public static TriggerDeleter deleter(final String sid){
        return new TriggerDeleter(sid);
    }
    public static TriggerDeleter deleter(final String accountSid, final String sid){
        return new TriggerDeleter(accountSid, sid);
    }

    public static TriggerReader reader(){
        return new TriggerReader();
    }
    public static TriggerReader reader(final String accountSid){
        return new TriggerReader(accountSid);
    }

    public static TriggerUpdater updater(final String sid){
        return new TriggerUpdater(sid);
    }
    public static TriggerUpdater updater(final String accountSid, final String sid){
        return new TriggerUpdater(accountSid, sid);
    }

    /**
    * Converts a JSON String into a Trigger object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Trigger object represented by the provided JSON
    */
    public static Trigger fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Trigger.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Trigger object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Trigger object represented by the provided JSON
    */
    public static Trigger fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Trigger.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Recurring {
        DAILY("daily"),
        MONTHLY("monthly"),
        YEARLY("yearly"),
        ALLTIME("alltime");

        private final String value;

        private Recurring(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Recurring forValue(final String value) {
            return Promoter.enumFromString(value, Recurring.values());
        }
    }
    public enum TriggerField {
        COUNT("count"),
        USAGE("usage"),
        PRICE("price");

        private final String value;

        private TriggerField(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static TriggerField forValue(final String value) {
            return Promoter.enumFromString(value, TriggerField.values());
        }
    }
    public enum UsageCategory {
        A2P_REGISTRATION_FEES("a2p-registration-fees"),
        AGENT_CONFERENCE("agent-conference"),
        AMAZON_POLLY("amazon-polly"),
        ANSWERING_MACHINE_DETECTION("answering-machine-detection"),
        AUTHY_AUTHENTICATIONS("authy-authentications"),
        AUTHY_CALLS_OUTBOUND("authy-calls-outbound"),
        AUTHY_MONTHLY_FEES("authy-monthly-fees"),
        AUTHY_PHONE_INTELLIGENCE("authy-phone-intelligence"),
        AUTHY_PHONE_VERIFICATIONS("authy-phone-verifications"),
        AUTHY_SMS_OUTBOUND("authy-sms-outbound"),
        CALL_PROGESS_EVENTS("call-progess-events"),
        CALLERIDLOOKUPS("calleridlookups"),
        CALLS("calls"),
        CALLS_CLIENT("calls-client"),
        CALLS_GLOBALCONFERENCE("calls-globalconference"),
        CALLS_INBOUND("calls-inbound"),
        CALLS_INBOUND_LOCAL("calls-inbound-local"),
        CALLS_INBOUND_MOBILE("calls-inbound-mobile"),
        CALLS_INBOUND_TOLLFREE("calls-inbound-tollfree"),
        CALLS_OUTBOUND("calls-outbound"),
        CALLS_PAY_VERB_TRANSACTIONS("calls-pay-verb-transactions"),
        CALLS_RECORDINGS("calls-recordings"),
        CALLS_SIP("calls-sip"),
        CALLS_SIP_INBOUND("calls-sip-inbound"),
        CALLS_SIP_OUTBOUND("calls-sip-outbound"),
        CALLS_TRANSFERS("calls-transfers"),
        CARRIER_LOOKUPS("carrier-lookups"),
        CONVERSATIONS("conversations"),
        CONVERSATIONS_API_REQUESTS("conversations-api-requests"),
        CONVERSATIONS_CONVERSATION_EVENTS("conversations-conversation-events"),
        CONVERSATIONS_ENDPOINT_CONNECTIVITY("conversations-endpoint-connectivity"),
        CONVERSATIONS_EVENTS("conversations-events"),
        CONVERSATIONS_PARTICIPANT_EVENTS("conversations-participant-events"),
        CONVERSATIONS_PARTICIPANTS("conversations-participants"),
        CPS("cps"),
        FLEX_USAGE("flex-usage"),
        FRAUD_LOOKUPS("fraud-lookups"),
        GROUP_ROOMS("group-rooms"),
        GROUP_ROOMS_DATA_TRACK("group-rooms-data-track"),
        GROUP_ROOMS_ENCRYPTED_MEDIA_RECORDED("group-rooms-encrypted-media-recorded"),
        GROUP_ROOMS_MEDIA_DOWNLOADED("group-rooms-media-downloaded"),
        GROUP_ROOMS_MEDIA_RECORDED("group-rooms-media-recorded"),
        GROUP_ROOMS_MEDIA_ROUTED("group-rooms-media-routed"),
        GROUP_ROOMS_MEDIA_STORED("group-rooms-media-stored"),
        GROUP_ROOMS_PARTICIPANT_MINUTES("group-rooms-participant-minutes"),
        GROUP_ROOMS_RECORDED_MINUTES("group-rooms-recorded-minutes"),
        IMP_V1_USAGE("imp-v1-usage"),
        LOOKUPS("lookups"),
        MARKETPLACE("marketplace"),
        MARKETPLACE_ALGORITHMIA_NAMED_ENTITY_RECOGNITION("marketplace-algorithmia-named-entity-recognition"),
        MARKETPLACE_CADENCE_TRANSCRIPTION("marketplace-cadence-transcription"),
        MARKETPLACE_CADENCE_TRANSLATION("marketplace-cadence-translation"),
        MARKETPLACE_CAPIO_SPEECH_TO_TEXT("marketplace-capio-speech-to-text"),
        MARKETPLACE_CONVRIZA_ABABA("marketplace-convriza-ababa"),
        MARKETPLACE_DEEPGRAM_PHRASE_DETECTOR("marketplace-deepgram-phrase-detector"),
        MARKETPLACE_DIGITAL_SEGMENT_BUSINESS_INFO("marketplace-digital-segment-business-info"),
        MARKETPLACE_FACEBOOK_OFFLINE_CONVERSIONS("marketplace-facebook-offline-conversions"),
        MARKETPLACE_GOOGLE_SPEECH_TO_TEXT("marketplace-google-speech-to-text"),
        MARKETPLACE_IBM_WATSON_MESSAGE_INSIGHTS("marketplace-ibm-watson-message-insights"),
        MARKETPLACE_IBM_WATSON_MESSAGE_SENTIMENT("marketplace-ibm-watson-message-sentiment"),
        MARKETPLACE_IBM_WATSON_RECORDING_ANALYSIS("marketplace-ibm-watson-recording-analysis"),
        MARKETPLACE_IBM_WATSON_TONE_ANALYZER("marketplace-ibm-watson-tone-analyzer"),
        MARKETPLACE_ICEHOOK_SYSTEMS_SCOUT("marketplace-icehook-systems-scout"),
        MARKETPLACE_INFOGROUP_DATAAXLE_BIZINFO("marketplace-infogroup-dataaxle-bizinfo"),
        MARKETPLACE_KEEN_IO_CONTACT_CENTER_ANALYTICS("marketplace-keen-io-contact-center-analytics"),
        MARKETPLACE_MARCHEX_CLEANCALL("marketplace-marchex-cleancall"),
        MARKETPLACE_MARCHEX_SENTIMENT_ANALYSIS_FOR_SMS("marketplace-marchex-sentiment-analysis-for-sms"),
        MARKETPLACE_MARKETPLACE_NEXTCALLER_SOCIAL_ID("marketplace-marketplace-nextcaller-social-id"),
        MARKETPLACE_MOBILE_COMMONS_OPT_OUT_CLASSIFIER("marketplace-mobile-commons-opt-out-classifier"),
        MARKETPLACE_NEXIWAVE_VOICEMAIL_TO_TEXT("marketplace-nexiwave-voicemail-to-text"),
        MARKETPLACE_NEXTCALLER_ADVANCED_CALLER_IDENTIFICATION("marketplace-nextcaller-advanced-caller-identification"),
        MARKETPLACE_NOMOROBO_SPAM_SCORE("marketplace-nomorobo-spam-score"),
        MARKETPLACE_PAYFONE_TCPA_COMPLIANCE("marketplace-payfone-tcpa-compliance"),
        MARKETPLACE_REMEETING_AUTOMATIC_SPEECH_RECOGNITION("marketplace-remeeting-automatic-speech-recognition"),
        MARKETPLACE_TCPA_DEFENSE_SOLUTIONS_BLACKLIST_FEED("marketplace-tcpa-defense-solutions-blacklist-feed"),
        MARKETPLACE_TELO_OPENCNAM("marketplace-telo-opencnam"),
        MARKETPLACE_TRUECNAM_TRUE_SPAM("marketplace-truecnam-true-spam"),
        MARKETPLACE_TWILIO_CALLER_NAME_LOOKUP_US("marketplace-twilio-caller-name-lookup-us"),
        MARKETPLACE_TWILIO_CARRIER_INFORMATION_LOOKUP("marketplace-twilio-carrier-information-lookup"),
        MARKETPLACE_VOICEBASE_PCI("marketplace-voicebase-pci"),
        MARKETPLACE_VOICEBASE_TRANSCRIPTION("marketplace-voicebase-transcription"),
        MARKETPLACE_VOICEBASE_TRANSCRIPTION_CUSTOM_VOCABULARY("marketplace-voicebase-transcription-custom-vocabulary"),
        MARKETPLACE_WHITEPAGES_PRO_CALLER_IDENTIFICATION("marketplace-whitepages-pro-caller-identification"),
        MARKETPLACE_WHITEPAGES_PRO_PHONE_INTELLIGENCE("marketplace-whitepages-pro-phone-intelligence"),
        MARKETPLACE_WHITEPAGES_PRO_PHONE_REPUTATION("marketplace-whitepages-pro-phone-reputation"),
        MARKETPLACE_WOLFARM_SPOKEN_RESULTS("marketplace-wolfarm-spoken-results"),
        MARKETPLACE_WOLFRAM_SHORT_ANSWER("marketplace-wolfram-short-answer"),
        MARKETPLACE_YTICA_CONTACT_CENTER_REPORTING_ANALYTICS("marketplace-ytica-contact-center-reporting-analytics"),
        MEDIASTORAGE("mediastorage"),
        MMS("mms"),
        MMS_INBOUND("mms-inbound"),
        MMS_INBOUND_LONGCODE("mms-inbound-longcode"),
        MMS_INBOUND_SHORTCODE("mms-inbound-shortcode"),
        MMS_MESSAGES_CARRIERFEES("mms-messages-carrierfees"),
        MMS_OUTBOUND("mms-outbound"),
        MMS_OUTBOUND_LONGCODE("mms-outbound-longcode"),
        MMS_OUTBOUND_SHORTCODE("mms-outbound-shortcode"),
        MONITOR_READS("monitor-reads"),
        MONITOR_STORAGE("monitor-storage"),
        MONITOR_WRITES("monitor-writes"),
        NOTIFY("notify"),
        NOTIFY_ACTIONS_ATTEMPTS("notify-actions-attempts"),
        NOTIFY_CHANNELS("notify-channels"),
        NUMBER_FORMAT_LOOKUPS("number-format-lookups"),
        PCHAT("pchat"),
        PCHAT_USERS("pchat-users"),
        PEER_TO_PEER_ROOMS_PARTICIPANT_MINUTES("peer-to-peer-rooms-participant-minutes"),
        PFAX("pfax"),
        PFAX_MINUTES("pfax-minutes"),
        PFAX_MINUTES_INBOUND("pfax-minutes-inbound"),
        PFAX_MINUTES_OUTBOUND("pfax-minutes-outbound"),
        PFAX_PAGES("pfax-pages"),
        PHONENUMBERS("phonenumbers"),
        PHONENUMBERS_CPS("phonenumbers-cps"),
        PHONENUMBERS_EMERGENCY("phonenumbers-emergency"),
        PHONENUMBERS_LOCAL("phonenumbers-local"),
        PHONENUMBERS_MOBILE("phonenumbers-mobile"),
        PHONENUMBERS_SETUPS("phonenumbers-setups"),
        PHONENUMBERS_TOLLFREE("phonenumbers-tollfree"),
        PREMIUMSUPPORT("premiumsupport"),
        PROXY("proxy"),
        PROXY_ACTIVE_SESSIONS("proxy-active-sessions"),
        PSTNCONNECTIVITY("pstnconnectivity"),
        PV("pv"),
        PV_COMPOSITION_MEDIA_DOWNLOADED("pv-composition-media-downloaded"),
        PV_COMPOSITION_MEDIA_ENCRYPTED("pv-composition-media-encrypted"),
        PV_COMPOSITION_MEDIA_STORED("pv-composition-media-stored"),
        PV_COMPOSITION_MINUTES("pv-composition-minutes"),
        PV_RECORDING_COMPOSITIONS("pv-recording-compositions"),
        PV_ROOM_PARTICIPANTS("pv-room-participants"),
        PV_ROOM_PARTICIPANTS_AU1("pv-room-participants-au1"),
        PV_ROOM_PARTICIPANTS_BR1("pv-room-participants-br1"),
        PV_ROOM_PARTICIPANTS_IE1("pv-room-participants-ie1"),
        PV_ROOM_PARTICIPANTS_JP1("pv-room-participants-jp1"),
        PV_ROOM_PARTICIPANTS_SG1("pv-room-participants-sg1"),
        PV_ROOM_PARTICIPANTS_US1("pv-room-participants-us1"),
        PV_ROOM_PARTICIPANTS_US2("pv-room-participants-us2"),
        PV_ROOMS("pv-rooms"),
        PV_SIP_ENDPOINT_REGISTRATIONS("pv-sip-endpoint-registrations"),
        RECORDINGS("recordings"),
        RECORDINGSTORAGE("recordingstorage"),
        ROOMS_GROUP_BANDWIDTH("rooms-group-bandwidth"),
        ROOMS_GROUP_MINUTES("rooms-group-minutes"),
        ROOMS_PEER_TO_PEER_MINUTES("rooms-peer-to-peer-minutes"),
        SHORTCODES("shortcodes"),
        SHORTCODES_CUSTOMEROWNED("shortcodes-customerowned"),
        SHORTCODES_MMS_ENABLEMENT("shortcodes-mms-enablement"),
        SHORTCODES_MPS("shortcodes-mps"),
        SHORTCODES_RANDOM("shortcodes-random"),
        SHORTCODES_UK("shortcodes-uk"),
        SHORTCODES_VANITY("shortcodes-vanity"),
        SMALL_GROUP_ROOMS("small-group-rooms"),
        SMALL_GROUP_ROOMS_DATA_TRACK("small-group-rooms-data-track"),
        SMALL_GROUP_ROOMS_PARTICIPANT_MINUTES("small-group-rooms-participant-minutes"),
        SMS("sms"),
        SMS_INBOUND("sms-inbound"),
        SMS_INBOUND_LONGCODE("sms-inbound-longcode"),
        SMS_INBOUND_SHORTCODE("sms-inbound-shortcode"),
        SMS_MESSAGES_CARRIERFEES("sms-messages-carrierfees"),
        SMS_MESSAGES_FEATURES("sms-messages-features"),
        SMS_MESSAGES_FEATURES_SENDERID("sms-messages-features-senderid"),
        SMS_OUTBOUND("sms-outbound"),
        SMS_OUTBOUND_CONTENT_INSPECTION("sms-outbound-content-inspection"),
        SMS_OUTBOUND_LONGCODE("sms-outbound-longcode"),
        SMS_OUTBOUND_SHORTCODE("sms-outbound-shortcode"),
        SPEECH_RECOGNITION("speech-recognition"),
        STUDIO_ENGAGEMENTS("studio-engagements"),
        SYNC("sync"),
        SYNC_ACTIONS("sync-actions"),
        SYNC_ENDPOINT_HOURS("sync-endpoint-hours"),
        SYNC_ENDPOINT_HOURS_ABOVE_DAILY_CAP("sync-endpoint-hours-above-daily-cap"),
        TASKROUTER_TASKS("taskrouter-tasks"),
        TOTALPRICE("totalprice"),
        TRANSCRIPTIONS("transcriptions"),
        TRUNKING_CPS("trunking-cps"),
        TRUNKING_EMERGENCY_CALLS("trunking-emergency-calls"),
        TRUNKING_ORIGINATION("trunking-origination"),
        TRUNKING_ORIGINATION_LOCAL("trunking-origination-local"),
        TRUNKING_ORIGINATION_MOBILE("trunking-origination-mobile"),
        TRUNKING_ORIGINATION_TOLLFREE("trunking-origination-tollfree"),
        TRUNKING_RECORDINGS("trunking-recordings"),
        TRUNKING_SECURE("trunking-secure"),
        TRUNKING_TERMINATION("trunking-termination"),
        TURNMEGABYTES("turnmegabytes"),
        TURNMEGABYTES_AUSTRALIA("turnmegabytes-australia"),
        TURNMEGABYTES_BRASIL("turnmegabytes-brasil"),
        TURNMEGABYTES_GERMANY("turnmegabytes-germany"),
        TURNMEGABYTES_INDIA("turnmegabytes-india"),
        TURNMEGABYTES_IRELAND("turnmegabytes-ireland"),
        TURNMEGABYTES_JAPAN("turnmegabytes-japan"),
        TURNMEGABYTES_SINGAPORE("turnmegabytes-singapore"),
        TURNMEGABYTES_USEAST("turnmegabytes-useast"),
        TURNMEGABYTES_USWEST("turnmegabytes-uswest"),
        TWILIO_INTERCONNECT("twilio-interconnect"),
        VERIFY_PUSH("verify-push"),
        VERIFY_TOTP("verify-totp"),
        VERIFY_WHATSAPP_CONVERSATIONS_BUSINESS_INITIATED("verify-whatsapp-conversations-business-initiated"),
        VIDEO_RECORDINGS("video-recordings"),
        VIRTUAL_AGENT("virtual-agent"),
        VOICE_INSIGHTS("voice-insights"),
        VOICE_INSIGHTS_CLIENT_INSIGHTS_ON_DEMAND_MINUTE("voice-insights-client-insights-on-demand-minute"),
        VOICE_INSIGHTS_PTSN_INSIGHTS_ON_DEMAND_MINUTE("voice-insights-ptsn-insights-on-demand-minute"),
        VOICE_INSIGHTS_SIP_INTERFACE_INSIGHTS_ON_DEMAND_MINUTE("voice-insights-sip-interface-insights-on-demand-minute"),
        VOICE_INSIGHTS_SIP_TRUNKING_INSIGHTS_ON_DEMAND_MINUTE("voice-insights-sip-trunking-insights-on-demand-minute"),
        WIRELESS("wireless"),
        WIRELESS_ORDERS("wireless-orders"),
        WIRELESS_ORDERS_ARTWORK("wireless-orders-artwork"),
        WIRELESS_ORDERS_BULK("wireless-orders-bulk"),
        WIRELESS_ORDERS_ESIM("wireless-orders-esim"),
        WIRELESS_ORDERS_STARTER("wireless-orders-starter"),
        WIRELESS_USAGE("wireless-usage"),
        WIRELESS_USAGE_COMMANDS("wireless-usage-commands"),
        WIRELESS_USAGE_COMMANDS_AFRICA("wireless-usage-commands-africa"),
        WIRELESS_USAGE_COMMANDS_ASIA("wireless-usage-commands-asia"),
        WIRELESS_USAGE_COMMANDS_CENTRALANDSOUTHAMERICA("wireless-usage-commands-centralandsouthamerica"),
        WIRELESS_USAGE_COMMANDS_EUROPE("wireless-usage-commands-europe"),
        WIRELESS_USAGE_COMMANDS_HOME("wireless-usage-commands-home"),
        WIRELESS_USAGE_COMMANDS_NORTHAMERICA("wireless-usage-commands-northamerica"),
        WIRELESS_USAGE_COMMANDS_OCEANIA("wireless-usage-commands-oceania"),
        WIRELESS_USAGE_COMMANDS_ROAMING("wireless-usage-commands-roaming"),
        WIRELESS_USAGE_DATA("wireless-usage-data"),
        WIRELESS_USAGE_DATA_AFRICA("wireless-usage-data-africa"),
        WIRELESS_USAGE_DATA_ASIA("wireless-usage-data-asia"),
        WIRELESS_USAGE_DATA_CENTRALANDSOUTHAMERICA("wireless-usage-data-centralandsouthamerica"),
        WIRELESS_USAGE_DATA_CUSTOM_ADDITIONALMB("wireless-usage-data-custom-additionalmb"),
        WIRELESS_USAGE_DATA_CUSTOM_FIRST5MB("wireless-usage-data-custom-first5mb"),
        WIRELESS_USAGE_DATA_DOMESTIC_ROAMING("wireless-usage-data-domestic-roaming"),
        WIRELESS_USAGE_DATA_EUROPE("wireless-usage-data-europe"),
        WIRELESS_USAGE_DATA_INDIVIDUAL_ADDITIONALGB("wireless-usage-data-individual-additionalgb"),
        WIRELESS_USAGE_DATA_INDIVIDUAL_FIRSTGB("wireless-usage-data-individual-firstgb"),
        WIRELESS_USAGE_DATA_INTERNATIONAL_ROAMING_CANADA("wireless-usage-data-international-roaming-canada"),
        WIRELESS_USAGE_DATA_INTERNATIONAL_ROAMING_INDIA("wireless-usage-data-international-roaming-india"),
        WIRELESS_USAGE_DATA_INTERNATIONAL_ROAMING_MEXICO("wireless-usage-data-international-roaming-mexico"),
        WIRELESS_USAGE_DATA_NORTHAMERICA("wireless-usage-data-northamerica"),
        WIRELESS_USAGE_DATA_OCEANIA("wireless-usage-data-oceania"),
        WIRELESS_USAGE_DATA_POOLED("wireless-usage-data-pooled"),
        WIRELESS_USAGE_DATA_POOLED_DOWNLINK("wireless-usage-data-pooled-downlink"),
        WIRELESS_USAGE_DATA_POOLED_UPLINK("wireless-usage-data-pooled-uplink"),
        WIRELESS_USAGE_MRC("wireless-usage-mrc"),
        WIRELESS_USAGE_MRC_CUSTOM("wireless-usage-mrc-custom"),
        WIRELESS_USAGE_MRC_INDIVIDUAL("wireless-usage-mrc-individual"),
        WIRELESS_USAGE_MRC_POOLED("wireless-usage-mrc-pooled"),
        WIRELESS_USAGE_MRC_SUSPENDED("wireless-usage-mrc-suspended"),
        WIRELESS_USAGE_SMS("wireless-usage-sms"),
        WIRELESS_USAGE_VOICE("wireless-usage-voice");

        private final String value;

        private UsageCategory(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static UsageCategory forValue(final String value) {
            return Promoter.enumFromString(value, UsageCategory.values());
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final HttpMethod callbackMethod;
    private final URI callbackUrl;
    private final String currentValue;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateFired;
    private final ZonedDateTime dateUpdated;
    private final String friendlyName;
    private final Trigger.Recurring recurring;
    private final String sid;
    private final Trigger.TriggerField triggerBy;
    private final String triggerValue;
    private final String uri;
    private final Trigger.UsageCategory usageCategory;
    private final String usageRecordUri;

    @JsonCreator
    private Trigger(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("api_version")
        final String apiVersion,

        @JsonProperty("callback_method")
        final HttpMethod callbackMethod,

        @JsonProperty("callback_url")
        final URI callbackUrl,

        @JsonProperty("current_value")
        final String currentValue,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_fired")
        final String dateFired,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("recurring")
        final Trigger.Recurring recurring,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("trigger_by")
        final Trigger.TriggerField triggerBy,

        @JsonProperty("trigger_value")
        final String triggerValue,

        @JsonProperty("uri")
        final String uri,

        @JsonProperty("usage_category")
        final Trigger.UsageCategory usageCategory,

        @JsonProperty("usage_record_uri")
        final String usageRecordUri
    ) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.callbackMethod = callbackMethod;
        this.callbackUrl = callbackUrl;
        this.currentValue = currentValue;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateFired = DateConverter.rfc2822DateTimeFromString(dateFired);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.recurring = recurring;
        this.sid = sid;
        this.triggerBy = triggerBy;
        this.triggerValue = triggerValue;
        this.uri = uri;
        this.usageCategory = usageCategory;
        this.usageRecordUri = usageRecordUri;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getApiVersion() {
            return this.apiVersion;
        }
        public final HttpMethod getCallbackMethod() {
            return this.callbackMethod;
        }
        public final URI getCallbackUrl() {
            return this.callbackUrl;
        }
        public final String getCurrentValue() {
            return this.currentValue;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateFired() {
            return this.dateFired;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final Trigger.Recurring getRecurring() {
            return this.recurring;
        }
        public final String getSid() {
            return this.sid;
        }
        public final Trigger.TriggerField getTriggerBy() {
            return this.triggerBy;
        }
        public final String getTriggerValue() {
            return this.triggerValue;
        }
        public final String getUri() {
            return this.uri;
        }
        public final Trigger.UsageCategory getUsageCategory() {
            return this.usageCategory;
        }
        public final String getUsageRecordUri() {
            return this.usageRecordUri;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Trigger other = (Trigger) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(apiVersion, other.apiVersion) &&  Objects.equals(callbackMethod, other.callbackMethod) &&  Objects.equals(callbackUrl, other.callbackUrl) &&  Objects.equals(currentValue, other.currentValue) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateFired, other.dateFired) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(recurring, other.recurring) &&  Objects.equals(sid, other.sid) &&  Objects.equals(triggerBy, other.triggerBy) &&  Objects.equals(triggerValue, other.triggerValue) &&  Objects.equals(uri, other.uri) &&  Objects.equals(usageCategory, other.usageCategory) &&  Objects.equals(usageRecordUri, other.usageRecordUri)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, apiVersion, callbackMethod, callbackUrl, currentValue, dateCreated, dateFired, dateUpdated, friendlyName, recurring, sid, triggerBy, triggerValue, uri, usageCategory, usageRecordUri);
    }

}

