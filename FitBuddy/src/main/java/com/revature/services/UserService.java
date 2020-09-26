package com.revature.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public int insertUser(User u) {
		return userDao.insert(u);
	}
	
	public User findUser(String username) {
		return userDao.findByUsername(username);
	}
	
	public User register(User u) {
		String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashed);
		int id = userDao.insert(u);
		if (id != 0) {
			u.setId(id);
			return userDao.update(u);
		}
		return null;
	}
	
	public User update(User u) {
		return userDao.update(u);
	}
	
	public void delete(User u) {
		userDao.delete(u);
	}
	
	public User login(String username, String password) {
		User u = findUser(username);
		System.out.println(u);
		if (u != null) {
			if (BCrypt.checkpw(password, u.getPassword())) {
				System.out.println("Password matches!");
				return u;
			}
		}
		return null;
	}
}
