package com.angular.spring.dao.impl;

import com.angular.spring.config.SpringRootConfig;
import com.angular.spring.config.SpringWebConfig;
import com.angular.spring.dao.UserDao;
import com.angular.spring.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.*;

/**
 * Created by baynescorps on 04/02/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfig.class})
public class UserDaoTest {

    private static final Logger log = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    UserDao userDao;

    @Autowired
    DataSource dataSource;

    EmbeddedDatabase db;

    @Value("${db.create.sql.location}")
    private String dbCreateLocation;

    @Before
    public void setup() {
        db = (EmbeddedDatabase) dataSource;
        db.shutdown();
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        db = builder
                .setName("as-db")
                .setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
                .addScript("file:"+dbCreateLocation)
                /*.addScript("file:"+dbInsertLocation)*/
                .build();
    }

    @After
    public void teardown() throws Exception {
        db.shutdown();
    }

    @Test
    public void testAdd() throws Exception {
        int size = userDao.list().size();

        User user = new User("Casey", "neistat@gmail.com");
        userDao.add(user);
        assertTrue (size < userDao.list().size());

        //log.trace("{}", user.toString());

        User foundUser = userDao.find(user.getId());

        log.trace("found user {}", user.toString());
        assertEquals(user, foundUser);
        // list should have one more user now
    }

    @Test
    public void testUpdate() {
        
        User user = new User("test-user", "hackzorz");
        
        userDao.add(user);
        
        user.setName("updated");
        
        userDao.update(user);
        
        User found = userDao.find(user.getId());
        
        assertEquals("updated", found.getName());
        
    }
    
    @Test
    public void testFind() {
        
        User user = new User("test-user", "hackzorz");
        
        userDao.add(user);
        
        User found = userDao.find(user.getId());
        
        assertEquals(found, user);
        
    }
    
    @Test
    
    public void testList() {
        
        assertEquals(0, userDao.list().size());

        List<User> users = Arrays.asList(

                new User("test-1", "testers"),

                new User("test-2", "testers"),

                new User("test-3", "testers"));
        
        for (User user : users) {
            
            userDao.add(user);
            
        }

        List<User> found = userDao.list();
        
        assertEquals(3, found.size());
        
        for (User user : found) {
            
            assertTrue(users.contains(user));
            
        }
        
    }
    
    @Test
    public void testRemove() {
        
        User user = new User("test-user", "hackzorz");
        
        userDao.add(user);
        
        // successfully added
        
        assertEquals(user, userDao.find(user.getId()));
        
        // try to remove
        
        userDao.remove(user);
        
        assertNull(userDao.find(user.getId()));
        
    }


}
