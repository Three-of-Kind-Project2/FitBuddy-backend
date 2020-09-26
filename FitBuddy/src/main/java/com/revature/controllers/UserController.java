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

import com.revature.models.AddUserDTO;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userServ;
	
	@GetMapping
	public ResponseEntity<List<User>> allUsers() {
		return ResponseEntity.ok(this.userServ.getAllUsers());
	}
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping("login")
	@PostMapping
	public ResponseEntity<User> login(@RequestBody LoginDTO loginDto) {
        if(loginDto.getUsername() == null || loginDto.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        }

		User retUser = this.userServ.login(loginDto.getUsername(), loginDto.getPassword());
		
		return ResponseEntity.ok(retUser);
	}
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping("users")
	@PostMapping
	public ResponseEntity<List<User>> insert(@RequestBody AddUserDTO userDto) {
		User u = new User(userDto.getId(), userDto.getFirstname(), 
				userDto.getLastname(), userDto.getUsername(), 
				userDto.getPassword(), userDto.getEmail(),
				userDto.getGoal());
		
		if(u.getId() != 0) {
			return ResponseEntity.badRequest().build();
		}
		
		this.userServ.register(u);
		
		if(u.getId() == 0) {
			// Failed to properly save
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.ok(this.userServ.getAllUsers());
	}
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping("update")
	@PostMapping
	public ResponseEntity<User> update(@RequestBody AddUserDTO userDto) {
		User u = new User(userDto.getId(), userDto.getFirstname(), 
				userDto.getLastname(), userDto.getUsername(), 
				userDto.getPassword(), userDto.getEmail(),
				userDto.getGoal());
		
		User updated = this.userServ.update(u);
		
		if (updated == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.ok(updated);
	}
}
