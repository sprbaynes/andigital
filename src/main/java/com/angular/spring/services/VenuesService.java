package com.angular.spring.services;

import com.angular.spring.model.requests.VenuesRequest;
import com.angular.spring.model.responses.VenuesResponse;

/**
 * Created by baynescorps on 15/02/2017.
 */
public interface VenuesService {
    public VenuesResponse getVenues(VenuesRequest requeset);
}
