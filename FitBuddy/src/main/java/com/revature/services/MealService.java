package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Meal;
import com.revature.models.User;
import com.revature.repositories.IMealDAO;
import com.revature.repositories.IUserDAO;

@Service
public class MealService {

	@Autowired
	private IMealDAO mealDao;
	
	@Autowired
	private IUserDAO userDao;
	
	public List<Meal> getAllMeals() {
		return mealDao.allMeals();
	}
	
	public List<Meal> mealsByUser(User u) {
		return mealDao.findByUser(u);
	}
	
	public List<Meal> mealsByUser(int userId) {
		User u = userDao.findById(userId);
		
		if (u != null) {
			return mealDao.findByUser(u);
		}
		return null;
	}
	
	public Meal findMeal(int id) {
		return mealDao.findById(id);
	}
	
	public Meal newMeal(Meal m) {
		int id = mealDao.insert(m);
		
		if (id != 0) {
			m.setId(id);
			return mealDao.update(m);
		}
		return null;
	}
	
	public Meal newMeal(Meal m, User u) {
		m.setUser(u);
		return update(m);
	}
	
	public Meal newMeal(Meal m, int userId) {
		User u = userDao.findById(userId);
		
		if (u != null) {
			m.setUser(u);
			return update(m);
		}
		return null;
	}
	
	public Meal insert(Meal m) {
		int id = mealDao.insert(m);
		
		if (id != 0) {
			m.setId(id);
			update(m);
			System.out.println(m);
			return m;
		}
		return null;
	}
	
	public Meal update(Meal m) {
		return mealDao.update(m);
	}
	
	public void delete(Meal m) {
		mealDao.delete(m);
	}
}
