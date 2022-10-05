/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Autopilot
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.autopilot.v1.assistant;

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
    * Twilio - Autopilot
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.36.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class ModelBuildReader extends Reader<ModelBuild> {
    private String assistantSid;
    private Integer pageSize;

    public ModelBuildReader(final String assistantSid){
        this.assistantSid = assistantSid;
    }

    public ModelBuildReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<ModelBuild> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<ModelBuild> firstPage(final TwilioRestClient client) {
        String path = "/v1/Assistants/{AssistantSid}/ModelBuilds";
        path = path.replace("{"+"AssistantSid"+"}", this.assistantSid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.AUTOPILOT.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<ModelBuild> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ModelBuild read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "model_builds",
            response.getContent(),
            ModelBuild.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<ModelBuild> previousPage(final Page<ModelBuild> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.AUTOPILOT.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<ModelBuild> nextPage(final Page<ModelBuild> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.AUTOPILOT.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<ModelBuild> getPage(final String targetUrl, final TwilioRestClient client) {
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

