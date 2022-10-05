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

package com.twilio.rest.trusthub.v1.customerprofiles;

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


public class CustomerProfilesEntityAssignmentsReader extends Reader<CustomerProfilesEntityAssignments> {
    private String customerProfileSid;
    private Integer pageSize;

    public CustomerProfilesEntityAssignmentsReader(final String customerProfileSid){
        this.customerProfileSid = customerProfileSid;
    }

    public CustomerProfilesEntityAssignmentsReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<CustomerProfilesEntityAssignments> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<CustomerProfilesEntityAssignments> firstPage(final TwilioRestClient client) {
        String path = "/v1/CustomerProfiles/{CustomerProfileSid}/EntityAssignments";
        path = path.replace("{"+"CustomerProfileSid"+"}", this.customerProfileSid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.TRUSTHUB.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<CustomerProfilesEntityAssignments> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("CustomerProfilesEntityAssignments read failed: Unable to connect to server");
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
            CustomerProfilesEntityAssignments.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<CustomerProfilesEntityAssignments> previousPage(final Page<CustomerProfilesEntityAssignments> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.TRUSTHUB.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<CustomerProfilesEntityAssignments> nextPage(final Page<CustomerProfilesEntityAssignments> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.TRUSTHUB.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<CustomerProfilesEntityAssignments> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }
    }
}

