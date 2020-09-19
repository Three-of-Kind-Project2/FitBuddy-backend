package com.revature.models;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.services.UserService;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		
		Transaction tx = s.beginTransaction();
		
		User test = new User(0, "test", "test", "Test", "Test", "test@mail.com", 2000);
		s.save(test);
		tx.commit();
		
		UserService userServ = new UserService();
		
		System.out.println(userServ.getAllUsers());
		
		System.out.println(userServ.findUser(1));
		
		User test2 = new User(0, "test2", "test2", "Test2", "Test2", "test2@mail.com", 2200);
		tx.commit();
		
		System.out.println(userServ.register(test2));
		
		System.out.println(userServ.findUser("test2"));
		
	}

}
