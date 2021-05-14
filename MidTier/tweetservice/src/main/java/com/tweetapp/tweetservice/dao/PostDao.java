package com.tweetapp.tweetservice.dao;

import java.util.List;

import com.tweetapp.tweetservice.entity.Post;
import com.tweetapp.tweetservice.exception.UserException;

/**
 * @author Sandeep
 *
 */
public interface PostDao {

	Post addTweet(Post post) throws UserException;

	List<Post> getAllTweet() throws UserException;

	List<Post> getAllTweetByUserName(String userName) throws UserException;

	Post findById(String id) throws UserException;

	Post updateTweet(Post post) throws UserException;

	String deleteTweet(String id) throws UserException;

	Post updateLike(Post post) throws UserException;
	
	Post replyToTweet(Post post) throws UserException;

}