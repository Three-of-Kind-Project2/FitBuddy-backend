package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin("http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userServ;
	
	@GetMapping
	public ResponseEntity<List<User> > allUsers() {
		return ResponseEntity.ok(this.userServ.getAllUsers());
	}
}
