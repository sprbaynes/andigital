package com.angular.spring.model.foursquare.responses;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSGeometry {
    private FSLatLng center;
    private FSBounds bounds;

    public FSLatLng getCenter() {
        return center;
    }

    public void setCenter(FSLatLng center) {
        this.center = center;
    }

    public FSBounds getBounds() {
        return bounds;
    }

    public void setBounds(FSBounds bounds) {
        this.bounds = bounds;
    }
}
