package com.angular.spring.model.responses;

import java.util.List;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class LocationsResponse {
    private APIMeta meta;
    private List<Location> locations;

    public APIMeta getMeta() {
        return meta;
    }

    public void setMeta(APIMeta meta) {
        this.meta = meta;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
