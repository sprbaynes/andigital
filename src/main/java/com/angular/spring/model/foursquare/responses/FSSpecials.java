package com.angular.spring.model.foursquare.responses;

import java.util.List;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSSpecials {

    private Integer count;
    private List<FSItem> items;

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
