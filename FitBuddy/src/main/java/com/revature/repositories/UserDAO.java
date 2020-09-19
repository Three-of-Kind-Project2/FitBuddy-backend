package com.revature.repositories;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		
		Predicate restriction = builder.and(builder.like(root.get("username"), username));
		query.select(root).where(restriction);
		TypedQuery<User> u = s.createQuery(query);
		
		tx.commit();
		
		return u.getSingleResult();
	}

	@Override
	public boolean insert(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		int id = (int) s.save(u);
		
		if (id != 0) {
			tx.commit();
			return true;
		}
		
		tx.rollback();
		return false;
	}

	@Override
	public boolean update(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		User updated = (User) s.merge(u);
		
		if (updated.equals(u)) {
			tx.commit();
			return true;
		}
		
		tx.rollback();
		return false;
	}

	@Override
	public void delete(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		s.delete(u);
		
		tx.commit();
	}

}
