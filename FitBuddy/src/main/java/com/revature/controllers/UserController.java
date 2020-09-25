package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.services.IUserService;
import com.revature.services.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private IUserService userServ;
	
	@PostMapping("users")
	public ResponseEntity<?> save(@RequestBody User u) {
		System.out.println("the json value of user is :::::: " + u);
		long id = userServ.save(u);
		return ResponseEntity.ok().body("New User has been saved with ID:" + id);
	}
//	@GetMapping
//	public ResponseEntity<List<User>> allUsers() {
//		return ResponseEntity.ok(this.userDao.allUsers());
//	}
//	
//	@PostMapping(consumes="application/json")
//	public ResponseEntity<List<User>> insert(@RequestBody User u) {
//		System.out.println("Here!");
//		System.out.println(u);
//		
//		if (u.getId() != 0) {
//			return ResponseEntity.badRequest().build();
//		}
//		
//		this.userDao.insert(u);
//		
//		if (u.getId() == 0) {
//			// Failed to properly save
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//		return ResponseEntity.ok(this.userDao.allUsers());
//	}
}