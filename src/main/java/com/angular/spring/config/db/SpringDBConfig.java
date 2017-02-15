package com.angular.spring.config.db;

import com.angular.spring.model.User;
import org.hibernate.SessionFactory;
import org.hsqldb.util.DatabaseManagerSwing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by baynescorps on 04/02/2017.
 */
@Profile("hsql")
@Configuration
@ComponentScan({"com.angular.spring.dao.impl"})
@EnableTransactionManagement
public class SpringDBConfig {

    private static final Logger log = LoggerFactory.getLogger(SpringDBConfig.class);

    @Value("${db.create.sql.location}")
    private String dbCreateLocation;

    @Value("${db.insert.sql.location}")
    private String dbInsertLocation;


    public SpringDBConfig(){
        log.trace("SpringDBConfig running");
    }

    @Bean
    public DataSource dataSource() {

        log.trace("dbCreateLocation {}", dbCreateLocation);
        log.trace("dbInsertLocation {}", dbInsertLocation);

        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setName("as-db")
                .setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
                .addScript("file:"+dbCreateLocation)
                .addScript("file:"+dbInsertLocation)/*TODO: Fix config for better testing*/
                .build();
        return db;
    }

    @PostConstruct
    public void startDBManager() {
        //hsqldb
        DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:mem:as-db", "--user", "sa", "--password", ""});
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");

        return properties;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(getHibernateProperties());
        sessionBuilder.addAnnotatedClasses(User.class);
        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

        return transactionManager;
    }
}
