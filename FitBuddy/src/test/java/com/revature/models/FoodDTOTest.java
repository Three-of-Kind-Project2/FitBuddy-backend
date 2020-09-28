package com.revature.models;
import static org.junit.Assert.*;

import org.junit.Test;

public class FoodDTOTest {

	@Test 
	public void testCalories() {
		Food test = new Food();
		assertNotNull(test.getCalories()); 
	}
	
	@Test 
	public void testcarbs() {
		Food test = new Food();
		assertNotNull(test.getCarbs()); 
	}
	
	@Test 
	public void testfat() {
		Food test = new Food();
		assertNotNull(test.getFat()); 
	}
	
	@Test 
	public void testUrl() {
		Food test = new Food();
		assertNull(test.getUrl()); 
	}
	@Test 
	public void testProtein() {
		Food test = new Food();
		assertNotNull(test.getProtein()); 
	}
	@Test 
	public void testName() {
		Food test = new Food();
		assertNull(test.getName()); 
	}
	
}
