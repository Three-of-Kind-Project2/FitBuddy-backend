package com.revature.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.Meal;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

@Repository
public class MealDAO implements IMealDAO {

	@Override
	public List<Meal> allMeals() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		List<Meal> result = s.createQuery("FROM Meal m", Meal.class)
				.getResultStream()
				.collect(Collectors.toList());
		
		tx.commit();
		return result;
	}

	@Override
	public Meal findById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Meal m = s.get(Meal.class, id);
		
		tx.commit();
		return m;
	}

	@Override
	public List<Meal> findByDate(LocalDateTime date) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Meal> query = builder.createQuery(Meal.class);
		Root<Meal> root = query.from(Meal.class);
		
		Predicate restriction = builder.and(builder.like(root.get("date"), date.toString()));
		query.select(root).where(restriction);
		TypedQuery<Meal> m = s.createQuery(query);
		
		tx.commit();
		return m.getResultList();
	}

	@Override
	public List<Meal> findByUser(User u) {
		List<Meal> meals = null;
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Meal> query = builder.createQuery(Meal.class);
		
		Root<Meal> root = query.from(Meal.class);
		Join<Meal, User> join = root.join("user", JoinType.INNER);
		query.select(root).where(builder.equal(join.get("id"), u.getId()));
		
		meals = s.createQuery(query).getResultStream().collect(Collectors.toList());
		
		tx.commit();
		return meals;
	}
	
	@Override
	public boolean insert(Meal m) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		int id = (int) s.save(m);
		
		if (id != 0) {
			tx.commit();
			return true;
		}
		
		tx.rollback();
		return false;
	}

	@Override
	public boolean update(Meal m) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Meal updated = (Meal) s.merge(m);
		
		if (updated.equals(m)) {
			tx.commit();
			return true;
		}
		
		tx.rollback();
		return false;
	}

	@Override
	public void delete(Meal m) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		s.delete(m);
		
		tx.commit();
	}
}
