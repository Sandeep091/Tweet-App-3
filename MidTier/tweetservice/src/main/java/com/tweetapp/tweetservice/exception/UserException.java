package com.tweetapp.tweetservice.exception;

import java.util.Date;

/**
 * @author Sandeeep
 *
 */
public class UserException extends Exception {

	private static final long serialVersionUID = 1L;
	private Date timeStamp;
	private String message;
	private String code;

	public UserException(Date timeStamp, String message, String code) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.code = code;
	}

	public UserException(String message) {
		super();
		this.timeStamp = new Date();
		this.message = message;
	}

	public UserException(String message, String code) {
		super();
		this.timeStamp = new Date();
		this.message = message;
		this.code = code;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}