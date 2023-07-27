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

package com.twilio.rest.voice.v1.connectionpolicy;

import com.twilio.base.Updater;
import com.twilio.constant.EnumConstants;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.net.URI;

public class ConnectionPolicyTargetUpdater
    extends Updater<ConnectionPolicyTarget> {

    private String pathConnectionPolicySid;
    private String pathSid;
    private String friendlyName;
    private URI target;
    private Integer priority;
    private Integer weight;
    private Boolean enabled;

    public ConnectionPolicyTargetUpdater(
        final String pathConnectionPolicySid,
        final String pathSid
    ) {
        this.pathConnectionPolicySid = pathConnectionPolicySid;
        this.pathSid = pathSid;
    }

    public ConnectionPolicyTargetUpdater setFriendlyName(
        final String friendlyName
    ) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ConnectionPolicyTargetUpdater setTarget(final URI target) {
        this.target = target;
        return this;
    }

    public ConnectionPolicyTargetUpdater setTarget(final String target) {
        return setTarget(Promoter.uriFromString(target));
    }

    public ConnectionPolicyTargetUpdater setPriority(final Integer priority) {
        this.priority = priority;
        return this;
    }

    public ConnectionPolicyTargetUpdater setWeight(final Integer weight) {
        this.weight = weight;
        return this;
    }

    public ConnectionPolicyTargetUpdater setEnabled(final Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @Override
    public ConnectionPolicyTarget update(final TwilioRestClient client) {
        String path =
            "/v1/ConnectionPolicies/{ConnectionPolicySid}/Targets/{Sid}";

        path =
            path.replace(
                "{" + "ConnectionPolicySid" + "}",
                this.pathConnectionPolicySid.toString()
            );
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.VOICE.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "ConnectionPolicyTarget update failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ConnectionPolicyTarget.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        if (target != null) {
            request.addPostParam("Target", target.toString());
        }
        if (priority != null) {
            request.addPostParam("Priority", priority.toString());
        }
        if (weight != null) {
            request.addPostParam("Weight", weight.toString());
        }
        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());
        }
    }
}
