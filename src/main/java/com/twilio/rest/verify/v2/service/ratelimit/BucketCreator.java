/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Verify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.verify.v2.service.ratelimit;

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
    * Twilio - Verify
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.36.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class BucketCreator extends Creator<Bucket>{
    private String serviceSid;
    private String rateLimitSid;
    private Integer max;
    private Integer interval;

    public BucketCreator(final String serviceSid, final String rateLimitSid, final Integer max, final Integer interval) {
        this.serviceSid = serviceSid;
        this.rateLimitSid = rateLimitSid;
        this.max = max;
        this.interval = interval;
    }

    public BucketCreator setMax(final Integer max){
        this.max = max;
        return this;
    }
    public BucketCreator setInterval(final Integer interval){
        this.interval = interval;
        return this;
    }

    @Override
    public Bucket create(final TwilioRestClient client){
        String path = "/v2/Services/{ServiceSid}/RateLimits/{RateLimitSid}/Buckets";

        path = path.replace("{"+"ServiceSid"+"}", this.serviceSid.toString());
        path = path.replace("{"+"RateLimitSid"+"}", this.rateLimitSid.toString());
        path = path.replace("{"+"Max"+"}", this.max.toString());
        path = path.replace("{"+"Interval"+"}", this.interval.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Bucket creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Bucket.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (max != null) {
            request.addPostParam("Max", max.toString());
    
        }
        if (interval != null) {
            request.addPostParam("Interval", interval.toString());
    
        }
    }
}
