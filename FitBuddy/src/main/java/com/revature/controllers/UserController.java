package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userServ;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getusers", method = RequestMethod.GET)
	public List<User> allUsers() {
		return userServ.getAllUsers();
	}
}