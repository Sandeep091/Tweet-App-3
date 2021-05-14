package com.tweetapp.tweetservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tweetapp.tweetservice.bean.UserResponse;
import com.tweetapp.tweetservice.entity.User;

/**
 * @author Sandeep
 *
 */
public interface UserController {

	public ResponseEntity<UserResponse> getAllUsers();

	public ResponseEntity<UserResponse> userLogin(@RequestBody User logInfo);

	public ResponseEntity<UserResponse> registerUser(@RequestBody User user);
	
	public ResponseEntity<UserResponse> getUserByUsername(@PathVariable("userName")String userName);
	
	public ResponseEntity<UserResponse> forgotPassword(@PathVariable("userName")String userName , @RequestBody User userPassword);
}