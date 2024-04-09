package com.example.Exception;

public class UserAlreadyExistsException extends RuntimeException {

	  public UserAlreadyExistsException() {
	    super("Username already exists!");
	  }

	  public UserAlreadyExistsException(String message) {
	    super(message);
	  }
	}