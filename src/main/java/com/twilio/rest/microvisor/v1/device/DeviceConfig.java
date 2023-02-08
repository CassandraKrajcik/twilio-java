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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Objects;



@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class DeviceConfig extends Resource {
    private static final long serialVersionUID = 4121523224128L;

    public static DeviceConfigCreator creator(final String pathDeviceSid, final String key, final String value){
        return new DeviceConfigCreator(pathDeviceSid, key, value);
    }

    public static DeviceConfigDeleter deleter(final String pathDeviceSid, final String pathKey){
        return new DeviceConfigDeleter(pathDeviceSid, pathKey);
    }

    public static DeviceConfigFetcher fetcher(final String pathDeviceSid, final String pathKey){
        return new DeviceConfigFetcher(pathDeviceSid, pathKey);
    }

    public static DeviceConfigReader reader(final String pathDeviceSid){
        return new DeviceConfigReader(pathDeviceSid);
    }

    /**
    * Converts a JSON String into a DeviceConfig object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return DeviceConfig object represented by the provided JSON
    */
    public static DeviceConfig fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DeviceConfig.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a DeviceConfig object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return DeviceConfig object represented by the provided JSON
    */
    public static DeviceConfig fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DeviceConfig.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String deviceSid;
    private final String key;
    private final String value;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private DeviceConfig(
        @JsonProperty("device_sid")
        final String deviceSid,

        @JsonProperty("key")
        final String key,

        @JsonProperty("value")
        final String value,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("url")
        final URI url
    ) {
        this.deviceSid = deviceSid;
        this.key = key;
        this.value = value;
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

        public final String getDeviceSid() {
            return this.deviceSid;
        }
        public final String getKey() {
            return this.key;
        }
        public final String getValue() {
            return this.value;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final URI getUrl() {
            return this.url;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DeviceConfig other = (DeviceConfig) o;

        return Objects.equals(deviceSid, other.deviceSid) &&  Objects.equals(key, other.key) &&  Objects.equals(value, other.value) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceSid, key, value, dateUpdated, url);
    }

}
