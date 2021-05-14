package com.tweetapp.tweetservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.tweetservice.bean.UserResponse;
import com.tweetapp.tweetservice.dao.UserDao;
import com.tweetapp.tweetservice.entity.User;
import com.tweetapp.tweetservice.exception.UserException;
import com.tweetapp.tweetservice.util.LoggerConst;

/**
 * @author Sandeep
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public List<User> getAllUser() throws UserException {
		LoggerConst.LOG.info("Get all Users - Inside Service");
		return userDao.getAllUsers();
	}

	@Override
	public UserResponse userLogin(String userName, String password) throws UserException {
		LoggerConst.LOG.info("User login - Inside Service");
		User user = userDao.getUserByUsername(userName);
		LoggerConst.LOG.info("User"+user);
		UserResponse res = new UserResponse();
		if (user != null) {
			if (password.contentEquals(user.getPassword())) {
				res.setStatus(true);
				res.setUser(user);
				res.setMessage("Logged in Successfully");
				LoggerConst.LOG.info("User logged Sccessfully - Inside Service");
			} else {
				res.setStatus(false);
				res.setMessage("Invalid password");
				LoggerConst.LOG.info("Invalide password while logging - Inside Service");
			}
		} else {
			res.setStatus(false);
			res.setMessage("Invalid userName");
			LoggerConst.LOG.info("Invalid userName while logging - Inside Service");
		}
		return res;
	}

	@Override
	public UserResponse registerUser(User user) throws UserException {
		UserResponse res = new UserResponse();
		LoggerConst.LOG.info("user registering - Inside Service");
		User userExist = userDao.getUserByEmail(user.getEmail());
		if (userExist == null) {
			User userNameCheck = userDao.getUserByUsername(user.getUserName());
			if (userNameCheck == null) {
				user.setNotification(new ArrayList<String>());
				res.setMessage(userDao.registerUser(user));
				LoggerConst.LOG.info("Successfully registered user - Inside Service");
			} else {
				LoggerConst.LOG.info("User Already exist - Inside Service");
				res.setStatus(false);
				res.setMessage("UserName already exist");
			}
		} else {
			LoggerConst.LOG.info("Email already exist while registring - Inside Service");
			res.setStatus(false);
			res.setMessage("Email already exist");
		}
		return res;
	}

	@Override
	public User getUserByUsername(String userName) throws UserException {
		LoggerConst.LOG.info("Get user by username - Inside Service");
		return userDao.getUserByUsername(userName);
	}

	@Override
	public UserResponse forgotPassword(String userName, String password) throws UserException {
		UserResponse res = new UserResponse();
		User userExist = userDao.getUserByUsername(userName);
		LoggerConst.LOG.info("Forgot password - Inside Service");
		if (userExist == null) {
			res.setStatus(false);
			res.setMessage("Invaild userName..");
			LoggerConst.LOG.info("Invalid userName  - Inside Service");
		} else {
			userExist.setPassword(password);
			userDao.changePassword(userExist);
			res.setMessage("Password Updated !!! ");
			LoggerConst.LOG.info("Password updated successfully  - Inside Service");
		}
		return res;
	}

}