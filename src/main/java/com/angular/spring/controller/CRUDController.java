package com.angular.spring.controller;

import com.angular.spring.model.User;
import com.angular.spring.services.CRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by baynescorps on 06/02/2017.
 */
@RestController
@RequestMapping(value="/crud")
public class CRUDController {
    private static final Logger log = LoggerFactory.getLogger(CRUDController.class);

    @Autowired
    CRUDService<User, Long> crudService;

    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.GET})
    public List<User> readAll()
    {
        return crudService.readAll();
    }

    @RequestMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.GET})
    public User readIndividual(User user)
    {
        return crudService.read(user.getId());
    }


    @RequestMapping(value="",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.POST})
    public User createIndividual(@RequestBody(required = true) User user)
    {
        return crudService.create(user);
    }


    @RequestMapping(value="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.PUT})
    public User updateIndividual(@RequestBody(required = true) User user, @PathVariable Long id)
    {
        log.trace("id received: {}, {}", id, user);
        user.setId(id);
        return crudService.update(user);
    }

    @RequestMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.DELETE})
    public User deleteIndividual(User user)
    {
        log.trace("user received: {}", user);
        crudService.delete(user.getId());

        return user;
    }
}
