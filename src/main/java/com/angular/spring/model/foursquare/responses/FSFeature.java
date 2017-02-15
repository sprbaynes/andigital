package com.angular.spring.model.foursquare.responses;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSFeature {

    private String cc;
    private String name;
    private String displayName;
    private String matchedName;
    private String highlightedName;
    private String woeType;
    private String slug;
    private String id;
    private String longId;
    private FSGeometry geometry;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMatchedName() {
        return matchedName;
    }

    public void setMatchedName(String matchedName) {
        this.matchedName = matchedName;
    }

    public String getHighlightedName() {
        return highlightedName;
    }

    public void setHighlightedName(String highlightedName) {
        this.highlightedName = highlightedName;
    }

    public String getWoeType() {
        return woeType;
    }

    public void setWoeType(String woeType) {
        this.woeType = woeType;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongId() {
        return longId;
    }

    public void setLongId(String longId) {
        this.longId = longId;
    }

    public FSGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(FSGeometry geometry) {
        this.geometry = geometry;
    }
}
