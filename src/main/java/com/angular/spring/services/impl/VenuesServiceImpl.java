package com.angular.spring.services.impl;

import com.angular.spring.model.foursquare.responses.FSVenuesResponse;
import com.angular.spring.model.requests.VenuesRequest;
import com.angular.spring.model.responses.VenuesResponse;
import com.angular.spring.services.VenuesFormatterService;
import com.angular.spring.services.VenuesService;
import com.angular.spring.services.foursquare.FSVenuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by baynescorps on 15/02/2017.
 */
@Service("venuesService")
public class VenuesServiceImpl implements VenuesService {

    @Autowired
    FSVenuesService fsVenuesService;

    @Autowired
    VenuesFormatterService venuesFormatterService;

    @Override
    public VenuesResponse getVenues(VenuesRequest request) {

        FSVenuesResponse fsResponse = fsVenuesService.getVenues(request);

        VenuesResponse venuesResponse = venuesFormatterService.getNativeVenues(fsResponse);

        return venuesResponse;

    }
}
