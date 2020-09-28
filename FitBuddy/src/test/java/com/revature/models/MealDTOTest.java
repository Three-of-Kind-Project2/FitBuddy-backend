package com.revature.models;


import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class MealDTOTest {
	

	
	@Test 
	public void testId() {
		MealDTO test = new MealDTO();
		assertNotNull(test.getId()); 
	}
	@Test 
	public void testSetUsername() {
		MealDTO test = new MealDTO();
		test.setId(1);
		assertEquals(test.getId(),1);
	}
	@Test 
	public void testTime() {
		MealDTO test = new MealDTO();
		assertNull(test.getTime()); 
	}
	@Test 
	public void testSetTime() {
		MealDTO test = new MealDTO();
		test.setTime("time");
		assertEquals(test.getTime(),"time");
	}
	
	@Test 
	public void testType() {
		MealDTO test = new MealDTO();
		assertNull(test.getType()); 
	}
	@Test 
	public void testSetType() {
		MealDTO test = new MealDTO();
		test.setType("breakfast");
		assertEquals(test.getType(),"breakfast");
	}
	@Test 
	public void testUserId() {
		MealDTO test = new MealDTO();
		assertNotNull(test.getId()); 
	}
	@Test 
	public void setUserId() {
		MealDTO test = new MealDTO();
		test.setId(1);
		assertEquals(test.getId(),1);
	}
	

}
