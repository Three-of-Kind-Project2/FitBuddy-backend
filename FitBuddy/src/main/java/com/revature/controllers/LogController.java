package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Food;
import com.revature.models.FoodDTO;
import com.revature.models.Meal;
import com.revature.services.FoodService;
import com.revature.services.MealService;

@RestController
@RequestMapping("log")
@CrossOrigin("http://localhost:4200")
public class LogController {

	@Autowired
	MealService mealServ;
	
	@Autowired
	FoodService foodServ;
	
	@GetMapping
	public ResponseEntity<List<Meal>> getMeals(int user_id) {
		return ResponseEntity.ok(this.mealServ.mealsByUser(user_id));
	}
	
	@PostMapping
	public ResponseEntity<List<Meal>> addFood(@RequestBody FoodDTO f) {
		Meal meal = mealServ.findMeal(f.getMeal_id());
		Food food = new Food(f.getFood_id(), f.getName(), f.getUrl(), f.getCalories(), f.getCarbs(), 
				f.getProtein(), f.getFat(), meal);
		
		if (food.getId() != 0) {
			return ResponseEntity.badRequest().build();
		}
		
		this.foodServ.insert(food);
		
		if (food.getId() == 0) {
			// could not save properly
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.ok(this.mealServ.mealsByUser(meal.getUser()));
	}
}
