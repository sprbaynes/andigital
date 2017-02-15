package com.angular.spring.dao.impl;

import com.angular.spring.dao.HibernateDao;
import com.angular.spring.dao.UserDao;
import com.angular.spring.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by baynescorps on 04/02/2017.
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateDao<User, Long> implements UserDao {
}
