package com.angular.spring.model.foursquare.responses;

import java.util.List;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSItem {

    private String what;
    private String where;
    private FSFeature feature;
    private List<FSParent> parents;


    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public FSFeature getFeature() {
        return feature;
    }

    public void setFeature(FSFeature feature) {
        this.feature = feature;
    }

    public List<FSParent> getParents() {
        return parents;
    }

    public void setParents(List<FSParent> parents) {
        this.parents = parents;
    }
}
