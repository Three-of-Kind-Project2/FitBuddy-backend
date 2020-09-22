package com.revature.models;

import java.time.LocalDateTime;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.repositories.FoodDAO;
import com.revature.repositories.IFoodDAO;
import com.revature.repositories.IMealDAO;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.MealDAO;
import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

public class Driver {

	public static void main(String[] args) {
		IUserDAO userDao = new UserDAO();
		IMealDAO mealDao = new MealDAO();
		IFoodDAO foodDao = new FoodDAO();
		
		User test = new User(0, "test", "test", "Test", "Test", "test@mail.com", 2000);
		userDao.insert(test);
		
		Meal m1 = new Meal(0, LocalDateTime.now(), "Lunch", test);
		mealDao.insert(m1);
		
		System.out.println(mealDao.allMeals());
		
		System.out.println(mealDao.findByUser(test));
		
		Food f1 = new Food(0, "apple", "http://food.gov/apple", 85, 20, 0, 0, m1);
		Food f2 = new Food(0, "orange", "http://food.gov/orange", 85, 20, 0, 0, m1);
		foodDao.insert(f1);
		foodDao.insert(f2);
		
		System.out.println(foodDao.allFood());
		
		System.out.println(foodDao.findByMeal(m1));
		
		UserService userServ = new UserService();
		
		User test2 = new User(0, "test2", "test2", "Test2", "Test2", "test2@mail.com", 2100);
		userServ.register(test2);
		
		System.out.println(userServ.findUser("test2"));
		
		if (BCrypt.checkpw("test2", userServ.findUser("test2").getPassword())) {
			System.out.println("pws match");
		} else {
			System.out.println("no match");
		}
	}

}
