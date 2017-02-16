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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationsResponse that = (LocationsResponse) o;

        if (meta != null ? !meta.equals(that.meta) : that.meta != null) return false;
        return !(locations != null ? !locations.equals(that.locations) : that.locations != null);

    }
}
