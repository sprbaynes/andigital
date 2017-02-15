package com.angular.spring.model.foursquare.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSGroup {

    /*TODO Find out what this class may contain*/
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer count;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FSItem> items;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<FSItem> getItems() {
        return items;
    }

    public void setItems(List<FSItem> items) {
        this.items = items;
    }
}
