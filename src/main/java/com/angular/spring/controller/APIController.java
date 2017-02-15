package com.angular.spring.controller;

import com.angular.spring.dao.UserDao;
import com.angular.spring.model.User;
import com.angular.spring.services.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by steven.baynes on 02/02/2016.
 */

@RestController
@RequestMapping(value="/api")
public class APIController {

    private static final Logger log = LoggerFactory.getLogger(APIController.class);

    @Autowired
    ConfigService configService;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.GET})
    public List<User> getHome() throws IOException {
        log.trace("In API Controller");
        return userDao.list();
    }

}
