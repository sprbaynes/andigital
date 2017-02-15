package com.angular.spring.services.impl;

import com.angular.spring.model.foursquare.responses.FSLocationsResponse;
import com.angular.spring.model.responses.LocationsResponse;
import com.angular.spring.services.LocationsFormatterService;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class LocationsFormatterServiceImpl implements LocationsFormatterService {


    @Override
    public LocationsResponse getNativeLocations(FSLocationsResponse response) {
        return null;
    }
}
