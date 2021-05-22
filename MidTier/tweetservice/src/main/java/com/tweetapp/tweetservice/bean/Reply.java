package com.tweetapp.tweetservice.bean;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

/**
 * @author Sandeep
 *
 */
@DynamoDBDocument
public class Reply {

	@DynamoDBAttribute
	private String userName;
	@DynamoDBAttribute
	private String tags;
	@DynamoDBAttribute
	private String message;

	public Reply(String userName, String tags, String message) {
		super();
		this.userName = userName;
		this.tags = tags;
		this.message = message;
	}

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "Reply [userName=" + userName + ", tags=" + tags + ", message=" + message+ "]";
	}

}