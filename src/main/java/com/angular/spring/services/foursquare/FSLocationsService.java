package com.angular.spring.services.foursquare;

import com.angular.spring.model.foursquare.responses.FSLocationsResponse;
import com.angular.spring.model.foursquare.responses.FSVenuesResponse;
import com.angular.spring.model.requests.LocationsRequest;
import com.angular.spring.model.requests.VenuesRequest;

/**
 * Created by baynescorps on 15/02/2017.
 */
public interface FSLocationsService {

    public FSLocationsResponse getLocations(LocationsRequest request);

}
