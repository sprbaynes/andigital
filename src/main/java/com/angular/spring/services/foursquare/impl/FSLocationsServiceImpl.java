package com.angular.spring.services.foursquare.impl;

import com.angular.spring.model.foursquare.responses.FSLocationsResponse;
import com.angular.spring.model.requests.LocationsRequest;
import com.angular.spring.services.ConfigService;
import com.angular.spring.services.foursquare.FSLocationsService;
import com.angular.spring.util.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by baynescorps on 15/02/2017.
 */
@Service("fsLocationsServiceImpl")
public class FSLocationsServiceImpl implements FSLocationsService {

    private static final Logger log = LoggerFactory.getLogger(FSLocationsServiceImpl.class);

    @Autowired
    ConfigService config;

    @Override
    public FSLocationsResponse getLocations(LocationsRequest request) {

        log.trace("In getLocations");
        String endpointUrl = config.getFoursquareLocationsApi();

        endpointUrl = String.format(endpointUrl,
                request.getQuery(),
                request.getResults(),
                config.getFoursquareClientId(),
                config.getFoursquareClientSecret());

        RestTemplate restTemplate = new RestTemplate();
        log.trace("Using endpoint: {}",endpointUrl);

        HttpEntity<String> httpEntity = HttpHelper.getHttpEntity(null);
        ResponseEntity<FSLocationsResponse> resEntity = restTemplate.exchange(endpointUrl, HttpMethod.GET, httpEntity, FSLocationsResponse.class);

        log.trace("Response status code: {} {}", resEntity.getStatusCode().toString(), resEntity.getStatusCode().getReasonPhrase() );

        return resEntity.getBody();
    }
}
