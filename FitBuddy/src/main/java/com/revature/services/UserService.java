package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;

@Service
@Transactional(readOnly = true)
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDao;

	@Transactional
	@Override
	public long save(User u) {
		return userDao.save(u);
	}
//	
//	public List<User> getAllUsers() {
//		return userDao.allUsers();
//	}
//	
//	public User findUser(int id) {
//		return userDao.findById(id);
//	}
//	
//	public int insertUser(User u) {
//		return userDao.insert(u);
//	}
////	public User findUser(String username) {
////		
////		return userDao.findByUsername(username);
////	}
//	
////	public User register(User u) {
////		String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
////		u.setPassword(hashed);
////		
////		int id = userDao.insert(u);
////		if (id != 0) {
////			u.setId(id);
////			return userDao.update(u);
////		}
////		
////		return null;
////	}
//	
//	public User update(User u) {
//		return userDao.update(u);
//	}
//	
//	public void delete(User u) {
//		userDao.delete(u);
//	}
}
