/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Microvisor
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.microvisor.v1.device;

import com.twilio.base.Updater;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class DeviceConfigUpdater extends Updater<DeviceConfig> {

    private String pathDeviceSid;
    private String pathKey;
    private String value;

    public DeviceConfigUpdater(
        final String pathDeviceSid,
        final String pathKey,
        final String value
    ) {
        this.pathDeviceSid = pathDeviceSid;
        this.pathKey = pathKey;
        this.value = value;
    }

    public DeviceConfigUpdater setValue(final String value) {
        this.value = value;
        return this;
    }

    @Override
    public DeviceConfig update(final TwilioRestClient client) {
        String path = "/v1/Devices/{DeviceSid}/Configs/{Key}";

        path =
            path.replace(
                "{" + "DeviceSid" + "}",
                this.pathDeviceSid.toString()
            );
        path = path.replace("{" + "Key" + "}", this.pathKey.toString());
        path = path.replace("{" + "Value" + "}", this.value.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.MICROVISOR.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "DeviceConfig update failed: Unable to connect to server"
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

        return DeviceConfig.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (value != null) {
            request.addPostParam("Value", value);
        }
    }
}
