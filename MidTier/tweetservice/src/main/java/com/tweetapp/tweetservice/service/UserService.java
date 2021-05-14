package com.tweetapp.tweetservice.service;

import java.util.List;

import com.tweetapp.tweetservice.bean.UserResponse;
import com.tweetapp.tweetservice.entity.User;
import com.tweetapp.tweetservice.exception.UserException;

/**
 * @author Sandeep
 *
 */
public interface UserService {

	public List<User> getAllUser() throws UserException;

	public UserResponse userLogin(String userName, String password) throws UserException;

	public UserResponse registerUser(User user) throws UserException;

	public User getUserByUsername(String userName) throws UserException;

	public UserResponse forgotPassword(String userName, String password) throws UserException;
	
}