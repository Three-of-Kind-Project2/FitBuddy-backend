package com.revature.services;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.models.Meal;
import com.revature.models.User;
import com.revature.repositories.IMealDAO;
import com.revature.repositories.IUserDAO;


public class MealServiceTest {
	
	@InjectMocks
	private MealService mealServ;
	
	@Mock
	private IMealDAO mealDao;
	
	@Mock
	private IUserDAO userDao;
	
	private User test;
	private LocalDateTime date = LocalDateTime.now();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		test = new User(1, "Test", "Test", "test", "password", "test@mail.com", 2000);
		
	}
	
	@Test
	public void testNewMealWUser() {
		Meal m = new Meal(0, date, "Lunch", test);
		when(mealDao.insert(m)).thenReturn(1);
		when(mealDao.update(m)).thenReturn(new Meal(1, date, "Lunch", test));
		
		assertEquals(mealServ.newMeal(m, test), new Meal(1, date, "Lunch", test));
	}
	
	@Test
	public void testNewMealWId() {
		Meal m = new Meal(0, date, "Lunch", test);
		when(mealDao.insert(m)).thenReturn(1);
		when(mealDao.update(m)).thenReturn(new Meal(1, date, "Lunch", test));
		when(userDao.findById(1)).thenReturn(test);
		
		assertEquals(mealServ.newMeal(m, 1), new Meal(1, date, "Lunch", test));
	}
	
	@Test
	public void testFindMealById() {
		Meal m = new Meal(1, date, "Lunch", test);
		when(mealDao.findById(1)).thenReturn(m);
		
		assertEquals(mealServ.findMeal(1), m);
	}
	
	@Test
	public void testMealsByUserObj() {
		Meal lunch = new Meal(1, date, "Lunch", test);
		Meal dinner = new Meal(2, date, "Dinner", test);
		List<Meal> meals = new ArrayList<>();
		meals.add(lunch);
		meals.add(dinner);
		
		when(mealDao.findByUser(test)).thenReturn(meals);
		assertEquals(mealServ.mealsByUser(test), meals);
	}
	
	@Test
	public void testMealsByUserId() {
		Meal lunch = new Meal(1, date, "Lunch", test);
		Meal dinner = new Meal(2, date, "Dinner", test);
		List<Meal> meals = new ArrayList<>();
		meals.add(lunch);
		meals.add(dinner);
		
		when(mealDao.findByUser(test)).thenReturn(meals);
		when(userDao.findById(1)).thenReturn(test);
		
		assertEquals(mealServ.mealsByUser(1), meals);
	}
	
	@Test
	public void testGetAllMeals() {
		Meal lunch = new Meal(1, date, "Lunch", test);
		Meal dinner = new Meal(2, date, "Dinner", test);
		List<Meal> meals = new ArrayList<>();
		meals.add(lunch);
		meals.add(dinner);
		
		when(mealDao.allMeals()).thenReturn(meals);
		
		assertEquals(mealServ.getAllMeals(), meals);
	}
	
	@Test
	public void testUpdateMeal() {
		Meal lunch = new Meal(1, date, "Lunch", test);
		Meal dinner = new Meal(1, date, "Dinner", test);
		
		when(mealDao.update(lunch)).thenReturn(dinner);
		
		assertEquals(mealServ.update(lunch), dinner);
	}
	
	@Test
	public void testInsertMealSuccess() {
		Meal lunch = new Meal(0, date, "Lunch", test);
		
		when(mealDao.insert(lunch)).thenReturn(1);
		
		mealServ.insert(lunch);
		
		assertEquals(lunch.getId(), 1);
	}
	
	@Test
	public void testInsertFailure() {
		Meal lunch = new Meal(0, date, "Lunch", test);
		
		when(mealDao.insert(lunch)).thenReturn(0);
		
		mealServ.insert(lunch);
		
		assertEquals(lunch.getId(), 0);
	}
	
	@Test
	public void testNewMealWUserObjectSuccess() {
		Meal lunch = new Meal(0, date, "Lunch", null);
		Meal lunchWUser = new Meal(1, date, "Lunch", test);
		
		when(mealDao.update(lunch)).thenReturn(lunchWUser);
		
		assertEquals(mealServ.newMeal(lunch, test).getUser(), test);
	}
	
//	@Test
//	public void testNewMealWUserObjectFailure() {
//		Meal lunch = new Meal(0, date, "Lunch", null);
//		Meal lunchWUser = new Meal(1, date, "Lunch", test);
//		
//		when(mealDao.update(lunch)).thenReturn(lunchWUser);
//		
//		assertEquals(mealServ.newMeal(lunch, test).getUser(), test);
//	}
//	
//	@Test
//	public void testNewMealWUserId() {
//		Meal lunch = new Meal(0, date, "Lunch", null);
//		Meal lunchWUser = new Meal(0, date, "Lunch", test);
//		
//		when(mealDao.update(lunch)).thenReturn(lunchWUser);
//		
//		assertEquals(mealServ.newMeal(lunch, 1).getUser(), test);
//	}

}
