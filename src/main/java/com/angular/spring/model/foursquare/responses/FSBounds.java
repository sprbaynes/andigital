package com.angular.spring.model.foursquare.responses;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSBounds {
    private FSLatLng ne;
    private FSLatLng sw;

    public FSLatLng getNe() {
        return ne;
    }

    public void setNe(FSLatLng ne) {
        this.ne = ne;
    }

    public FSLatLng getSw() {
        return sw;
    }

    public void setSw(FSLatLng sw) {
        this.sw = sw;
    }
}
