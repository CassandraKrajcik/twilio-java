/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Media
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.media.v1;

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
    * Twilio - Media
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.36.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class MediaRecordingReader extends Reader<MediaRecording> {
    private MediaRecording.Order order;
    private MediaRecording.Status status;
    private String processorSid;
    private String sourceSid;
    private Integer pageSize;

    public MediaRecordingReader(){
    }

    public MediaRecordingReader setOrder(final MediaRecording.Order order){
        this.order = order;
        return this;
    }
    public MediaRecordingReader setStatus(final MediaRecording.Status status){
        this.status = status;
        return this;
    }
    public MediaRecordingReader setProcessorSid(final String processorSid){
        this.processorSid = processorSid;
        return this;
    }
    public MediaRecordingReader setSourceSid(final String sourceSid){
        this.sourceSid = sourceSid;
        return this;
    }
    public MediaRecordingReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<MediaRecording> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<MediaRecording> firstPage(final TwilioRestClient client) {
        String path = "/v1/MediaRecordings";

        Request request = new Request(
            HttpMethod.GET,
            Domains.MEDIA.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<MediaRecording> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("MediaRecording read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "media_recordings",
            response.getContent(),
            MediaRecording.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<MediaRecording> previousPage(final Page<MediaRecording> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.MEDIA.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<MediaRecording> nextPage(final Page<MediaRecording> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.MEDIA.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<MediaRecording> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (order != null) {
    
            request.addQueryParam("Order", order.toString());
        }
        if (status != null) {
    
            request.addQueryParam("Status", status.toString());
        }
        if (processorSid != null) {
    
            request.addQueryParam("ProcessorSid", processorSid);
        }
        if (sourceSid != null) {
    
            request.addQueryParam("SourceSid", sourceSid);
        }
        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }
    }
}

