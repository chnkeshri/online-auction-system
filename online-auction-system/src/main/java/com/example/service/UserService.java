package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.User;

@Service
public interface UserService {
	
	User registerUser(User user);

	User getUserById(Long id);

	User getUserByUsername(String username);

	User getCurrentUser();  

	boolean authenticateUser(String username, String password);
	
	public User saveUser(User user);
}

