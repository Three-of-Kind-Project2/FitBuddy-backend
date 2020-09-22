package com.revature.repositories;

import java.util.List;

import com.revature.models.Food;

public interface IFoodDAO {

	public List<Food> allFood();
	public Food findById(int id);
	public List<Food> findByMeal(int mealId);
	public boolean insert(Food f);
	public boolean update(Food f);
	public void delete(Food f);
}
