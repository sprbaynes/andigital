package com.angular.spring.model.responses;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class Venue {
    private String name;
    private String phone;
    private double lat;
    private double lng;
    private Integer distance;

    private String address;
    private String city;
    private String state;
    private String postcode;
    private String countryCode;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venue venue = (Venue) o;

        if (Double.compare(venue.lat, lat) != 0) return false;
        if (Double.compare(venue.lng, lng) != 0) return false;
        if (name != null ? !name.equals(venue.name) : venue.name != null) return false;
        if (phone != null ? !phone.equals(venue.phone) : venue.phone != null) return false;
        if (distance != null ? !distance.equals(venue.distance) : venue.distance != null) return false;
        if (address != null ? !address.equals(venue.address) : venue.address != null) return false;
        if (city != null ? !city.equals(venue.city) : venue.city != null) return false;
        if (state != null ? !state.equals(venue.state) : venue.state != null) return false;
        if (postcode != null ? !postcode.equals(venue.postcode) : venue.postcode != null) return false;
        if (countryCode != null ? !countryCode.equals(venue.countryCode) : venue.countryCode != null) return false;
        return !(country != null ? !country.equals(venue.country) : venue.country != null);

    }
}
