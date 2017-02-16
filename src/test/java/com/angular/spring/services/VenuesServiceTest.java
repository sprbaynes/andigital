package com.angular.spring.services;

import com.angular.spring.config.SpringRootConfig;
import com.angular.spring.model.foursquare.responses.FSVenuesResponse;
import com.angular.spring.model.requests.VenuesRequest;
import com.angular.spring.model.responses.VenuesResponse;
import com.angular.spring.services.foursquare.FSVenuesService;
import com.angular.spring.util.JsonHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

/**
 * Created by baynescorps on 15/02/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfig.class})
public class VenuesServiceTest {

    @InjectMocks
    @Autowired
    VenuesService venuesService;

    @Mock
    FSVenuesService fsVenuesService;

    FSVenuesResponse fsResponse;

    private static final String FS_RESPONSE_JSON = "/fs_venues_response.json";

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        fsResponse = JsonHelper.mapURLResourceToClass(this.getClass().getResource(FS_RESPONSE_JSON), FSVenuesResponse.class);

    }

    @After
    public void teardown(){

    }

    @Test
    public void getNativeLocations()
    {
        VenuesRequest venuesRequest = new VenuesRequest();
        venuesRequest.setQuery("Coffee");
        venuesRequest.setLongitude("-0.12574");
        venuesRequest.setLatitude("51.50853");

        VenuesRequest venuesRequest2 = new VenuesRequest();
        venuesRequest.setQuery("RandomQuery");
        venuesRequest.setLongitude("-0.12574");
        venuesRequest.setLatitude("51.50853");

        when(fsVenuesService.getVenues(venuesRequest)).thenReturn(fsResponse);
        when(fsVenuesService.getVenues(venuesRequest2)).thenReturn(null);

        VenuesResponse venuesResponse = venuesService.getVenues(venuesRequest);

        assertEquals(venuesResponse.getVenues().size(), fsResponse.getResponse().getVenues().size());

        VenuesResponse venuesResponse2 = venuesService.getVenues(venuesRequest2);

        assertEquals(venuesResponse2, new VenuesResponse());
        assertNull(venuesResponse2.getVenues());
    }
}
