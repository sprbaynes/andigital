package com.angular.spring.services.impl;

import com.angular.spring.model.foursquare.responses.FSLocationsResponse;
import com.angular.spring.model.requests.LocationsRequest;
import com.angular.spring.model.responses.LocationsResponse;
import com.angular.spring.services.LocationsFormatterService;
import com.angular.spring.services.LocationsService;
import com.angular.spring.services.foursquare.FSLocationsService;
import com.angular.spring.services.foursquare.FSVenuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by baynescorps on 15/02/2017.
 */
@Service("locationsService")
public class LocationsServiceImpl implements LocationsService {


    @Autowired
    private FSLocationsService fsLocationsService;

    @Autowired
    private LocationsFormatterService locationsFormatterService;

    @Override
    public LocationsResponse getLocations(LocationsRequest request) {
        FSLocationsResponse fsResponse = fsLocationsService.getLocations(request);
        LocationsResponse response = locationsFormatterService.getNativeLocations(fsResponse);

        return response;
    }
}
