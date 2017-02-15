package com.angular.spring.model.foursquare.responses;

import java.util.List;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSVenue {

    private String id;
    private String name;
    private FSContact contact;
    private FSLocation location;
    private List<FSCategory> categories;
    private Boolean verified;
    private FSStats stats;
    private String url;
    private Boolean allowMenuUrlEdit;
    private FSBeenHere beenHere;
    private FSSpecials specials;
    private FSHereNow hereNow;
    private String referralId;
    private List<FSVenueChain> venueChains;
    private Boolean hasPerk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FSContact getContact() {
        return contact;
    }

    public void setContact(FSContact contact) {
        this.contact = contact;
    }

    public FSLocation getLocation() {
        return location;
    }

    public void setLocation(FSLocation location) {
        this.location = location;
    }

    public List<FSCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<FSCategory> categories) {
        this.categories = categories;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public FSStats getStats() {
        return stats;
    }

    public void setStats(FSStats stats) {
        this.stats = stats;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public FSBeenHere getBeenHere() {
        return beenHere;
    }

    public void setBeenHere(FSBeenHere beenHere) {
        this.beenHere = beenHere;
    }

    public FSSpecials getSpecials() {
        return specials;
    }

    public void setSpecials(FSSpecials specials) {
        this.specials = specials;
    }

    public FSHereNow getHereNow() {
        return hereNow;
    }

    public void setHereNow(FSHereNow hereNow) {
        this.hereNow = hereNow;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public List<FSVenueChain> getVenueChains() {
        return venueChains;
    }

    public void setVenueChains(List<FSVenueChain> venueChains) {
        this.venueChains = venueChains;
    }

    public Boolean getHasPerk() {
        return hasPerk;
    }

    public void setHasPerk(Boolean hasPerk) {
        this.hasPerk = hasPerk;
    }
}
