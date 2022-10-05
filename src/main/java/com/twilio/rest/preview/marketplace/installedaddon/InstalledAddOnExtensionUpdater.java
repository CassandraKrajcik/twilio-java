/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Preview
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.preview.marketplace.installedaddon;

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
    * Twilio - Preview
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.36.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class InstalledAddOnExtensionUpdater extends Updater<InstalledAddOnExtension>{
    private String installedAddOnSid;
    private String sid;
    private Boolean enabled;

    public InstalledAddOnExtensionUpdater(final String installedAddOnSid, final String sid, final Boolean enabled){
        this.installedAddOnSid = installedAddOnSid;
        this.sid = sid;
        this.enabled = enabled;
    }

    public InstalledAddOnExtensionUpdater setEnabled(final Boolean enabled){
        this.enabled = enabled;
        return this;
    }

    @Override
    public InstalledAddOnExtension update(final TwilioRestClient client){
        String path = "/marketplace/InstalledAddOns/{InstalledAddOnSid}/Extensions/{Sid}";

        path = path.replace("{"+"InstalledAddOnSid"+"}", this.installedAddOnSid.toString());
        path = path.replace("{"+"Sid"+"}", this.sid.toString());
        path = path.replace("{"+"Enabled"+"}", this.enabled.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("InstalledAddOnExtension update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return InstalledAddOnExtension.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());
    
        }
    }
}
