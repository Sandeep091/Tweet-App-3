package com.tweetapp.tweetservice.service;

import java.util.List;

import com.tweetapp.tweetservice.bean.PostResponse;
import com.tweetapp.tweetservice.bean.Reply;
import com.tweetapp.tweetservice.entity.Post;
import com.tweetapp.tweetservice.exception.UserException;

/**
 * @author Sandeep
 *
 */
public interface PostService {

	public List<Post> getAllTweet() throws UserException;

	public List<Post> getAllTweetByUserName(String userName) throws UserException;

	public PostResponse addTweet(String userName, Post post) throws UserException;

	public String deleteTweet(String id) throws UserException;

	public PostResponse updateTweet(String id, Post post) throws UserException;

	public PostResponse likeTweet(String id) throws UserException;
	
	public PostResponse replyToTweet(String userName,String id,Reply reply) throws UserException;

}