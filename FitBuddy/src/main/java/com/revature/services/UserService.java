package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;

@Service
public class UserService {
	
	@Autowired
	private IUserDAO userDao;
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public List<User> getAllUsers() {
		userDao = ac.getBean(IUserDAO.class);
		
		return userDao.allUsers();
	}
	
	public User findUser(int id) {
		userDao = ac.getBean(IUserDAO.class);
		
		return userDao.findById(id);
	}
	
	public User findUser(String username) {
		userDao = ac.getBean(IUserDAO.class);
		
		return userDao.findByUsername(username);
	}
}
