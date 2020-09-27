package com.revature.services;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.models.Food;
import com.revature.repositories.IFoodDAO;

public class FoodServiceTest {
	
	
	@InjectMocks
	private FoodService foodServ;
	
	@Mock
	private IFoodDAO userFood; 
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

}
