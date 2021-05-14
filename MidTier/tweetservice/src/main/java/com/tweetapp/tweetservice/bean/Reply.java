package com.tweetapp.tweetservice.bean;

import java.util.Date;
import java.util.List;

/**
 * @author Sandeep
 *
 */
public class Reply {

	private String userName;
	private List<String> tags;
	private String message;
	private Date createdAt;

	public Reply(String userName, List<String> tags, String message, Date createdAt) {
		super();
		this.userName = userName;
		this.tags = tags;
		this.message = message;
		this.createdAt = createdAt;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt() {
		this.createdAt = new Date();
	}

}