package com.angular.spring.model.foursquare.responses;

import java.util.List;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSInternalVenuesResponse {
    private List<FSVenue> venues;

    public List<FSVenue> getVenues() {
        return venues;
    }

    public void setVenues(List<FSVenue> venues) {
        this.venues = venues;
    }
}
