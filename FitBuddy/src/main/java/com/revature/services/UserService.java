package com.revature.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
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
	
	public List<User> getAllUsers() {
		return userDao.allUsers();
	}
	
	public User findUser(int id) {
		return userDao.findById(id);
	}
	
//	public User findUser(String username) {
//		
//		return userDao.findByUsername(username);
//	}
	
//	public User register(User u) {
//		String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
//		u.setPassword(hashed);
//		
//		int id = userDao.insert(u);
//		if (id != 0) {
//			u.setId(id);
//			return userDao.update(u);
//		}
//		
//		return null;
//	}
	
	public User update(User u) {
		return userDao.update(u);
	}
	
	public void delete(User u) {
		userDao.delete(u);
	}
}
