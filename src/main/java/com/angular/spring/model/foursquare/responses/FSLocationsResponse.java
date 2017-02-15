package com.angular.spring.model.foursquare.responses;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSLocationsResponse {

    private FSMeta meta;
    private FSInternalLocationsResponse response;

    public FSMeta getMeta() {
        return meta;
    }

    public void setMeta(FSMeta meta) {
        this.meta = meta;
    }

    public FSInternalLocationsResponse getResponse() {
        return response;
    }

    public void setResponse(FSInternalLocationsResponse response) {
        this.response = response;
    }
}
