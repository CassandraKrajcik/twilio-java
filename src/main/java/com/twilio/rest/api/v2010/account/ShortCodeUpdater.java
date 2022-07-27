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

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;




/*
    * Twilio - Api
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.32.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class ShortCodeUpdater extends Updater<ShortCode>{
    private String sid;
    private String accountSid;
    private String friendlyName;
    private String apiVersion;
    private URI smsUrl;
    private HttpMethod smsMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsFallbackMethod;

    public ShortCodeUpdater(final String sid){
        this.sid = sid;
    }
    public ShortCodeUpdater(final String accountSid, final String sid){
        this.accountSid = accountSid;
        this.sid = sid;
    }

    public ShortCodeUpdater setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public ShortCodeUpdater setApiVersion(final String apiVersion){
        this.apiVersion = apiVersion;
        return this;
    }
    public ShortCodeUpdater setSmsUrl(final URI smsUrl){
        this.smsUrl = smsUrl;
        return this;
    }

    public ShortCodeUpdater setSmsUrl(final String smsUrl){
    this.smsUrl = Promoter.uriFromString(smsUrl);
    return this;
    }
    public ShortCodeUpdater setSmsMethod(final HttpMethod smsMethod){
        this.smsMethod = smsMethod;
        return this;
    }
    public ShortCodeUpdater setSmsFallbackUrl(final URI smsFallbackUrl){
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    public ShortCodeUpdater setSmsFallbackUrl(final String smsFallbackUrl){
    this.smsFallbackUrl = Promoter.uriFromString(smsFallbackUrl);
    return this;
    }
    public ShortCodeUpdater setSmsFallbackMethod(final HttpMethod smsFallbackMethod){
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    @Override
    public ShortCode update(final TwilioRestClient client){
        String path = "/2010-04-01/Accounts/{AccountSid}/SMS/ShortCodes/{Sid}.json";

        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        path = path.replace("{"+"AccountSid"+"}", this.accountSid.toString());
        path = path.replace("{"+"Sid"+"}", this.sid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("ShortCode update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ShortCode.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);
    
        }
        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());
    
        }
        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());
    
        }
        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());
    
        }
        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());
    
        }
    }
}
