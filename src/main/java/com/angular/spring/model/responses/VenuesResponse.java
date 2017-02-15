package com.angular.spring.model.responses;

import java.util.List;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class VenuesResponse {

    private APIMeta meta;

    private List<Venue> venues;

    public APIMeta getMeta() {
        return meta;
    }

    public void setMeta(APIMeta meta) {
        this.meta = meta;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }
}
