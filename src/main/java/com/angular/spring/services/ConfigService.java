package com.angular.spring.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by steven.baynes on 02/02/2016.
 */

@Service
public class ConfigService {

    private static final Logger log = LoggerFactory.getLogger(ConfigService.class);

    public static final String FS_CLIENT_ID_KEY = "fs.client.id";
    public static final String FS_CLIENT_SEC_KEY = "fs.client.secret";

    /*FS API*/
    public static final String FS_LOCATIONS_API_KEY = "fs.locations.api";
    public static final String FS_VENUES_API_KEY = "fs.venues.api";

    public static final String LOGGER_LVL_KEY = "logger.level";

    private static Pattern logLvlPtn = Pattern.compile("^(ALL|INFO|DEBUG|TRACE|ERROR|WARN|OFF){1}$");

    @Value("${"+FS_CLIENT_ID_KEY+"}")
    private String foursquareClientId;

    @Value("${"+FS_CLIENT_SEC_KEY+"}")
    private String foursquareClientSecret;

    @Value("${"+FS_LOCATIONS_API_KEY+"}")
    private String foursquareLocationsApi;

    @Value("${"+FS_VENUES_API_KEY+"}")
    private String foursquareVenuesApi;

    @Value("${"+LOGGER_LVL_KEY+"}")
    private String loggerLevel;

    public String getFoursquareClientId() {
        return foursquareClientId;
    }

    public void setFoursquareClientId(String foursquareClientId) {
        this.foursquareClientId = foursquareClientId;
    }

    public String getFoursquareClientSecret() {
        return foursquareClientSecret;
    }

    public void setFoursquareClientSecret(String foursquareClientSecret) {
        this.foursquareClientSecret = foursquareClientSecret;
    }

    public String getFoursquareLocationsApi() {
        return foursquareLocationsApi;
    }

    public void setFoursquareLocationsApi(String foursquareLocationsApi) {
        this.foursquareLocationsApi = foursquareLocationsApi;
    }

    public String getFoursquareVenuesApi() {
        return foursquareVenuesApi;
    }

    public void setFoursquareVenuesApi(String foursquareVenuesApi) {
        this.foursquareVenuesApi = foursquareVenuesApi;
    }

    public String getLoggerLevel() {
        return loggerLevel;
    }

    public void setLoggerLevel(String loggerLevel) {
        this.loggerLevel = loggerLevel;
    }

    public static boolean isValidLoggingLevel(String logLvl)
    {
        Matcher logLvlMtchr = logLvlPtn.matcher(logLvl.toUpperCase());
        return logLvlMtchr.matches();
    }
}
