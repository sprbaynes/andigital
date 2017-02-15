package com.angular.spring.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.angular.spring.services.ConfigService;
import com.angular.spring.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by steven.baynes on 02/02/2016.
 */
@Configuration
@ComponentScan({"com.angular.spring.services", "com.angular.spring.util"})
@PropertySource({"classpath:application.properties","file:${config.location}"})
public class SpringRootConfig {

    private static final Logger log = LoggerFactory.getLogger(SpringRootConfig.class);

    public SpringRootConfig(){
        log.trace("SpringRootConfig running");
    }

    @Autowired
    private ConfigService configService;

    @Bean
    public Logger logger()
    {
        log.trace("About to synchronise logback.xml level with app config");
        /*This is a bit of a hack to keep the logger level of logback.xml in sync with that of external config file*/
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

        ch.qos.logback.classic.Logger logBackLogger = lc.getLogger(Constants.PKG_NAME);

        if(logBackLogger != null)
        {
            final String configLogLvl = configService.getLoggerLevel();

            if(ConfigService.isValidLoggingLevel(configLogLvl))
            {
                logBackLogger.setLevel(Level.toLevel(configLogLvl));
            }
            else{
                log.info("'{}' is not a valid log level in '{}' property, ignoring it.", configLogLvl, ConfigService.LOGGER_LVL_KEY);
            }
        }

        return logBackLogger;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

