/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.microvisor.v1;

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
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class App extends Resource {
    private static final long serialVersionUID = 38264652240065L;

    /**
     * Create a AppReader to execute read.
     *
     * @return AppReader capable of executing the read
     */
    public static AppReader reader() {
        return new AppReader();
    }

    /**
     * Create a AppFetcher to execute fetch.
     *
     * @param pathSid A string that uniquely identifies this App.
     * @return AppFetcher capable of executing the fetch
     */
    public static AppFetcher fetcher(final String pathSid) {
        return new AppFetcher(pathSid);
    }

    /**
     * Create a AppDeleter to execute delete.
     *
     * @param pathSid A string that uniquely identifies this App.
     * @return AppDeleter capable of executing the delete
     */
    public static AppDeleter deleter(final String pathSid) {
        return new AppDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a App object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return App object represented by the provided JSON
     */
    public static App fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, App.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a App object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return App object represented by the provided JSON
     */
    public static App fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, App.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String hash;
    private final String uniqueName;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private App(@JsonProperty("sid")
                final String sid,
                @JsonProperty("account_sid")
                final String accountSid,
                @JsonProperty("hash")
                final String hash,
                @JsonProperty("unique_name")
                final String uniqueName,
                @JsonProperty("date_created")
                final String dateCreated,
                @JsonProperty("date_updated")
                final String dateUpdated,
                @JsonProperty("url")
                final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.hash = hash;
        this.uniqueName = uniqueName;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    /**
     * Returns A string that uniquely identifies this App..
     *
     * @return A string that uniquely identifies this App.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The Account SID..
     *
     * @return The Account SID.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns App manifest hash represented as hash_algorithm:hash_value..
     *
     * @return App manifest hash represented as hash_algorithm:hash_value.
     */
    public final String getHash() {
        return this.hash;
    }

    /**
     * Returns An developer-defined string that uniquely identifies the App..
     *
     * @return An developer-defined string that uniquely identifies the App.
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The date that this App was created..
     *
     * @return The date that this App was created.
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The date that this App was last updated..
     *
     * @return The date that this App was last updated.
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The URL of this resource..
     *
     * @return The URL of this resource.
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        App other = (App) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(hash, other.hash) &&
               Objects.equals(uniqueName, other.uniqueName) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            hash,
                            uniqueName,
                            dateCreated,
                            dateUpdated,
                            url);
    }
}