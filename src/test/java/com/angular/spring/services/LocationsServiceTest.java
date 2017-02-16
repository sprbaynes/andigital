package com.angular.spring.services;

import com.angular.spring.config.SpringRootConfig;
import com.angular.spring.model.foursquare.responses.FSLocationsResponse;
import com.angular.spring.model.requests.LocationsRequest;
import com.angular.spring.model.responses.LocationsResponse;
import com.angular.spring.services.foursquare.FSLocationsService;
import com.angular.spring.services.impl.LocationsFormatterServiceImpl;
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
public class LocationsServiceTest {

    @InjectMocks
    @Autowired
    LocationsService locationsService;

    @Mock
    FSLocationsService fsLocationsService;


    FSLocationsResponse fsResponse;

    private static final String FS_RESPONSE_JSON = "/fs_locations_response.json";

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        fsResponse = JsonHelper.mapURLResourceToClass(this.getClass().getResource(FS_RESPONSE_JSON), FSLocationsResponse.class);

    }

    @After
    public void teardown(){

    }

    @Test
    public void getNativeLocations()
    {
        LocationsRequest locationsRequest = new LocationsRequest();
        locationsRequest.setQuery("London");
        locationsRequest.setResults(4);

        LocationsRequest locationsRequest2 = new LocationsRequest();
        locationsRequest.setQuery("RandomQuery");
        locationsRequest.setResults(1);

        when(fsLocationsService.getLocations(locationsRequest)).thenReturn(fsResponse);
        when(fsLocationsService.getLocations(locationsRequest2)).thenReturn(null);

        LocationsResponse locationsResponse = locationsService.getLocations(locationsRequest);

        assertEquals(locationsResponse.getLocations().size(), fsResponse.getResponse().getGeocode().getInterpretations().getItems().size());

        LocationsResponse locationsResponse2 = locationsService.getLocations(locationsRequest2);

        assertEquals(locationsResponse2, new LocationsResponse());
        assertNull(locationsResponse2.getLocations());
    }

}
