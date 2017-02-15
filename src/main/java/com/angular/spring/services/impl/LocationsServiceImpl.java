package com.angular.spring.services.impl;

import com.angular.spring.model.requests.LocationsRequest;
import com.angular.spring.model.responses.LocationsResponse;
import com.angular.spring.services.LocationsService;
import org.springframework.stereotype.Service;

/**
 * Created by baynescorps on 15/02/2017.
 */
@Service("locationsService")
public class LocationsServiceImpl implements LocationsService {
    @Override
    public LocationsResponse getLocations(LocationsRequest request) {
        return null;
    }
}
