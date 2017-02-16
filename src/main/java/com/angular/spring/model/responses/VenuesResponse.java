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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VenuesResponse that = (VenuesResponse) o;

        if (meta != null ? !meta.equals(that.meta) : that.meta != null) return false;
        return !(venues != null ? !venues.equals(that.venues) : that.venues != null);

    }
}
