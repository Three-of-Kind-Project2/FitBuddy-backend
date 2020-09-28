package com.revature.models;
import static org.junit.Assert.*;
import org.junit.Test;

public class MealTest {

	@Test 
	public void testId() {
		Meal test = new Meal();
		assertNotNull(test.getId()); 
	}
	@Test 
	public void testGetId() {
		Meal test = new Meal();
		test.setId(1);
		assertEquals(test.getId(),1);
	}
	@Test 
	public void testType() {
		Meal test = new Meal();
		assertNull(test.getType()); 
	}
	@Test 
	public void testGetType() {
		Meal test = new Meal();
		test.setType("breakfast");
		assertEquals(test.getType(),"breakfast");
	}
	@Test 
	public void testUser() {
		Meal test = new Meal();
		assertNull(test.getUser()); 
	}
	@Test 
	public void testGetUser() {
		User user = new User(1, "Pranav", "Udayakumar", "test", "test", "test@hotmail.com", 100);
		Meal test = new Meal();
		test.setUser(user);
		assertEquals(test.getUser(),user);
	}
	

}
