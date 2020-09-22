package com.revature.repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.revature.models.Meal;

public interface IMealDAO {

	public List<Meal> allMeals();
	public Meal findById(int id);
	public List<Meal> findByDate(LocalDateTime date);
	public List<Meal> findByUser(int userId);
	public boolean insert(Meal m);
	public boolean update(Meal m);
	public void delete(Meal m);
}
