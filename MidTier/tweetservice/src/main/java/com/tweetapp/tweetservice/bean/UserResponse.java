package com.tweetapp.tweetservice.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tweetapp.tweetservice.entity.User;

/**
 * @author Sandeep
 *
 */

public class UserResponse {

	@JsonProperty(value = "status", required = true)
	private boolean status = true;

	@JsonProperty(value = "message", required = true)
	private String message = "Success";

//	@JsonProperty(value = "users")
	private List<User> users;

//	@JsonProperty(value = "user")
	private User user;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserResponse [status=" + status + ", message=" + message + ", users=" + users + ", user=" + user + "]";
	}

}