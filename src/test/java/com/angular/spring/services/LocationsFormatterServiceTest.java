package com.angular.spring.services;

import com.angular.spring.config.SpringRootConfig;
import com.angular.spring.model.foursquare.responses.*;
import com.angular.spring.model.responses.*;
import com.angular.spring.services.impl.LocationsFormatterServiceImpl;
import com.angular.spring.services.impl.VenuesFormatterServiceImpl;
import com.angular.spring.util.JsonHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by baynescorps on 15/02/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfig.class})
public class LocationsFormatterServiceTest {

    @Autowired
    LocationsFormatterService locationsFormatterService;

    FSLocationsResponse fsResponse;

    LocationsFormatterServiceImpl locationsFormatterServiceImpl;

    private static final String FS_RESPONSE_JSON = "/fs_locations_response.json";

    @Before
    public void setup(){
        fsResponse = JsonHelper.mapURLResourceToClass(this.getClass().getResource(FS_RESPONSE_JSON), FSLocationsResponse.class);
        locationsFormatterServiceImpl = (LocationsFormatterServiceImpl) locationsFormatterService;
    }

    @After
    public void teardown(){

    }

    @Test
    public void getNativeLocations()
    {
        LocationsResponse locationsResponse = locationsFormatterService.getNativeLocations(fsResponse);
        assertEquals(fsResponse.getResponse().getGeocode().getInterpretations().getItems().size(), locationsResponse.getLocations().size());
    }

    @Test
    public void convertMeta(){
        LocationsResponse locationsResponse = new LocationsResponse();
        APIMeta apiMeta;
        assertNull(locationsResponse.getMeta());

        locationsFormatterServiceImpl.convertMeta(fsResponse, locationsResponse);
        assertNotNull(locationsResponse.getMeta());
        apiMeta = locationsResponse.getMeta();

        assertEquals(apiMeta.getCode(), fsResponse.getMeta().getCode().toString());
    }

    @Test
    public void convertLocationsList() {
        LocationsResponse locationsResponse = new LocationsResponse();
        List<Location> locationList;
        assertNull(locationsResponse.getLocations());

        locationsFormatterServiceImpl.convertLocationsList(fsResponse, locationsResponse);
        locationList = locationsResponse.getLocations();
        assertNotNull(locationList);
        assertEquals(locationList.size(), fsResponse.getResponse().getGeocode().getInterpretations().getItems().size());

        /*TODO: Iterate through venue lists and test for equality on each venue*/

    }

    @Test
    public void convertLocation() {
        /*to.setName(from.getFeature().getName());
        to.setDisplayName(from.getFeature().getName());
        to.setLat(from.getFeature().getGeometry().getCenter().getLat());
        to.setLng(from.getFeature().getGeometry().getCenter().getLng());
*/
        FSItem fsItem = fsResponse.getResponse().getGeocode().getInterpretations().getItems().get(0);
        Location location = new Location();

        assertNull(location.getName());
        assertNull(location.getDisplayName());
        assertTrue(location.getLat() == 0.0);
        assertTrue(location.getLng() == 0.0);

        locationsFormatterServiceImpl.convertLocation(fsItem, location);

        assertNotNull(location.getName());
        assertNotNull(location.getDisplayName());
        assertTrue(location.getLat() != 0.0);
        assertTrue(location.getLng() != 0.0);

        assertEquals(fsItem.getFeature().getName(), location.getName());
        assertEquals(fsItem.getFeature().getDisplayName(), location.getDisplayName());
        assertTrue(fsItem.getFeature().getGeometry().getCenter().getLat() == location.getLat());
        assertTrue(fsItem.getFeature().getGeometry().getCenter().getLng() == location.getLng());
    }

}
