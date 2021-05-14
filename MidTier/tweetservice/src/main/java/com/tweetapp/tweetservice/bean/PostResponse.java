package com.tweetapp.tweetservice.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tweetapp.tweetservice.entity.Post;

/**
 * @author Sandeep
 *
 */
public class PostResponse {

	@JsonProperty(value = "status", required = true)
	private boolean status = true;

	@JsonProperty(value = "message", required = true)
	private String message = "Success";

	private List<Post> posts;

	private Post post;

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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
}