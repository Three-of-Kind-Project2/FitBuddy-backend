package com.revature.models;
import static org.junit.Assert.*;

import org.junit.Test;


public class AddUserDTOTest {
 
	@Test 
	public void testEmail() {
		AddUserDTO test = new AddUserDTO();
		assertNull(test.getEmail()); 
	}
	
	@Test 
	public void testFirstname() {
		AddUserDTO test = new AddUserDTO();
		assertNull(test.getFirstname()); 
	}
	
	@Test 
	public void testLastname() {
		AddUserDTO test = new AddUserDTO();
		assertNull(test.getLastname()); 
	}
	
	@Test 
	public void testGoal() {
		AddUserDTO test = new AddUserDTO();
		assertNotNull(test.getGoal()); 
	}
	
	@Test 
	public void testId() {
		AddUserDTO test = new AddUserDTO();
		assertNotNull(test.getId()); 
	}
	
	@Test 
	public void testUsername() {
		AddUserDTO test = new AddUserDTO();
		assertNull(test.getUsername()); 
	}
	
	

	
	
}
