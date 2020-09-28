package com.revature.models;
import static org.junit.Assert.*;

import org.junit.Test;


public class AddUserDTOTest {
 
	@Test 
	public void testGetEmail() {
		AddUserDTO test = new AddUserDTO();
		assertNull(test.getEmail()); 
	}
	
	@Test 
	public void testsetEmail() {
		AddUserDTO test = new AddUserDTO();
		test.setEmail("test@gmail.com"); 
		assertEquals(test.getEmail(),"test@gmail.com"); 
	}
	
	@Test 
	public void testFirstName() {
		AddUserDTO test = new AddUserDTO();
		assertNull(test.getFirstname()); 
	}
	
	
	
	
	@Test 
	public void testSetFirstName() {
		AddUserDTO test = new AddUserDTO();
		test.setFirstname("Test");
		assertEquals(test.getFirstname(),"Test"); 
	}
	
	@Test 
	public void testLastname() {
		AddUserDTO test = new AddUserDTO();
		assertNull(test.getLastname()); 
	}
	
	@Test 
	public void testSetLastName() {
		AddUserDTO test = new AddUserDTO();
		test.setLastname("Test");
		assertEquals(test.getLastname(),"Test"); 
	}
	
	@Test 
	public void testGoal() {
		AddUserDTO test = new AddUserDTO();
		assertNotNull(test.getGoal()); 
	}
	
	@Test 
	public void testSetGoal() {
		AddUserDTO test = new AddUserDTO();
		test.setGoal(100);;
		assertEquals(test.getGoal(),100); 
	}
	
	@Test 
	public void testId() {
		AddUserDTO test = new AddUserDTO();
		assertNotNull(test.getId()); 
	}
	
	
	@Test 
	public void testSetId() {
		AddUserDTO test = new AddUserDTO();
		test.setId(1);;
		assertEquals(test.getId(),1); 
	}
	
	@Test 
	public void testUsername() {
		AddUserDTO test = new AddUserDTO();
		assertNull(test.getUsername()); 
	}
	
	
	@Test 
	public void testSetUsername() {
		AddUserDTO test = new AddUserDTO();
		test.setUsername("test");;
		assertEquals(test.getUsername(),"test"); 
	}

	
	
}
