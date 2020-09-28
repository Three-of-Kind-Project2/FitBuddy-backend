package com.revature.models;
import static org.junit.Assert.*;

import org.junit.Test;

public class FoodDTOTest {

	@Test 
	public void testCalories() {
		FoodDTO test = new FoodDTO();
		assertNotNull(test.getCalories()); 
	}
	
	@Test
	public void testSetCalories() {
		FoodDTO test = new FoodDTO();
		test.setCalories(100);
		assertEquals(test.getCalories(),100); 
	}
	
	@Test 
	public void testcarbs() {
		FoodDTO test = new FoodDTO();
		assertNotNull(test.getCarbs()); 
	}
	
	@Test
	public void testSetCarbs() {
		FoodDTO test = new FoodDTO();
		test.setCarbs(100);
		assertEquals(test.getCarbs(),100); 
	}
	
	@Test 
	public void testfat() {
		FoodDTO test = new FoodDTO();
		assertNotNull(test.getFat()); 
	}
	
	@Test
	public void testSetFat() {
		FoodDTO test = new FoodDTO();
		test.setFat(100);
		assertEquals(test.getFat(),100); 
	}
	
	@Test 
	public void testUrl() {
		FoodDTO test = new FoodDTO();
		assertNull(test.getUrl()); 
	}
	@Test
	public void testSetUrl() {
		FoodDTO test = new FoodDTO();
		test.setUrl("www.test.com");
		assertEquals(test.getUrl(),"www.test.com"); 
	}
	@Test 
	public void testProtein() {
		FoodDTO test = new FoodDTO();
		assertNotNull(test.getProtein()); 
	}
	@Test
	public void testSetProtein() {
		FoodDTO test = new FoodDTO();
		test.setProtein(100);
		assertEquals(test.getProtein(),100); 
	}
	@Test 
	public void testName() {
		FoodDTO test = new FoodDTO();
		assertNull(test.getName()); 
	}
	
	@Test
	public void testSetName() {
		FoodDTO test = new FoodDTO();
		test.setName("Pranav Udayakumar");
		assertEquals(test.getName(),"Pranav Udayakumar"); 
	}
	
}
