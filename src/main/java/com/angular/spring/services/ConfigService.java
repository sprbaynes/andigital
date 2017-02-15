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

    public static final String LOGGER_LVL_KEY = "logger.level";

    private static Pattern logLvlPtn = Pattern.compile("^(ALL|INFO|DEBUG|TRACE|ERROR|WARN|OFF){1}$");

    @Value("${"+LOGGER_LVL_KEY+"}")
    private String loggerLevel;

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
