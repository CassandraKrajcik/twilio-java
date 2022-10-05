/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Studio
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.studio.v1.flow;

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
    * Twilio - Studio
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.36.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class ExecutionUpdater extends Updater<Execution>{
    private String flowSid;
    private String sid;
    private Execution.Status status;

    public ExecutionUpdater(final String flowSid, final String sid, final Execution.Status status){
        this.flowSid = flowSid;
        this.sid = sid;
        this.status = status;
    }

    public ExecutionUpdater setStatus(final Execution.Status status){
        this.status = status;
        return this;
    }

    @Override
    public Execution update(final TwilioRestClient client){
        String path = "/v1/Flows/{FlowSid}/Executions/{Sid}";

        path = path.replace("{"+"FlowSid"+"}", this.flowSid.toString());
        path = path.replace("{"+"Sid"+"}", this.sid.toString());
        path = path.replace("{"+"Status"+"}", this.status.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.STUDIO.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Execution update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Execution.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (status != null) {
            request.addPostParam("Status", status.toString());
    
        }
    }
}
