package com.revature.models;
import static org.junit.Assert.*;
import org.junit.Test;

public class LoginDTOTest {
	@Test 
	public void testUsername() {
		LoginDTO test = new LoginDTO();
		assertNull(test.getUsername()); 
	}
	@Test 
	public void testSetUsername() {
		LoginDTO test = new LoginDTO();
		test.setUsername("test");
		assertEquals(test.getUsername(),"test");
	}
	
	@Test 
	public void testPassword() {
		LoginDTO test = new LoginDTO();
		assertNull(test.getPassword()); 
	}
	@Test 
	public void testSetPassword() {
		LoginDTO test = new LoginDTO();
		test.setPassword("test");
		assertEquals(test.getPassword(),"test");
	}
	
}
