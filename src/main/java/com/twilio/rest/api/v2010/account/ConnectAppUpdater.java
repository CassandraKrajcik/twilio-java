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

import java.util.List;



/*
    * Twilio - Api
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.36.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class ConnectAppUpdater extends Updater<ConnectApp>{
    private String sid;
    private String accountSid;
    private URI authorizeRedirectUrl;
    private String companyName;
    private HttpMethod deauthorizeCallbackMethod;
    private URI deauthorizeCallbackUrl;
    private String description;
    private String friendlyName;
    private URI homepageUrl;
    private List<ConnectApp.Permission> permissions;

    public ConnectAppUpdater(final String sid){
        this.sid = sid;
    }
    public ConnectAppUpdater(final String accountSid, final String sid){
        this.accountSid = accountSid;
        this.sid = sid;
    }

    public ConnectAppUpdater setAuthorizeRedirectUrl(final URI authorizeRedirectUrl){
        this.authorizeRedirectUrl = authorizeRedirectUrl;
        return this;
    }

    public ConnectAppUpdater setAuthorizeRedirectUrl(final String authorizeRedirectUrl){
        return setAuthorizeRedirectUrl(Promoter.uriFromString(authorizeRedirectUrl));
    }
    public ConnectAppUpdater setCompanyName(final String companyName){
        this.companyName = companyName;
        return this;
    }
    public ConnectAppUpdater setDeauthorizeCallbackMethod(final HttpMethod deauthorizeCallbackMethod){
        this.deauthorizeCallbackMethod = deauthorizeCallbackMethod;
        return this;
    }
    public ConnectAppUpdater setDeauthorizeCallbackUrl(final URI deauthorizeCallbackUrl){
        this.deauthorizeCallbackUrl = deauthorizeCallbackUrl;
        return this;
    }

    public ConnectAppUpdater setDeauthorizeCallbackUrl(final String deauthorizeCallbackUrl){
        return setDeauthorizeCallbackUrl(Promoter.uriFromString(deauthorizeCallbackUrl));
    }
    public ConnectAppUpdater setDescription(final String description){
        this.description = description;
        return this;
    }
    public ConnectAppUpdater setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public ConnectAppUpdater setHomepageUrl(final URI homepageUrl){
        this.homepageUrl = homepageUrl;
        return this;
    }

    public ConnectAppUpdater setHomepageUrl(final String homepageUrl){
        return setHomepageUrl(Promoter.uriFromString(homepageUrl));
    }
    public ConnectAppUpdater setPermissions(final List<ConnectApp.Permission> permissions){
        this.permissions = permissions;
        return this;
    }
    public ConnectAppUpdater setPermissions(final ConnectApp.Permission permissions){
        return setPermissions(Promoter.listOfOne(permissions));
    }

    @Override
    public ConnectApp update(final TwilioRestClient client){
        String path = "/2010-04-01/Accounts/{AccountSid}/ConnectApps/{Sid}.json";

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
            throw new ApiConnectionException("ConnectApp update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ConnectApp.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (authorizeRedirectUrl != null) {
            request.addPostParam("AuthorizeRedirectUrl", authorizeRedirectUrl.toString());
    
        }
        if (companyName != null) {
            request.addPostParam("CompanyName", companyName);
    
        }
        if (deauthorizeCallbackMethod != null) {
            request.addPostParam("DeauthorizeCallbackMethod", deauthorizeCallbackMethod.toString());
    
        }
        if (deauthorizeCallbackUrl != null) {
            request.addPostParam("DeauthorizeCallbackUrl", deauthorizeCallbackUrl.toString());
    
        }
        if (description != null) {
            request.addPostParam("Description", description);
    
        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (homepageUrl != null) {
            request.addPostParam("HomepageUrl", homepageUrl.toString());
    
        }
        if (permissions != null) {
            for (ConnectApp.Permission prop : permissions) {
                request.addPostParam("Permissions", prop.toString());
            }
    
        }
    }
}
