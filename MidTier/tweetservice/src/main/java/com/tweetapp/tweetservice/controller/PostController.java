package com.tweetapp.tweetservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tweetapp.tweetservice.bean.PostResponse;
import com.tweetapp.tweetservice.bean.Reply;
import com.tweetapp.tweetservice.entity.Post;

/**
 * @author Sandee
 *
 */
public interface PostController {

	public ResponseEntity<PostResponse> getAllTweet();

	public ResponseEntity<PostResponse> getAllTweetByUserName(@PathVariable String userName);

	public ResponseEntity<PostResponse> updateTweet(@PathVariable String userName, @PathVariable String id,
			@RequestBody Post post);

	public ResponseEntity<PostResponse> deleteTweet(@PathVariable String userName, @PathVariable String id);

	public ResponseEntity<PostResponse> likeATweet(@PathVariable String userName, @PathVariable String id);

	public ResponseEntity<PostResponse> replyToTweet(@PathVariable String userName, @PathVariable String id,
			@RequestBody Reply reply);

	public ResponseEntity<PostResponse> addTweet(@PathVariable String userName, @RequestBody Post post);


}