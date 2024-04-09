package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.UserAlreadyExistsException;
import com.example.Request.LoginRequest;
import com.example.model.User;
import com.example.service.UserService;


	@RestController
	@RequestMapping("/api/users")
	public class UserController {

	  @Autowired
	  private UserService userService;

	  @PostMapping("/register")
	  public ResponseEntity<User> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
	    User createdUser = userService.registerUser(user);
	    return ResponseEntity.ok(createdUser);
	  }

	  @GetMapping("/{id}")
	  public ResponseEntity<User> getUserById(@PathVariable Long id) {
	    User user = userService.getUserById(id);
	    if (user != null) {
	      return ResponseEntity.ok(user);
	    } else {
	      return ResponseEntity.notFound().build();
	    }
	  }

	  @GetMapping("/current")
	  public ResponseEntity<User> getCurrentUser() {
	    User currentUser = userService.getCurrentUser();
	    if (currentUser != null) {
	      return ResponseEntity.ok(currentUser);
	    } else {
	      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
	    }
	  }

	  @PutMapping("/{id}")
	  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody LoginRequest updateDetails) {
	    User user = userService.getUserById(id);
	    if (user == null) {
	      return ResponseEntity.notFound().build();
	    }
	    user = userService.saveUser(user); 
	    return ResponseEntity.ok(user);
	  }
	}

