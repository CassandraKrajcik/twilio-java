/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trusthub
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.trusthub.v1;

import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.base.Page;





/*
    * Twilio - Trusthub
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.36.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class CustomerProfilesReader extends Reader<CustomerProfiles> {
    private CustomerProfiles.Status status;
    private String friendlyName;
    private String policySid;
    private Integer pageSize;

    public CustomerProfilesReader(){
    }

    public CustomerProfilesReader setStatus(final CustomerProfiles.Status status){
        this.status = status;
        return this;
    }
    public CustomerProfilesReader setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public CustomerProfilesReader setPolicySid(final String policySid){
        this.policySid = policySid;
        return this;
    }
    public CustomerProfilesReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<CustomerProfiles> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<CustomerProfiles> firstPage(final TwilioRestClient client) {
        String path = "/v1/CustomerProfiles";

        Request request = new Request(
            HttpMethod.GET,
            Domains.TRUSTHUB.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<CustomerProfiles> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("CustomerProfiles read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "results",
            response.getContent(),
            CustomerProfiles.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<CustomerProfiles> previousPage(final Page<CustomerProfiles> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.TRUSTHUB.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<CustomerProfiles> nextPage(final Page<CustomerProfiles> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.TRUSTHUB.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<CustomerProfiles> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (status != null) {
    
            request.addQueryParam("Status", status.toString());
        }
        if (friendlyName != null) {
    
            request.addQueryParam("FriendlyName", friendlyName);
        }
        if (policySid != null) {
    
            request.addQueryParam("PolicySid", policySid);
        }
        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }
    }
}

