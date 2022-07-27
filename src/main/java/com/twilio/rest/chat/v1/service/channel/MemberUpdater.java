/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Chat
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.chat.v1.service.channel;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;





/*
    * Twilio - Chat
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.32.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class MemberUpdater extends Updater<Member>{
    private String serviceSid;
    private String channelSid;
    private String sid;
    private String roleSid;
    private Integer lastConsumedMessageIndex;

    public MemberUpdater(final String serviceSid, final String channelSid, final String sid){
        this.serviceSid = serviceSid;
        this.channelSid = channelSid;
        this.sid = sid;
    }

    public MemberUpdater setRoleSid(final String roleSid){
        this.roleSid = roleSid;
        return this;
    }
    public MemberUpdater setLastConsumedMessageIndex(final Integer lastConsumedMessageIndex){
        this.lastConsumedMessageIndex = lastConsumedMessageIndex;
        return this;
    }

    @Override
    public Member update(final TwilioRestClient client){
        String path = "/v1/Services/{ServiceSid}/Channels/{ChannelSid}/Members/{Sid}";

        path = path.replace("{"+"ServiceSid"+"}", this.serviceSid.toString());
        path = path.replace("{"+"ChannelSid"+"}", this.channelSid.toString());
        path = path.replace("{"+"Sid"+"}", this.sid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.CHAT.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Member update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Member.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);
    
        }
        if (lastConsumedMessageIndex != null) {
            request.addPostParam("LastConsumedMessageIndex", lastConsumedMessageIndex.toString());
    
        }
    }
}
