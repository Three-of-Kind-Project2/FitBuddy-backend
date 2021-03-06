package com.revature.services;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	public void testFindByIdNotNull() {
		User test = new User(0, "test", "test", "Test", "Test", "test@mail.com", 2000);
		when(userDao.findById(0)).thenReturn(test);
		assertNotNull(userServ.findUser(0)); 
		
	}
	

	@Test 
	public void testInsertUser() {
		User test = new User(0, "test", "test", "Test", "Test", "test@mail.com", 2000);
		userDao.insert(test);
	    assertNotNull(userDao.getClass());
	    
 
	   
	   
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
		User test = new User(0, "test", BCrypt.hashpw("test", BCrypt.gensalt()), "Test", "Test", "test@mail.com", 2000);
		when(userDao.findByUsername("test")).thenReturn(test);
		
		assertEquals(userServ.login("wrongUN", "test"), null);
	}
	
	@Test 
	public void testUserExists() {
		User test = new User(); 
		assertNotNull(test); 
		
	}
	
	@Test 
	public void testSetUsername() {
		User test = new User(); 
		test.setUsername("test");
		assertEquals(test.getUsername(), "test"); 
	}
	
	
	@Test 
	public void testUsernameNull() {
		User test = new User();
		assertNull(test.getUsername()); 
	}
	
	@Test 
	public void testSetPassword() {
		User test = new User(); 
		test.setPassword("test");
		assertEquals(test.getPassword(), "test"); 
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
	public void testSetId() {
		User test = new User(); 
		test.setId(1);
		assertEquals(test.getId(), 1); 
	}
	
	@Test
	public void testGoalExists() {
		User test = new User(); 
		assertNotNull(test.getGoal());
		
	}
	
	@Test 
	public void testSetGoal() {
		User test = new User(); 
		test.setGoal(100);
		assertEquals(test.getGoal(), 100); 
	}
	
	@Test
	public void testEmailNull() {
		User test = new User();
		assertNull(test.getEmail());
	}
	
	@Test 
	public void testSetEmail() {
		User test = new User(); 
		test.setEmail("test@gmail.com");
		assertEquals(test.getEmail(), "test@gmail.com"); 
	}
	
	@Test
	public void testFirstNameNull() {
		User test = new User();
		assertNull(test.getFirstname());
	}
	
	@Test 
	public void testSetFirstName() {
		User test = new User(); 
		test.setFirstname("test");
		assertEquals(test.getFirstname(), "test"); 
	}
	
	@Test
	public void testLastNameNull() {
		User test = new User();
		assertNull(test.getLastname());
	}
	
	@Test 
	public void testSetLastName() {
		User test = new User(); 
		test.setLastname("test");
		assertEquals(test.getLastname(), "test"); 
	}
	
	@Test
	public void testClassExists() {
		User test = new User();
		assertNotNull(test.getClass());
	}
	@Test
	public void testgetAllUsers() {
		IUserDAO userDAO = Mockito.mock(IUserDAO.class);
		UserService userService = Mockito.mock(UserService.class);
		final List<User> testUser = new ArrayList<>();
		Mockito.when(userDAO.allUsers()).thenReturn(testUser);
		assertNotNull(userService.getAllUsers());
	}
	
	@Test
	public void testfindUsers() {
	
		User test = new User(0, "test", "test", "Test", "Test", "test@mail.com", 2000);
		Mockito.when(userDao.findById(0)).thenReturn(test);  
		assertNotNull(userServ.findUser(0)); 
	}
	
	@Test 
	public void testFindByUsername() {
      
		User test = new User(0, "Test", "Test", "Test", "Test", "test@mail.com", 2000);
		when(userDao.findByUsername("Test")).thenReturn(test);  
		
	    assertEquals(userServ.findUser("Test"), test); 
	    
	}
	
   @Test 
   public void testUpdateUser() {
	   User test = new User(0, "Test", "Test", "Test", "Test", "test@mail.com", 2000);
	   when(userDao.update(test)).thenReturn(test); 
	   assertEquals(userServ.update(test),userDao.update(test));
       
	  
   }
   

   

}
