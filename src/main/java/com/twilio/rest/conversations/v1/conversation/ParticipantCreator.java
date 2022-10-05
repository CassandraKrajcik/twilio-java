/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1.conversation;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.time.ZonedDateTime;





/*
    * Twilio - Conversations
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.36.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class ParticipantCreator extends Creator<Participant>{
    private String conversationSid;
    private Participant.WebhookEnabledType xTwilioWebhookEnabled;
    private String identity;
    private String messagingBindingAddress;
    private String messagingBindingProxyAddress;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateUpdated;
    private String attributes;
    private String messagingBindingProjectedAddress;
    private String roleSid;

    public ParticipantCreator(final String conversationSid) {
        this.conversationSid = conversationSid;
    }

    public ParticipantCreator setXTwilioWebhookEnabled(final Participant.WebhookEnabledType xTwilioWebhookEnabled){
        this.xTwilioWebhookEnabled = xTwilioWebhookEnabled;
        return this;
    }
    public ParticipantCreator setIdentity(final String identity){
        this.identity = identity;
        return this;
    }
    public ParticipantCreator setMessagingBindingAddress(final String messagingBindingAddress){
        this.messagingBindingAddress = messagingBindingAddress;
        return this;
    }
    public ParticipantCreator setMessagingBindingProxyAddress(final String messagingBindingProxyAddress){
        this.messagingBindingProxyAddress = messagingBindingProxyAddress;
        return this;
    }
    public ParticipantCreator setDateCreated(final ZonedDateTime dateCreated){
        this.dateCreated = dateCreated;
        return this;
    }
    public ParticipantCreator setDateUpdated(final ZonedDateTime dateUpdated){
        this.dateUpdated = dateUpdated;
        return this;
    }
    public ParticipantCreator setAttributes(final String attributes){
        this.attributes = attributes;
        return this;
    }
    public ParticipantCreator setMessagingBindingProjectedAddress(final String messagingBindingProjectedAddress){
        this.messagingBindingProjectedAddress = messagingBindingProjectedAddress;
        return this;
    }
    public ParticipantCreator setRoleSid(final String roleSid){
        this.roleSid = roleSid;
        return this;
    }

    @Override
    public Participant create(final TwilioRestClient client){
        String path = "/v1/Conversations/{ConversationSid}/Participants";

        path = path.replace("{"+"ConversationSid"+"}", this.conversationSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.CONVERSATIONS.toString(),
            path
        );
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Participant creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Participant.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (identity != null) {
            request.addPostParam("Identity", identity);
    
        }
        if (messagingBindingAddress != null) {
            request.addPostParam("MessagingBinding.Address", messagingBindingAddress);
    
        }
        if (messagingBindingProxyAddress != null) {
            request.addPostParam("MessagingBinding.ProxyAddress", messagingBindingProxyAddress);
    
        }
        if (dateCreated != null) {
            request.addPostParam("DateCreated", dateCreated.toInstant().toString());

        }
        if (dateUpdated != null) {
            request.addPostParam("DateUpdated", dateUpdated.toInstant().toString());

        }
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
    
        }
        if (messagingBindingProjectedAddress != null) {
            request.addPostParam("MessagingBinding.ProjectedAddress", messagingBindingProjectedAddress);
    
        }
        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);
    
        }
    }
    private void addHeaderParams(final Request request) {
        if (xTwilioWebhookEnabled != null) {
            request.addHeaderParam("X-Twilio-Webhook-Enabled", xTwilioWebhookEnabled.toString());

        }
    }
}
