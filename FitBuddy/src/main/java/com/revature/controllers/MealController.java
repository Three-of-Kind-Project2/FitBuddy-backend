package com.revature.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Meal;
import com.revature.models.MealDTO;
import com.revature.services.MealService
;
import com.revature.services.UserService;
@RequestMapping("meal")
@CrossOrigin("http://localhost:4200")
@RestController
public class MealController {
	
	@Autowired
	MealService mealServ;
	
	@Autowired
	UserService userServ;
	
	@PostMapping
	public ResponseEntity<List<Meal>> addMeal(@RequestBody MealDTO m) {
		Meal meal = new Meal(m.getId(), LocalDateTime.now(), m.getType(), userServ.findUser(m.getUserid()));
		
		if (meal.getId() != 0) {
			return ResponseEntity.badRequest().build();
		}
		
		Meal newMeal = this.mealServ.insert(meal);
		System.out.println(newMeal);
		List<Meal> mealList = new ArrayList<Meal>();
		mealList.add(newMeal);
		
		if (meal.getId() == 0) {
			// could not save properly
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(mealList);
	}
}
