package com.angular.spring.controller.v1;

import com.angular.spring.model.requests.LocationsRequest;
import com.angular.spring.model.requests.VenuesRequest;
import com.angular.spring.model.responses.LocationsResponse;
import com.angular.spring.model.responses.VenuesResponse;
import com.angular.spring.services.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by steven.baynes on 02/02/2016.
 */

@RestController
@RequestMapping(value="/api/v1")
public class APIController {

    private static final Logger log = LoggerFactory.getLogger(APIController.class);

    @Autowired
    ConfigService configService;



    @RequestMapping(value = "/locations", produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.GET})
    public LocationsResponse getLocations(LocationsRequest request) throws IOException {
        log.trace("locations request received");
        return "{\"hello\":\"world\"}";
    }

    @RequestMapping(value = "/venues", produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.GET})
    public VenuesResponse getVenues(VenuesRequest request) throws IOException {
        log.trace("locations request received");
        return "{\"hello\":\"world\"}";
    }

}
