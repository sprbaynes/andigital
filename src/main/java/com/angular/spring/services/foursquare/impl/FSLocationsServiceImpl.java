package com.angular.spring.services.foursquare.impl;

import com.angular.spring.model.foursquare.responses.FSLocationsResponse;
import com.angular.spring.model.requests.LocationsRequest;
import com.angular.spring.services.foursquare.FSLocationsService;
import org.springframework.stereotype.Service;

/**
 * Created by baynescorps on 15/02/2017.
 */
@Service("fsLocationsServiceImpl")
public class FSLocationsServiceImpl implements FSLocationsService {


    @Override
    public FSLocationsResponse getLocations(LocationsRequest request) {
        return null;
    }
}
