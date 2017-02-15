package com.angular.spring.model.foursquare.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class FSContact {
    private String phone;
    private String formattedPhone;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String twitter;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String facebook;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String facebookUsername;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String facebookName;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFormattedPhone() {
        return formattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebookUsername() {
        return facebookUsername;
    }

    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }
}
