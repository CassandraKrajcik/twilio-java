/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Voice
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.voice.v1.dialingpermissions;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;





/*
    * Twilio - Voice
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.36.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class BulkCountryUpdateCreator extends Creator<BulkCountryUpdate>{
    private String updateRequest;

    public BulkCountryUpdateCreator(final String updateRequest) {
        this.updateRequest = updateRequest;
    }

    public BulkCountryUpdateCreator setUpdateRequest(final String updateRequest){
        this.updateRequest = updateRequest;
        return this;
    }

    @Override
    public BulkCountryUpdate create(final TwilioRestClient client){
        String path = "/v1/DialingPermissions/BulkCountryUpdates";

        path = path.replace("{"+"UpdateRequest"+"}", this.updateRequest.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.VOICE.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("BulkCountryUpdate creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return BulkCountryUpdate.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (updateRequest != null) {
            request.addPostParam("UpdateRequest", updateRequest);
    
        }
    }
}
