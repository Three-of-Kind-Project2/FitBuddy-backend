package com.revature.services;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.models.Food;
import com.revature.models.Meal;
import com.revature.models.User;
import com.revature.repositories.IFoodDAO;
import com.revature.repositories.IMealDAO;
import com.revature.repositories.IUserDAO;

public class FoodServiceTest {
	
	
	@InjectMocks
	private FoodService foodServ;
	
	@Mock
	private IFoodDAO foodDao; 
	@Mock
	private IMealDAO mealDao; 
	@Mock
	private IUserDAO userDao; 
	
	private LocalDateTime date = LocalDateTime.now(); 
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testgetAllFood() {
		IFoodDAO foodDAO = Mockito.mock(IFoodDAO.class);
		FoodService foodService = Mockito.mock(FoodService.class);
		final List<Food> testFood = new ArrayList<>();
		Mockito.when(foodDAO.allFood()).thenReturn(testFood);
		assertNotNull(foodService.getAllFood());
	}
	
	@Test
	public void testFoodByMeal() {
		User test = new User(0, "Test", "Test", "Test", "Test", "test@mail.com", 2000);
		Meal meal = new Meal(1, date, "Breakfast", test);
		Food food = new Food(1, "Big-Mac", "www.food.com", 100, 100, 100, 100, meal);
		List<Food> testFood = new ArrayList<>();
		testFood.add(food); 
		when(foodDao.findByMeal(meal)).thenReturn(testFood);
		assertEquals(foodDao.findByMeal(meal),foodServ.foodByMeal(meal));
	}
	
	@Test
	public void testFoodByMealIdNotNull() {
		User test = new User(0, "Test", "Test", "Test", "Test", "test@mail.com", 2000);
		Meal meal = new Meal(1, date, "Breakfast", test);
		Food food = new Food(1, "Big-Mac", "www.food.com", 100, 100, 100, 100, meal);
		List<Food> testFood = new ArrayList<>();
		testFood.add(food); 
		List<Meal> testMeal = new ArrayList<>();
		testMeal.add(meal); 
		when(mealDao.findById(1)).thenReturn(meal);
		assertNotNull(foodServ.foodByMeal(1)); 
		
	}
	
	@Test
	public void testFoodByMealIdNull() {
		Meal meal = new Meal();
		Food food = new Food(1, "Big-Mac", "www.food.com", 100, 100, 100, 100, meal);
		List<Food> testFood = new ArrayList<>();
		testFood.add(food); 
		List<Meal> testMeal = new ArrayList<>();
		testMeal.add(meal); 
		when(mealDao.findById(1)).thenReturn(meal);
		assertNull(foodServ.foodByMeal(0)); 
		
	}
	
	@Test 
	public void testaddFood() {
		User test = new User(0, "Test", "Test", "Test", "Test", "test@mail.com", 2000);
		Meal meal = new Meal(1, date, "Breakfast", test);
		Food food = new Food(1, "Big-Mac", "www.food.com", 100, 100, 100, 100, meal);
		when(foodServ.update(food)).thenReturn(food);
		
		assertEquals(foodServ.addFood(food, meal).getMeal(),meal);
		
	}
	
	@Test 
	public void testaddFoodbyMealByIdNotNull() {
		User test = new User(0, "Test", "Test", "Test", "Test", "test@mail.com", 2000);
		Meal meal = new Meal(1, date, "Breakfast", test);
		Food food = new Food(1, "Big-Mac", "www.food.com", 100, 100, 100, 100, meal);
		
		when(foodServ.update(food)).thenReturn(food);
		
		when(mealDao.findById(1)).thenReturn(meal);
		when(foodDao.update(food)).thenReturn(food);
		food.setMeal(meal);
		assertNotNull(foodServ.addFood(food, 1));
	}
	
