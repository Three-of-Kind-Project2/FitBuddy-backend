package com.revature.repositories;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.Food;
import com.revature.models.Meal;
import com.revature.util.HibernateUtil;

@Repository
public class FoodDAO implements IFoodDAO {
//
//	@Override
//	public List<Food> allFood() {
//		Session s = HibernateUtil.getSession();
//		Transaction tx = s.beginTransaction();
//		
//		List<Food> result = s.createQuery("FROM Food f", Food.class)
//				.getResultStream()
//				.collect(Collectors.toList());
//		
//		tx.commit();
//		return result;
//	}
//
//	@Override
//	public Food findById(int id) {
//		Session s = HibernateUtil.getSession();
//		Transaction tx = s.beginTransaction();
//		
//		Food f = s.get(Food.class, id);
//		
//		tx.commit();
//		
//		return f;
//	}
//
//	@Override
//	public List<Food> findByMeal(Meal m) {
//		List<Food> foods = null;
//		
//		Session s = HibernateUtil.getSession();
//		Transaction tx = s.beginTransaction();
//		
//		CriteriaBuilder builder = s.getCriteriaBuilder();
//		CriteriaQuery<Food> query = builder.createQuery(Food.class);
//		
//		Root<Food> root = query.from(Food.class);
//		Join<Food, Meal> join = root.join("meal", JoinType.INNER);
//		query.select(root).where(builder.equal(join.get("meal_id"), m.getId()));
//		
//		foods = s.createQuery(query).getResultStream().collect(Collectors.toList());
//		
//		tx.commit();
//		return foods;
//	}
//
//	@Override
//	public int insert(Food f) {
//		Session s = HibernateUtil.getSession();
//		Transaction tx = s.beginTransaction();
//		
//		int id = (int) s.save(f);
//		
//		if (id != 0) {
//			tx.commit();
//			return id;
//		}
//		
//		tx.rollback();
//		return id;
//	}
//
//	@Override
//	public Food update(Food f) {
//		Session s = HibernateUtil.getSession();
//		Transaction tx = s.beginTransaction();
//		
//		Food updated = (Food) s.merge(f);
//		
//		if (updated.equals(f)) {
//			tx.commit();
//			return updated;
//		}
//		
//		tx.rollback();
//		return null;
//	}
//
//	@Override
//	public void delete(Food f) {
//		Session s = HibernateUtil.getSession();
//		Transaction tx = s.beginTransaction();
//		
//		s.delete(f);
//		
//		tx.commit();
//	}
}
