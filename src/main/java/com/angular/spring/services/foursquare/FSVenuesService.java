package com.angular.spring.services.foursquare;

import com.angular.spring.model.foursquare.responses.FSVenuesResponse;
import com.angular.spring.model.requests.VenuesRequest;

/**
 * Created by baynescorps on 15/02/2017.
 */
public interface FSVenuesService {

    public FSVenuesResponse getVenues(VenuesRequest request);

}
