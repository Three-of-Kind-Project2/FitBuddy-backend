package com.revature.services;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;

public class UserServiceTest {

	@InjectMocks
	private UserService userServ;
	
	@Mock
	private IUserDAO userDao;
		
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRegisterSuccess() {
		User test = new User(0, "test", "test", "Test", "Test", "test@mail.com", 2000);
		when(userDao.insert(test)).thenReturn(1);
		when(userDao.update(test)).thenReturn(new User(1, "test", BCrypt.hashpw("test", BCrypt.gensalt()), "Test", "Test", "test@mail.com", 2000));
		
		User registered = userServ.register(test);
		
		assertEquals(registered.getId(), 1);
		assertNotEquals(registered.getPassword(), "test");
	}

	@Test
	public void testUsernameTakenFailure() {
		User test = new User(0, "test", "test", "Test", "Test", "test@mail.com", 2000);
		when(userDao.insert(test)).thenReturn(0);
		when(userDao.update(test)).thenReturn(new User(1, "test", BCrypt.hashpw("test", BCrypt.gensalt()), "Test", "Test", "test@mail.com", 2000));
		
		User registered = userServ.register(test);
		
		assertEquals(registered, null);
	}
	
	@Test
	public void testLoginSuccess() {
		User test = new User(0, "Test", "Test", "test", BCrypt.hashpw("test", BCrypt.gensalt()), "test@mail.com", 2000);
		when(userDao.findByUsername("test")).thenReturn(test);
		
		assertEquals(userServ.login("test", "test"), test);
	}
	
	@Test
	public void testIncorrectPasswordFailure() {
		User test = new User(0, "Test", "Test", "test", BCrypt.hashpw("test", BCrypt.gensalt()), "test@mail.com", 2000);
		when(userDao.findByUsername("test")).thenReturn(test);
		
		assertEquals(userServ.login("test", "wrongPW"), null);
	}
	
	@Test
	public void testUsernameNotFoundFailure() {
		User test = new User(0, "Test", "Test", "test", BCrypt.hashpw("test", BCrypt.gensalt()), "test@mail.com", 2000);
		when(userDao.findByUsername("test")).thenReturn(test);
		
		assertEquals(userServ.login("wrongUN", "test"), null);
	}
	
	@Test 
	public void testUserExists() {
		User test = new User(); 
		assertNotNull(test); 
		
	}
	
	@Test 
	public void testUsernameNull() {
		User test = new User();
		assertNull(test.getUsername()); 
	}
	
	@Test 
	public void testPasswordNull() {
		User test = new User();
		assertNull(test.getPassword()); 
	}
	
	
	@Test
	public void testIdExists() {
		User test = new User(); 
		assertNotNull(test.getId());
		
	}
	
	@Test
	public void testGoalExists() {
		User test = new User(); 
		assertNotNull(test.getGoal());
		
	}
	
	@Test
	public void testEmailNull() {
		User test = new User();
		assertNull(test.getEmail());
	}
	
	@Test
	public void testFirstNameNull() {
		User test = new User();
		assertNull(test.getFirstname());
	}
	
	@Test
	public void testLastNameNull() {
		User test = new User();
		assertNull(test.getLastname());
	}
	
	@Test
	public void testClassExists() {
		User test = new User();
		assertNotNull(test.getClass());
	}
	
	


	
	
	
	
}
