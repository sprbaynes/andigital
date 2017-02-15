package com.angular.spring.services;

import com.angular.spring.config.SpringRootConfig;
import com.angular.spring.model.foursquare.responses.FSLocationsResponse;
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
public class LocationsFormatterServiceTest {

    @Autowired
    LocationsFormatterService locationsFormatterService;

    @Before
    public void setup(){

    }

    @After
    public void teardown(){

    }

    @Test
    public void getNativeLocations()
    {
        assertNull(locationsFormatterService.getNativeLocations(new FSLocationsResponse()));
    }

}
