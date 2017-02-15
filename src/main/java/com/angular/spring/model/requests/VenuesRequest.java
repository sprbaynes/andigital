package com.angular.spring.model.requests;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class VenuesRequest {
    private String query;
    private String latitude;
    private String longitude;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
