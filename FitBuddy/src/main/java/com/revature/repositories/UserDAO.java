package com.revature.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

@Repository
public class UserDAO implements IUserDAO {

	@Override
	public List<User> allUsers() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		List<User> result = s.createQuery("FROM User u", User.class)
				.getResultStream()
				.collect(Collectors.toList());
		
		tx.commit();
		return result;
	}

}
