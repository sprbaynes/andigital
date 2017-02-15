package com.angular.spring.services.foursquare.impl;

import com.angular.spring.model.foursquare.responses.FSVenuesResponse;
import com.angular.spring.model.requests.VenuesRequest;
import com.angular.spring.services.ConfigService;
import com.angular.spring.services.foursquare.FSVenuesService;
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

@Service("fsVenuesService")
public class FSVenuesServiceImpl implements FSVenuesService {

    private static final Logger log = LoggerFactory.getLogger(FSVenuesServiceImpl.class);

    @Autowired
    ConfigService config;

    public FSVenuesResponse getVenues(VenuesRequest request)
    {
        log.trace("In getVenues");
        String endpointUrl = config.getFoursquareVenuesApi();

        endpointUrl = String.format(endpointUrl,
                config.getFoursquareClientId(),
                config.getFoursquareClientSecret(),
                request.getLatitude(),
                request.getLongitude(),
                request.getQuery());

        RestTemplate restTemplate = new RestTemplate();
        log.trace("Using endpoint: {}",endpointUrl);

        HttpEntity<String> httpEntity = HttpHelper.getHttpEntity(null);
        ResponseEntity<FSVenuesResponse> resEntity = restTemplate.exchange(endpointUrl, HttpMethod.GET, httpEntity, FSVenuesResponse.class);

        log.trace("Response status code: {} {}", resEntity.getStatusCode().toString(), resEntity.getStatusCode().getReasonPhrase() );

        return resEntity.getBody();
    }

}
