//package com.tweetapp.tweetservice.dao;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
//import com.amazonaws.services.dynamodbv2.model.AttributeValue;
//import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
//import com.tweetapp.tweetservice.entity.Post;
//import com.tweetapp.tweetservice.exception.UserException;
//import com.tweetapp.tweetservice.util.LoggerConst;
//
///**
// * @author Sandeep
// *
// */
//@Component
//public class PostDaoImpl implements PostDao {
//
//	@Autowired
//	DynamoDBMapper mapper;
//
//	@Override
//	public Post addTweet(Post post) throws UserException {
//		LoggerConst.LOG.info("Add Tweet  - Inside Repository");
//		mapper.save(post);
//		return post;
//	}
//
//	@Override
//	public List<Post> getAllTweet() throws UserException {
//		LoggerConst.LOG.info("Get all tweet  - Inside Repository");
//		return mapper.scan(Post.class, new DynamoDBScanExpression());
//	}
//
//	@Override
//	public List<Post> getAllTweetByUserName(String UserName) throws UserException {
//		LoggerConst.LOG.info("Get all tweet by user name - Inside Repository");
//		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
//		eav.put(":v1", new AttributeValue().withS(UserName));
//		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
//				.withFilterExpression("userName=:v1")
//				.withExpressionAttributeValues(eav);
//		return mapper.scan(Post.class, scanExpression);
//	}
//
//	@Override
//	public Post updateTweet(Post post) throws UserException {
//		LoggerConst.LOG.info("update Tweet  - Inside Repository");
//		mapper.save(post, new DynamoDBSaveExpression().withExpectedEntry("id",
//				new ExpectedAttributeValue(new AttributeValue().withS(post.getId()))));
//		return post;
//	}
//
//	@Override
//	public String deleteTweet(String id) throws UserException {
//		LoggerConst.LOG.info("Delete tweet  - Inside Repository");
//		Post post = mapper.load(Post.class,id);
//		mapper.delete(post);
//		return "Tweet deleted Successfully";
//	}
//
//	@Override
//	public Post updateLike(Post post) throws UserException {
//		LoggerConst.LOG.info("Update Like  - Inside Repository");
//		mapper.save(post, new DynamoDBSaveExpression().withExpectedEntry("id",
//				new ExpectedAttributeValue(new AttributeValue().withS(post.getId()))));
//		return post;
//	}
//
//	@Override
//	public Post findById(String id) throws UserException {
//		LoggerConst.LOG.info("Find by id  - Inside Repository");
//		return mapper.load(Post.class,id);
//	}
//
//	@Override
//	public Post replyToTweet(Post post) throws UserException {
//		LoggerConst.LOG.info("Invalid userName  - Inside Repository");
//		mapper.save(post, new DynamoDBSaveExpression().withExpectedEntry("id",
//				new ExpectedAttributeValue(new AttributeValue().withS(post.getId()))));
//		return post;
//	}
//
//}