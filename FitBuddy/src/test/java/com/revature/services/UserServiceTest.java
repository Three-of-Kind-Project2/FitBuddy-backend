package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
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
		when(userDao.update(test)).thenReturn(new User(1, "test", "test", "Test", "Test", "test@mail.com", 2000));
		
		User registered = userServ.register(test);
		
		assertEquals(registered.getId(), 1);
		assertNotEquals(registered.getPassword(), "test");
	}

}
