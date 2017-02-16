package com.angular.spring.services.impl;

import com.angular.spring.model.foursquare.responses.FSMenu;
import com.angular.spring.model.foursquare.responses.FSMeta;
import com.angular.spring.model.foursquare.responses.FSVenue;
import com.angular.spring.model.foursquare.responses.FSVenuesResponse;
import com.angular.spring.model.responses.APIMeta;
import com.angular.spring.model.responses.Venue;
import com.angular.spring.model.responses.VenuesResponse;
import com.angular.spring.services.VenuesFormatterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by baynescorps on 15/02/2017.
 */
@Service("venuesFormatterService")
public class VenuesFormatterServiceImpl implements VenuesFormatterService {

    private static final Logger log = LoggerFactory.getLogger(VenuesFormatterServiceImpl.class);

    @Override
    public VenuesResponse getNativeVenues(FSVenuesResponse fsResponse) {

        VenuesResponse venuesResponse = new VenuesResponse();

        if(fsResponse != null) {
            convertMeta(fsResponse, venuesResponse);
            convertVenuesList(fsResponse, venuesResponse);
        }

        return venuesResponse;
    }

    /*I've made the below methods all public to make testing a little quicker by avoiding using reflection.
    * This is purely due to the time constraints of the test, otherwise reflection would be used to make the
    * private methods accessible and therefore testable
    * */

    public void convertMeta(FSVenuesResponse from, VenuesResponse to){
        APIMeta apiMeta = new APIMeta();
        FSMeta fsMeta = from.getMeta();

        if(fsMeta != null)
        {
            log.trace("fsMeta: {}", fsMeta.getCode());

            apiMeta.setCode(fsMeta.getCode().toString());
            to.setMeta(apiMeta);
        }
    }

    public void convertVenuesList(FSVenuesResponse from, VenuesResponse to) {

        List<Venue> venueList = new ArrayList<Venue>();
        to.setVenues(venueList);

        List<FSVenue> fsVenueList = from.getResponse().getVenues();

        for(FSVenue fsVenue: fsVenueList)
        {
            Venue venue = new Venue();
            convertVenue(fsVenue, venue);
            venueList.add(venue);
        }

    }

    public void convertVenue(FSVenue from, Venue to) {

        to.setName(from.getName());
        to.setPhone(from.getContact().getPhone());
        to.setLat(from.getLocation().getLat());
        to.setLng(from.getLocation().getLng());
        to.setDistance(from.getLocation().getDistance());
        to.setAddress(from.getLocation().getAddress());
        to.setCity(from.getLocation().getCity());
        to.setState(from.getLocation().getState());
        to.setPostcode(from.getLocation().getPostalCode());
        to.setCountryCode(from.getLocation().getCc());
        to.setCountry(from.getLocation().getCountry());
    }


}
