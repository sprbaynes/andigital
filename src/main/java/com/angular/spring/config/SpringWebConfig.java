package com.angular.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by steven.baynes on 02/02/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan( {"com.angular.spring.controller", "com.angular.spring.controller.advice"})
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(SpringWebConfig.class);

    public SpringWebConfig(){
        log.trace("SpringWebConfig running");
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**/*.*").addResourceLocations("/");
    }

}
