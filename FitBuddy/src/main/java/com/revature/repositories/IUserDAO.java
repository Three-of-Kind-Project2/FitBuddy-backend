package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {
	public List<User> allUsers();
	public User findById(int id);
	public User findByUsername(String username);
	public int insert(User u);
	public boolean update(User u);
	public boolean delete(User u);
}
