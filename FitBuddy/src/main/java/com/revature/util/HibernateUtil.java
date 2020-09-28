package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Food;
import com.revature.models.Meal;
import com.revature.models.User;

public class HibernateUtil {

	private static Session session;
	
	/* 
	 * This builds the session factory.
	 * setProperty() sets the property
	 * addAnnotatedClass() maps the class i.e. looks for the annotations
	 */
	public static SessionFactory getSessionFactory() {
		// Setting configuration to the hibernate config file
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		// Setting property to the corresponding name and variable
		// Make sure that the values in System.getenv() is the same variable in your Sys Env!
		cfg.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
		cfg.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
		cfg.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
		cfg.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
		cfg.setProperty("hibernate.connection.pool_size", "10");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
		cfg.setProperty("hibernate.show_sql", "true");
		cfg.setProperty("hibernate.format_sql", "true");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		
		// Mapping the class to look for its annotations.
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Meal.class);
		cfg.addAnnotatedClass(Food.class);
		
		// Building the session factory
		SessionFactory sessionFactory = cfg.buildSessionFactory();
	    return sessionFactory;
	}
	
//	private static SessionFactory sf =
//			new Configuration().configure("hibernate.cfg.xml")
//				.buildSessionFactory();
	
	private HibernateUtil() {
		super();
	}
	
	public static Session getSession() {
		if(session == null || !session.isOpen()) {
			session = getSessionFactory().openSession();
		}
		
		return session;
	}
	
	public static void closeSession() {
		session.close();
	}
}
