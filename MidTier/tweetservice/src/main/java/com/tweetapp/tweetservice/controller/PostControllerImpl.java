package com.tweetapp.tweetservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.tweetservice.bean.PostResponse;
import com.tweetapp.tweetservice.bean.Reply;
import com.tweetapp.tweetservice.entity.Post;
import com.tweetapp.tweetservice.exception.UserException;
import com.tweetapp.tweetservice.service.PostService;
import com.tweetapp.tweetservice.util.LoggerConst;

import io.swagger.annotations.Api;

/**
 * @author Sandeep
 *
 */
@Api(value = "PostServiceImpl")
@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/tweets/")
public class PostControllerImpl implements PostController {

	@Autowired
	PostService postService;

	@GetMapping(value = "all")
	@Override
	public ResponseEntity<PostResponse> getAllTweet() {
		PostResponse res = new PostResponse();
		try {
			LoggerConst.LOG.info("Get All Tweet - Inside Controller");
			res.setPosts(postService.getAllTweet());
			LoggerConst.LOG.info("Success in getting all tweet - Inside Controller");
		} catch (UserException e) {
			LoggerConst.LOG.info("Error while Get All Tweet - Inside Controller");
			res.setStatus(false);
			res.setMessage("Failed to get All Tweets");
		}
		return ResponseEntity.ok().body(res);
	}

	@GetMapping(value = "{userName}")
	@Override
	public ResponseEntity<PostResponse> getAllTweetByUserName(@PathVariable String userName) {
		PostResponse res = new PostResponse();
		try {
			LoggerConst.LOG.info("Get All tweet by user name - Inside Controller");
			res.setPosts(postService.getAllTweetByUserName(userName));
			LoggerConst.LOG.info("Success in getting all tweet by name - Inside Controller");
		} catch (UserException e) {
			LoggerConst.LOG.info("Error while Get All tweet by username - Inside Controller");
			res.setStatus(false);
			res.setMessage("Failed to get all tweet of a user");
		}
		return ResponseEntity.ok().body(res);
	}

	@PutMapping(value = "{userName}/update/{id}")
	@Override
	public ResponseEntity<PostResponse> updateTweet(@PathVariable String userName, @PathVariable String id,
			@RequestBody Post post) {
		PostResponse res = new PostResponse();
		try {
			LoggerConst.LOG.info("Update Tweet - Inside Controller");
			res = postService.updateTweet(id, post);
			LoggerConst.LOG.info("Success updated tweet - Inside Controller");
		} catch (UserException e) {
			LoggerConst.LOG.info("Error while updating tweet - Inside Controller");
			res.setStatus(false);
			res.setMessage("Failed to update the post");
		}
		return ResponseEntity.ok().body(res);
	}

	@DeleteMapping(value = "{userName}/delete/{id}")
	@Override
	public ResponseEntity<PostResponse> deleteTweet(@PathVariable String userName, @PathVariable String id) {
		PostResponse res = new PostResponse();
		try {
			LoggerConst.LOG.info("Delete Tweet - Inside Controller");
			res.setMessage(postService.deleteTweet(id));
			LoggerConst.LOG.info("Success deleted tweet - Inside Controller");
		} catch (UserException e) {
			LoggerConst.LOG.info("Error while deleting tweet - Inside Controller");
			res.setStatus(false);
			res.setMessage("Failed to delete the post");
		}
		return ResponseEntity.ok().body(res);
	}

	@PutMapping(value = "{userName}/like/{id}")
	@Override
	public ResponseEntity<PostResponse> likeATweet(@PathVariable String userName, @PathVariable String id) {
		PostResponse res = new PostResponse();
		try {
			LoggerConst.LOG.info("Like a tweet - Inside Controller");
			res = postService.likeTweet(id);
			LoggerConst.LOG.info("Success liked a tweet - Inside Controller");
		} catch (UserException e) {
			LoggerConst.LOG.info("error while liking tweet - Inside Controller");
			res.setStatus(false);
			res.setMessage("Failed to like a tweet");
		}
		return ResponseEntity.ok().body(res);
	}

	@PostMapping(value = "{userName}/reply/{id}")
	@Override
	public ResponseEntity<PostResponse> replyToTweet(@PathVariable String userName, @PathVariable String id,
			@RequestBody Reply reply) {
		PostResponse res = new PostResponse();
		try {
			LoggerConst.LOG.info("Reply to a tweet - Inside Controller");
			res = postService.replyToTweet(userName, id, reply);
			LoggerConst.LOG.info("Success replied to a tweet - Inside Controller");
		} catch (UserException e) {
			LoggerConst.LOG.info("Errro while replying to a tweet - Inside Controller");
			res.setStatus(false);
			res.setMessage("Failed to save reply");
		}
		return ResponseEntity.ok().body(res);
	}

	@PostMapping(value = "{userName}/add")
	@Override
	public ResponseEntity<PostResponse> addTweet(@PathVariable String userName, @RequestBody Post post) {
		PostResponse res = new PostResponse();
		try {
			LoggerConst.LOG.info("Add Tweet - Inside Controller");
			res = postService.addTweet(userName, post);
			LoggerConst.LOG.info("Success in adding tweet - Inside Controller");
		} catch (UserException e) {
			LoggerConst.LOG.info("Error while Adding Tweet - Inside Controller");
			res.setStatus(false);
			res.setMessage("Failed to post tweet");
		}
		return ResponseEntity.ok().body(res);
	}

}