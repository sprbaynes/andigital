package com.angular.spring.model.foursquare.responses;

import java.util.List;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSHereNow {

    private Integer count;
    private String summary;
    private List<FSGroup> groups;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<FSGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<FSGroup> groups) {
        this.groups = groups;
    }
}
