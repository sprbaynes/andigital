package com.angular.spring.model.requests;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class LocationsRequest {
    private String query;
    private int results;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }
}
