package com.angular.spring.services;

import com.angular.spring.model.foursquare.responses.FSLocationsResponse;
import com.angular.spring.model.responses.Location;
import com.angular.spring.model.responses.LocationsResponse;
import com.sun.tools.javac.file.Locations;

import java.util.List;

/**
 * Created by baynescorps on 15/02/2017.
 */
public interface LocationsFormatterService {
    public LocationsResponse getNativeLocations(FSLocationsResponse response);
}
