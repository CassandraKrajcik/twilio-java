/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Pricing
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.pricing.v2;

import com.twilio.base.Fetcher;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;





/*
    * Twilio - Pricing
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.32.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class NumberFetcher extends Fetcher<Number> {
    private com.twilio.type.PhoneNumber destinationNumber;
    private com.twilio.type.PhoneNumber originationNumber;

    public NumberFetcher(final com.twilio.type.PhoneNumber destinationNumber){
        this.destinationNumber = destinationNumber;
    }

    public NumberFetcher setOriginationNumber(final com.twilio.type.PhoneNumber originationNumber){
    this.originationNumber = originationNumber;
    return this;
    }

    public NumberFetcher setOriginationNumber(final String originationNumber){
    this.originationNumber = Promoter.phoneNumberFromString(originationNumber);
    return this;
    }

    @Override
    public Number fetch(final TwilioRestClient client) {
        String path = "/v2/Trunking/Numbers/{DestinationNumber}";

        path = path.replace("{"+"DestinationNumber"+"}", this.destinationNumber.encode("utf-8"));

        Request request = new Request(
            HttpMethod.GET,
            Domains.PRICING.toString(),
            path
        );
        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
        throw new ApiConnectionException("Number fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Number.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addQueryParams(final Request request) {
        if (originationNumber != null) {
    
            request.addQueryParam("OriginationNumber", originationNumber.toString());
        }
    }
}

