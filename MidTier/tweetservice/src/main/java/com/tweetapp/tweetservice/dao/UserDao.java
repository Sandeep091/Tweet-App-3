package com.tweetapp.tweetservice.dao;

import java.util.List;

import com.tweetapp.tweetservice.entity.User;
import com.tweetapp.tweetservice.exception.UserException;

/**
 * @author Sandeep
 *
 */
public interface UserDao {

	public List<User> getAllUsers() throws UserException;

	public String registerUser(User user) throws UserException;

	public User getUserByUsername(String userName) throws UserException;

	public User getUserByEmail(String email) throws UserException;

	public String changePassword(User user) throws UserException;

}