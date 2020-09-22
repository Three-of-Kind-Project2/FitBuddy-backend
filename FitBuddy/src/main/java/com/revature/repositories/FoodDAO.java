package com.revature.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.Food;
import com.revature.util.HibernateUtil;

@Repository
public class FoodDAO implements IFoodDAO {

	@Override
	public List<Food> allFood() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		List<Food> result = s.createQuery("FROM Food f", Food.class)
				.getResultStream()
				.collect(Collectors.toList());
		
		tx.commit();
		return result;
	}

	@Override
	public Food findById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Food f = s.get(Food.class, id);
		
		tx.commit();
		
		return f;
	}

	@Override
	public List<Food> findByMeal(int mealId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Food f) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		int id = (int) s.save(f);
		
		if (id != 0) {
			tx.commit();
			return true;
		}
		
		tx.rollback();
		return false;
	}

	@Override
	public boolean update(Food f) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Food updated = (Food) s.merge(f);
		
		if (updated.equals(f)) {
			tx.commit();
			return true;
		}
		
		tx.rollback();
		return false;
	}

	@Override
	public void delete(Food f) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		s.delete(f);
		
		tx.commit();
	}
}
