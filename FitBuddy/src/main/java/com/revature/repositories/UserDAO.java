package com.revature.repositories;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

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

	@Override
	public User findById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		User u = s.get(User.class, id);
		
		tx.commit();
		
		return u;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User u) {
		// TODO Auto-generated method stub
		return false;
	}

}
