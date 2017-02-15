package com.angular.spring.controller;

import com.angular.spring.config.SpringRootConfig;
import com.angular.spring.config.SpringWebConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.logging.Logger;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*  ;



/**
 * Created with IntelliJ IDEA.
 * User: baynescorps
 * Date: 21/01/2017
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
        classes = {SpringRootConfig.class, SpringWebConfig.class}
)
public class APIControllerTest {

    private Logger log = Logger.getLogger(this.getClass().getName());

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();

    }

    @After
    public void teardown() throws Exception {

    }

    @Test
    public void getLocations() throws Exception {
        this.mockMvc.perform(get("/api/v1/locations").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        this.mockMvc.perform(get("/api/v1/locations?query=london&results=5").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getVenues() throws Exception {
        this.mockMvc.perform(get("/api/v1/venues?query=Coffee&latitude=51.50853&longitude=-0.12574").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
