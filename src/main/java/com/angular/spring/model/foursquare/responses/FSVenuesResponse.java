package com.angular.spring.model.foursquare.responses;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSVenuesResponse {
    private FSMeta meta;
    private FSInternalVenuesResponse response;

    public FSMeta getMeta() {
        return meta;
    }

    public void setMeta(FSMeta meta) {
        this.meta = meta;
    }

    public FSInternalVenuesResponse getResponse() {
        return response;
    }

    public void setResponse(FSInternalVenuesResponse response) {
        this.response = response;
    }
}
