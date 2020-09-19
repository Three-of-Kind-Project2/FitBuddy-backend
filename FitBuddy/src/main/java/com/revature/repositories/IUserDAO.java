package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {
	public List<User> allUsers();
	public User findById(int id);
	public User findByUsername(String username);
	public boolean insert(User u);
	public boolean update(User u);
	public void delete(User u);
}
