package com.revature.services;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.models.Meal;
import com.revature.models.User;
import com.revature.repositories.IMealDAO;


public class MealServiceTest {
	
	@InjectMocks
	private MealService mealServ;
	
	@Mock
	private IMealDAO userMeals;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	


}
