package com.angular.spring.services.impl;

import com.angular.spring.model.foursquare.responses.FSItem;
import com.angular.spring.model.foursquare.responses.FSLocation;
import com.angular.spring.model.foursquare.responses.FSLocationsResponse;
import com.angular.spring.model.foursquare.responses.FSMeta;
import com.angular.spring.model.responses.APIMeta;
import com.angular.spring.model.responses.Location;
import com.angular.spring.model.responses.LocationsResponse;
import com.angular.spring.services.LocationsFormatterService;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baynescorps on 15/02/2017.
 */
@Service("locationsFormatterService")
public class LocationsFormatterServiceImpl implements LocationsFormatterService {

    private static final Logger log = LoggerFactory.getLogger(LocationsFormatterServiceImpl.class);

    @Override
    public LocationsResponse getNativeLocations(FSLocationsResponse fsResponse) {

        LocationsResponse locationsResponse = new LocationsResponse();
        convertMeta(fsResponse, locationsResponse);
        convertLocationsList(fsResponse, locationsResponse);

        return locationsResponse;
    }

    /*I've made the below methods all public to make testing a little quicker by avoiding using reflection.
    * This is purely due to the time constraints of the test, otherwise reflection would be used to make the
    * private methods accessible and therefore testable
    * */

    public void convertMeta(FSLocationsResponse from, LocationsResponse to){
        APIMeta apiMeta = new APIMeta();
        FSMeta fsMeta = from.getMeta();
        log.trace("fsMeta: {}", fsMeta.getCode());
        apiMeta.setCode(fsMeta.getCode().toString());
        to.setMeta(apiMeta);
    }

    public void convertLocationsList(FSLocationsResponse from, LocationsResponse to) {
        List<Location> locationList = new ArrayList<Location>();
        to.setLocations(locationList);
        List<FSItem> fsItemList = from.getResponse().getGeocode().getInterpretations().getItems();

        for(FSItem fsItem: fsItemList)
        {
            Location location = new Location();
            locationList.add(location);

            convertLocation(fsItem, location);
        }

    }

    public void convertLocation(FSItem from, Location to) {
        to.setName(from.getFeature().getName());
        to.setDisplayName(from.getFeature().getDisplayName());
        to.setLat(from.getFeature().getGeometry().getCenter().getLat());
        to.setLng(from.getFeature().getGeometry().getCenter().getLng());
    }

}
