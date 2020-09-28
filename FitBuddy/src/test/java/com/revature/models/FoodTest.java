package com.revature.models;
import static org.junit.Assert.*;

import org.junit.Test;

public class FoodTest {
	
	@Test 
	public void testId() {
		Food test = new Food();
		assertNotNull(test.getId()); 
	}
	@Test 
	public void testName() {
		Food test = new Food();
		assertNull(test.getName()); 
	}
	@Test 
	public void testUrl() {
		Food test = new Food();
		assertNull(test.getUrl()); 
	}
	
	@Test 
	public void testCalories() {
		Food test = new Food();
		assertNotNull(test.getCalories()); 
	}
	
	@Test 
	public void testCarbs() {
		Food test = new Food();
		assertNotNull(test.getCarbs()); 
	}
	
	@Test 
	public void testProteins() {
		Food test = new Food();
		assertNotNull(test.getProtein()); 
	}
	@Test 
	public void testFat() {
		Food test = new Food();
		assertNotNull(test.getFat()); 
	}

	

}
