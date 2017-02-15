package com.angular.spring.services;

import com.angular.spring.model.requests.LocationsRequest;
import com.angular.spring.model.responses.LocationsResponse;

/**
 * Created by baynescorps on 15/02/2017.
 */
public interface LocationsService {

    public LocationsResponse getLocations(LocationsRequest request);

}
