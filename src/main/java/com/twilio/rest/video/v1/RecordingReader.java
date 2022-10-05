/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Video
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.video.v1;

import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.base.Page;
import java.time.ZonedDateTime;

import java.util.List;




/*
    * Twilio - Video
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.36.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class RecordingReader extends Reader<Recording> {
    private Recording.Status status;
    private String sourceSid;
    private List<String> groupingSid;
    private ZonedDateTime dateCreatedAfter;
    private ZonedDateTime dateCreatedBefore;
    private Recording.Type mediaType;
    private Integer pageSize;

    public RecordingReader(){
    }

    public RecordingReader setStatus(final Recording.Status status){
        this.status = status;
        return this;
    }
    public RecordingReader setSourceSid(final String sourceSid){
        this.sourceSid = sourceSid;
        return this;
    }
    public RecordingReader setGroupingSid(final List<String> groupingSid){
        this.groupingSid = groupingSid;
        return this;
    }
    public RecordingReader setGroupingSid(final String groupingSid){
        return setGroupingSid(Promoter.listOfOne(groupingSid));
    }
    public RecordingReader setDateCreatedAfter(final ZonedDateTime dateCreatedAfter){
        this.dateCreatedAfter = dateCreatedAfter;
        return this;
    }
    public RecordingReader setDateCreatedBefore(final ZonedDateTime dateCreatedBefore){
        this.dateCreatedBefore = dateCreatedBefore;
        return this;
    }
    public RecordingReader setMediaType(final Recording.Type mediaType){
        this.mediaType = mediaType;
        return this;
    }
    public RecordingReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Recording> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Recording> firstPage(final TwilioRestClient client) {
        String path = "/v1/Recordings";

        Request request = new Request(
            HttpMethod.GET,
            Domains.VIDEO.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Recording> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Recording read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "recordings",
            response.getContent(),
            Recording.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Recording> previousPage(final Page<Recording> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.VIDEO.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<Recording> nextPage(final Page<Recording> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.VIDEO.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Recording> getPage(final String targetUrl, final TwilioRestClient client) {
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
        if (sourceSid != null) {
    
            request.addQueryParam("SourceSid", sourceSid);
        }
        if (groupingSid != null) {
            for (String prop : groupingSid) {
                request.addQueryParam("GroupingSid", prop);
            }
        }
        if (dateCreatedAfter != null) {
            request.addQueryParam("DateCreatedAfter", dateCreatedAfter.toInstant().toString());
        }

        if (dateCreatedBefore != null) {
            request.addQueryParam("DateCreatedBefore", dateCreatedBefore.toInstant().toString());
        }

        if (mediaType != null) {
    
            request.addQueryParam("MediaType", mediaType.toString());
        }
        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }
    }
}

