package com.angular.spring.model;

/**
 * Created by steven.baynes on 02/02/2016.
 */
public class APIRequest {

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
