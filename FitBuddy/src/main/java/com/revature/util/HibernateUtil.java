package com.revature.util;


import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;
 
@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.revature.repositories"),
@ComponentScan("com.revature.services") })
public class HibernateUtil {
 
   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
 
      Properties props = new Properties();
      // Setting JDBC properties
      props.put(DRIVER, "org.postgresql.Driver");
      props.put(URL, System.getenv("DB_URL"));
      props.put(USER, System.getenv("DB_USER"));
      props.put(PASS, System.getenv("DB_PASSWORD"));
 
      // Setting Hibernate properties
      props.put(SHOW_SQL, "true");
      props.put(HBM2DDL_AUTO, "update");
 
      props.put(POOL_SIZE, "10");
      props.put(DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");
      props.put(FORMAT_SQL, "true");
 
      factoryBean.setHibernateProperties(props);
      factoryBean.setPackagesToScan("com.revature.models");
 
      return factoryBean;
   }
 
   @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
   }
}
//public class HibernateUtil {
//
//	private static Session session;
//	
//	/* 
//	 * This builds the session factory.
//	 * setProperty() sets the property
//	 * addAnnotatedClass() maps the class i.e. looks for the annotations
//	 */
//	
//	public static SessionFactory getSessionFactory() {
//		// Setting configuration to the hibernate config file
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		
//		// Setting property to the corresponding name and variable
//		// Make sure that the values in System.getenv() is the same variable in your Sys Env!
//		cfg.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
//		cfg.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
//		cfg.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
//		cfg.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//		cfg.setProperty("hibernate.connection.pool_size", "10");
//		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
//		cfg.setProperty("hibernate.show_sql", "true");
//		cfg.setProperty("hibernate.format_sql", "true");
//		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
//		
//		// Mapping the class to look for its annotations.
//		cfg.addAnnotatedClass(User.class);
//		cfg.addAnnotatedClass(Meal.class);
//		cfg.addAnnotatedClass(Food.class);
//		
//		// Building the session factory
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
//	    return sessionFactory;
//	}
//	
////	private static SessionFactory sf =
////			new Configuration().configure("hibernate.cfg.xml")
////				.buildSessionFactory();
//	
//	private HibernateUtil() {
//		super();
//	}
//	
//	public static Session getSession() {
//		if(session == null || !session.isOpen()) {
//			session = getSessionFactory().openSession();
//		}
//		
//		return session;
//	}
//	
//	public static void closeSession() {
//		session.close();
//	}
//}
