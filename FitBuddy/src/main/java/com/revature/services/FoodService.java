package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Food;
import com.revature.models.Meal;
import com.revature.models.User;
import com.revature.repositories.IFoodDAO;
import com.revature.repositories.IMealDAO;
import com.revature.repositories.IUserDAO;

@Service
public class FoodService {

	@Autowired
	private IFoodDAO foodDao;
	
	@Autowired
	private IMealDAO mealDao;
	
	@Autowired
	private IUserDAO userDao;
	
	public List<Food> getAllFood() {
		return foodDao.allFood();
	}
	
	public List<Food> getFoodByUser(int userId) {
		User u = userDao.findById(userId);
		List<Meal> meals = mealDao.findByUser(u);
		List<Food> food = new ArrayList<>();
		
		for (Meal m : meals) {
			List<Food> mealFood = foodByMeal(m);
			for (Food f : mealFood) {
				food.add(f);
			}
		}
		return food;
	}
	
	public List<Food> foodByMeal(Meal m) {
		return foodDao.findByMeal(m);
	}
	
	public List<Food> foodByMeal(int mealId) {
		Meal m = mealDao.findById(mealId);
		
		if (m != null) {
			return foodDao.findByMeal(m);
		}
		return null;
	}
	
	public Food addFood(Food f, Meal m) {
		f.setMeal(m);
		return update(f);
	}
	
	public Food addFood(Food f, int mealId) {
		Meal m = mealDao.findById(mealId);
		
		if (m != null) {
			f.setMeal(m);
			return update(f);
		}
		return null;
	}
	
	public Food insert(Food f) {
		int id = foodDao.insert(f);
		
		if (id != 0) {
			f.setId(id);
			return update(f);
		}
		return null;
	}
	
	public Food update(Food f) {
		return foodDao.update(f);
	}
	
	public void delete(Food f) {
		foodDao.delete(f);
	}
	
	public void deleteAllFromUser(User u) {
		List<Meal> meals = mealDao.findByUser(u);
		for (Meal m : meals) {
			List<Food> foods = foodDao.findByMeal(m);
			if (foods.size() != 0) {
				for (Food f : foods) {
					delete(f);
				}
			}
			mealDao.delete(m);
		}
	}
}
