package com.angular.spring.services;

import com.angular.spring.config.SpringRootConfig;
import com.angular.spring.model.foursquare.responses.FSLocationsResponse;
import com.angular.spring.model.foursquare.responses.FSVenuesResponse;
import com.angular.spring.util.JsonHelper;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Created by baynescorps on 15/02/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfig.class})
public class VenuesFormatterServiceTest {

    @Autowired
    VenuesFormatterService venuesFormatterService;

    private FSVenuesResponse fsResponse;

    private static final String FS_RESPONSE_JSON = "/fs_venues_response.json";

    @Before
    public void setup() {

        fsResponse = JsonHelper.mapURLResourceToClass(this.getClass().getResource(FS_RESPONSE_JSON), FSVenuesResponse.class);
    }

    @After
    public void teardown(){

    }

    @Test
    public void getNativeLocations()
    {
        assertNull(venuesFormatterService.getNativeVenues(fsResponse));
    }


}
