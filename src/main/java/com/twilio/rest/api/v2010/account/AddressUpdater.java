/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account;

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
    * Twilio - Api
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.32.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class AddressUpdater extends Updater<Address>{
    private String sid;
    private String accountSid;
    private String friendlyName;
    private String customerName;
    private String street;
    private String city;
    private String region;
    private String postalCode;
    private Boolean emergencyEnabled;
    private Boolean autoCorrectAddress;

    public AddressUpdater(final String sid){
        this.sid = sid;
    }
    public AddressUpdater(final String accountSid, final String sid){
        this.accountSid = accountSid;
        this.sid = sid;
    }

    public AddressUpdater setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public AddressUpdater setCustomerName(final String customerName){
        this.customerName = customerName;
        return this;
    }
    public AddressUpdater setStreet(final String street){
        this.street = street;
        return this;
    }
    public AddressUpdater setCity(final String city){
        this.city = city;
        return this;
    }
    public AddressUpdater setRegion(final String region){
        this.region = region;
        return this;
    }
    public AddressUpdater setPostalCode(final String postalCode){
        this.postalCode = postalCode;
        return this;
    }
    public AddressUpdater setEmergencyEnabled(final Boolean emergencyEnabled){
        this.emergencyEnabled = emergencyEnabled;
        return this;
    }
    public AddressUpdater setAutoCorrectAddress(final Boolean autoCorrectAddress){
        this.autoCorrectAddress = autoCorrectAddress;
        return this;
    }

    @Override
    public Address update(final TwilioRestClient client){
        String path = "/2010-04-01/Accounts/{AccountSid}/Addresses/{Sid}.json";

        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        path = path.replace("{"+"AccountSid"+"}", this.accountSid.toString());
        path = path.replace("{"+"Sid"+"}", this.sid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Address update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Address.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (customerName != null) {
            request.addPostParam("CustomerName", customerName);
    
        }
        if (street != null) {
            request.addPostParam("Street", street);
    
        }
        if (city != null) {
            request.addPostParam("City", city);
    
        }
        if (region != null) {
            request.addPostParam("Region", region);
    
        }
        if (postalCode != null) {
            request.addPostParam("PostalCode", postalCode);
    
        }
        if (emergencyEnabled != null) {
            request.addPostParam("EmergencyEnabled", emergencyEnabled.toString());
    
        }
        if (autoCorrectAddress != null) {
            request.addPostParam("AutoCorrectAddress", autoCorrectAddress.toString());
    
        }
    }
}
