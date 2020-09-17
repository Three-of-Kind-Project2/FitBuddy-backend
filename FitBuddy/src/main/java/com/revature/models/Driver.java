package com.revature.models;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		
		Transaction tx = s.beginTransaction();
		
		User test = new User(0, "test", "test", "Test", "Test", "test@mail.com", 2000);
		s.save(test);
		
		tx.commit();
	}

}
