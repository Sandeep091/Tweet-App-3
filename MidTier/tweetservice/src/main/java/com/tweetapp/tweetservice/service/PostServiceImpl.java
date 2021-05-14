package com.tweetapp.tweetservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.tweetservice.bean.PostResponse;
import com.tweetapp.tweetservice.bean.Reply;
import com.tweetapp.tweetservice.dao.PostDao;
import com.tweetapp.tweetservice.entity.Post;
import com.tweetapp.tweetservice.exception.UserException;
import com.tweetapp.tweetservice.util.LoggerConst;

/**
 * @author Sandeep
 *
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostDao postDao;


	@Override
	public List<Post> getAllTweet() throws UserException {
		LoggerConst.LOG.info("Get all tweet - Inside Service");
		return postDao.getAllTweet();
	}

	@Override
	public List<Post> getAllTweetByUserName(String userName) throws UserException {
		LoggerConst.LOG.info("Get all tweet by userName - Inside Service");
		return postDao.getAllTweetByUserName(userName);
	}

	@Override
	public PostResponse addTweet(String userName, Post post) throws UserException {
		LoggerConst.LOG.info("Add tweet - Inside Service");
		PostResponse res = new PostResponse();
		post.setCreatedAt();
		post.setUserName(userName);
		post.setLikes(0);
		if(null ==  postDao.addTweet(post)) {
			res.setStatus(false);
			res.setMessage("Failed to post Tweet");
			LoggerConst.LOG.info("Failed to Add tweet - Inside Service");
		}else {
			res.setMessage("Tweet posted Successfully");
			LoggerConst.LOG.info("Successfully Added tweet - Inside Service");
		}
		return res;
	}

	@Override
	public String deleteTweet(String id) throws UserException {
		LoggerConst.LOG.info("Deleting tweet - Inside Service");
		return postDao.deleteTweet(id);
	}

	@Override
	public PostResponse updateTweet(String id, Post post) throws UserException {
		LoggerConst.LOG.info("Update tweet - Inside Service");
		PostResponse res = new PostResponse();
		Post toSave = postDao.findById(id);
		toSave.setTweet(post.getTweet());
		toSave.setTags(post.getTags());
		if (null == postDao.updateTweet(toSave)) {
			res.setStatus(false);
			res.setMessage("Failed update Tweet");
			LoggerConst.LOG.info("Failed to update tweet - Inside Service");
		} else {
			res.setMessage("Tweet updated Successfully");
			LoggerConst.LOG.info("Success while updating tweet - Inside Service");
		}
		return res;
	}

	@Override
	public PostResponse likeTweet(String id) throws UserException {
		LoggerConst.LOG.info("Like a tweet - Inside Service");
		PostResponse res = new PostResponse();
		Post toSave = postDao.findById(id);
		toSave.setLikes(toSave.getLikes() + 1);
		if (null == postDao.updateLike(toSave)) {
			res.setStatus(false);
			res.setMessage("Failed update Like");
			LoggerConst.LOG.info("Failed to Like a tweet - Inside Service");
		} else {
			res.setMessage("Tweet Liked Successfully");
			LoggerConst.LOG.info("Success while Like a tweet - Inside Service");
		}
		return res;
	}

	@Override
	public PostResponse replyToTweet(String userName, String id, Reply reply) throws UserException {
		LoggerConst.LOG.info("Reply to tweet - Inside Service");
		PostResponse res = new PostResponse();
		Post toSave = postDao.findById(id);
		List<Reply> replyToSave = new ArrayList<Reply>();
		if (toSave.getReply() != null) {
			replyToSave = toSave.getReply();
		}
		reply.setCreatedAt();
		reply.setUserName(userName);
		replyToSave.add(reply);
		toSave.setReply(replyToSave);
		if (null == postDao.replyToTweet(toSave)) {
			res.setStatus(false);
			res.setMessage("Failed to save reply");
			LoggerConst.LOG.info("Failed while Reply to tweet - Inside Service");
		} else {
			res.setMessage("Reply saved Successfully");
			LoggerConst.LOG.info("Success while Reply to tweet - Inside Service");
		}
		return res;
	}
}