package com.angular.spring.services;

import com.angular.spring.config.SpringRootConfig;
import com.angular.spring.model.foursquare.responses.FSVenue;
import com.angular.spring.model.foursquare.responses.FSVenuesResponse;
import com.angular.spring.model.responses.APIMeta;
import com.angular.spring.model.responses.Venue;
import com.angular.spring.model.responses.VenuesResponse;
import com.angular.spring.services.impl.VenuesFormatterServiceImpl;
import com.angular.spring.util.JsonHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by baynescorps on 15/02/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfig.class})
public class VenuesFormatterServiceTest {

    @Autowired
    VenuesFormatterService venuesFormatterService;

    VenuesFormatterServiceImpl venuesFormatterServiceImpl;

    private FSVenuesResponse fsResponse;

    private static final String FS_RESPONSE_JSON = "/fs_venues_response.json";

    @Before
    public void setup() {
        fsResponse = JsonHelper.mapURLResourceToClass(this.getClass().getResource(FS_RESPONSE_JSON), FSVenuesResponse.class);
        venuesFormatterServiceImpl = (VenuesFormatterServiceImpl) venuesFormatterService;

    }

    @After
    public void teardown(){

    }

    @Test
    public void getNativeVenues()
    {
        VenuesResponse venuesResponse = venuesFormatterService.getNativeVenues(fsResponse);
        assertEquals(fsResponse.getResponse().getVenues().size(), venuesResponse.getVenues().size());

    }

    @Test
    public void convertMeta(){

        VenuesResponse venuesResponse = new VenuesResponse();
        APIMeta apiMeta;
        assertNull(venuesResponse.getMeta());

        venuesFormatterServiceImpl.convertMeta(fsResponse, venuesResponse);
        assertNotNull(venuesResponse.getMeta());
        apiMeta = venuesResponse.getMeta();

        assertEquals(apiMeta.getCode(), fsResponse.getMeta().getCode().toString());
    }

    @Test
    public void convertVenuesList() {
        VenuesResponse venuesResponse = new VenuesResponse();
        List<Venue> venueList;
        assertNull(venuesResponse.getVenues());

        venuesFormatterServiceImpl.convertVenuesList(fsResponse, venuesResponse);
        venueList = venuesResponse.getVenues();
        assertNotNull(venueList);
        assertEquals(venueList.size(), fsResponse.getResponse().getVenues().size());

        /*TODO: Iterate through venue lists and test for equality on each venue*/
    }

    @Test
    public void convertVenue() {

        FSVenue fsVenue = fsResponse.getResponse().getVenues().get(0);
        Venue venue = new Venue();

        assertNull(venue.getName());
        assertNull(venue.getPhone());
        assertTrue(venue.getLat() == 0.0);
        assertTrue(venue.getLng() == 0.0);
        assertNull(venue.getDistance());
        assertNull(venue.getAddress());
        assertNull(venue.getCity());
        assertNull(venue.getState());
        assertNull(venue.getPostcode());
        assertNull(venue.getCountryCode());
        assertNull(venue.getCountry());

        venuesFormatterServiceImpl.convertVenue(fsVenue, venue);

        assertNotNull(venue.getName());
        assertNotNull(venue.getPhone());
        assertTrue(venue.getLat() != 0.0);
        assertTrue(venue.getLng() != 0.0);
        assertNotNull(venue.getDistance());
        assertNotNull(venue.getAddress());
        assertNotNull(venue.getCity());
        assertNotNull(venue.getState());
        assertNotNull(venue.getPostcode());
        assertNotNull(venue.getCountryCode());
        assertNotNull(venue.getCountry());

        assertEquals(fsVenue.getName(), venue.getName());
        assertEquals(fsVenue.getContact().getPhone(), venue.getPhone());
        assertTrue(fsVenue.getLocation().getLat() == venue.getLat());
        assertTrue(fsVenue.getLocation().getLng() == venue.getLng());
        assertEquals(fsVenue.getLocation().getDistance(), venue.getDistance());
        assertEquals(fsVenue.getLocation().getAddress(), venue.getAddress());
        assertEquals(fsVenue.getLocation().getCity(), venue.getCity());
        assertEquals(fsVenue.getLocation().getState(), venue.getState());
        assertEquals(fsVenue.getLocation().getPostalCode(), venue.getPostcode());
        assertEquals(fsVenue.getLocation().getCc(), venue.getCountryCode());
        assertEquals(fsVenue.getLocation().getCountry(), venue.getCountry());

    }

}