	@Test 
	public void testInsertFood () {
		User test = new User(0, "Test", "Test", "Test", "Test", "test@mail.com", 2000);
		Meal meal = new Meal(1, date, "Breakfast", test);
		Food food = new Food(1, "Big-Mac", "www.food.com", 100, 100, 100, 100, meal);
		
		when(foodDao.insert(food)).thenReturn(1);
		when(foodDao.update(food)).thenReturn(food); 
		assertEquals(foodServ.insert(food),food);
		
	}
	
	@Test 
	public void testInsertFoodNotNull () {
		User test = new User(0, "Test", "Test", "Test", "Test", "test@mail.com", 2000);
		Meal meal = new Meal(1, date, "Breakfast", test);
		Food food = new Food(1, "Big-Mac", "www.food.com", 100, 100, 100, 100, meal);
		
		when(foodDao.insert(food)).thenReturn(1); 
		when(foodDao.update(food)).thenReturn(food); 
		assertNotNull(foodServ.insert(food));
		
	}
	
	@Test 
	public void testUpdate () {
		User test = new User(0, "Test", "Test", "Test", "Test", "test@mail.com", 2000);
		Meal meal = new Meal(1, date, "Breakfast", test);
		Food food = new Food(1, "Big-Mac", "www.food.com", 100, 100, 100, 100, meal);
		when(foodDao.update(food)).thenReturn(food); 
		assertEquals(foodDao.update(food),foodServ.update(food));
	}
	
	@Test
	public void testgetFoodByUser() {
		User test = new User(0, "Test", "Test", "Test", "Test", "test@mail.com", 2000);
		Meal meal = new Meal(0, date, "Breakfast", test);
		List<Meal> meals = new ArrayList<>();
		meals.add(meal);
		when(mealDao.findByUser(test)).thenReturn(meals);
		when(userDao.findById(0)).thenReturn(test); 
	    assertNotEquals(mealDao.findByUser(test),foodServ.getFoodByUser(0));
	}
	
	@Test 
	public void testFoodIdNotNull () {
		Food test = new Food(); 
		assertNotNull(test.getId());
		
	}
	
	
	@Test 
	public void testSetId() {
		Food test = new Food(); 
		test.setId(100);
		assertEquals(test.getId(),100); 
	}
	
	@Test 
	public void testNameNull () {
		Food test = new Food(); 
		assertNull(test.getName());
	}
	
	@Test 
	public void testSetName() {
		Food test = new Food(); 
		test.setName("Pranav");
		assertEquals(test.getName(),"Pranav"); 
	}
	
	@Test 
	public void testUrlNull () {
		Food test = new Food(); 
		assertNull(test.getUrl());
	}
	
	@Test 
	public void testSetUrl() {
		Food test = new Food(); 
		test.setUrl("www.test.com");
		assertEquals(test.getUrl(), "www.test.com"); 
	}
	
	@Test 
	public void testCaloriesNotNull () {
		Food test = new Food(); 
		assertNotNull(test.getCalories());
	}
	
	@Test 
	public void testSetCalories() {
		Food test = new Food(); 
		test.setCalories(100);
		assertEquals(test.getCalories(), 100); 
	}
	
	@Test 
	public void testCarbsNotNull () {
		Food test = new Food(); 
		assertNotNull(test.getCarbs());
	}
	
	@Test 
	public void testSetCarbs() {
		Food test = new Food(); 
		test.setCarbs(100);
		assertEquals(test.getCarbs(), 100); 
	}
	
	
	@Test 
	public void testProteinNotNull () {
		Food test = new Food(); 
		assertNotNull(test.getProtein());
	}
	
	@Test 
	public void testSetProtein() {
		Food test = new Food(); 
		test.setProtein(100);
		assertEquals(test.getProtein(), 100); 
	}
	
	
	@Test 
	public void testfatNotNull () {
		Food test = new Food(); 
		assertNotNull(test.getFat());
	}
	
	@Test 
	public void testSetFat() {
		Food test = new Food(); 
		test.setFat(100);
		assertEquals(test.getFat(), 100); 
	}
	
		
	

}
