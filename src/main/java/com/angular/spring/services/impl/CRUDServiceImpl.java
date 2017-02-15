package com.angular.spring.services.impl;

import com.angular.spring.dao.UserDao;
import com.angular.spring.model.User;
import com.angular.spring.services.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by baynescorps on 06/02/2017.
 */
@Service("crudService")
public class CRUDServiceImpl implements CRUDService<User, Long> {

    @Autowired
    UserDao userDao;

    @Override
    public User create(User entity) {

        userDao.add(entity);
        return entity;
    }

    @Override
    public User read(Long key) {
        return userDao.find(key);
    }

    @Override
    public List<User> readAll() {
        return userDao.list();
    }

    @Override
    public User update(User entity) {
        userDao.update(entity);
        return userDao.find(entity.getId());
    }

    @Override
    public void delete(Long key) {
        User user = new User();
        user.setId(key);
        userDao.remove(user);
    }
}
