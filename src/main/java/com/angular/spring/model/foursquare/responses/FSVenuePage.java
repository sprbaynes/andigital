package com.angular.spring.model.foursquare.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSVenuePage {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
