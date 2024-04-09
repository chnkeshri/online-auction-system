package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.UserRepository;
import com.example.model.User;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;  

  @Override
  public User registerUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));  
    return userRepository.save(user);
  }

  @Override
  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public User getUserByUsername(String username) {
    return userRepository.findByUsername(username).orElse(null);
  }

  @Override
  public User getCurrentUser() {
    User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return userRepository.findById(principal.getId()).orElse(null); 
  }

  @Override
  public boolean authenticateUser(String username, String password) {
    User user = getUserByUsername(username);
    if (user != null) {
      return passwordEncoder.matches(password, user.getPassword());
    }
    return false;
  }

@Override
public User saveUser(User user) {
	 return userRepository.save(user);
}
}