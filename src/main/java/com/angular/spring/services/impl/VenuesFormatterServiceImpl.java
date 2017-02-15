package com.angular.spring.services.impl;

import com.angular.spring.model.foursquare.responses.FSVenuesResponse;
import com.angular.spring.model.responses.VenuesResponse;
import com.angular.spring.services.VenuesFormatterService;
import org.springframework.stereotype.Service;


/**
 * Created by baynescorps on 15/02/2017.
 */
@Service("venuesFormatterService")
public class VenuesFormatterServiceImpl implements VenuesFormatterService {
    @Override
    public VenuesResponse getNativeVenues(FSVenuesResponse response) {
        return null;
    }
}
