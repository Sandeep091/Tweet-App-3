//package com.tweetapp.tweetservice.dao;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
//import com.amazonaws.services.dynamodbv2.model.AttributeValue;
//import com.tweetapp.tweetservice.entity.User;
//import com.tweetapp.tweetservice.exception.UserException;
//import com.tweetapp.tweetservice.util.LoggerConst;
//
///**
// * @author Sandeep
// *
// */
//
//@Component
//public class UserDaoImpl implements UserDao {
//
////	@Autowired
////	UserRepository userRepository;
////	@Autowired
////	MongoTemplate template;
//	@Autowired
//	DynamoDBMapper mapper;
//
//	@Override
//	public List<User> getAllUsers() throws UserException {
//		LoggerConst.LOG.info("getAllUsers  - Inside Repository");
//		return mapper.scan(User.class, new DynamoDBScanExpression());
//	}
//
//	@Override
//	public String registerUser(User user) throws UserException {
//		LoggerConst.LOG.info("registerUser  - Inside Repository");
//		mapper.save(user);
//		return " User Successfully Registered with UserName : " + user.getUserName();
//	}
//
//	@Override
//	public User getUserByUsername(String userName) throws UserException {
//		LoggerConst.LOG.info("getUserByUsername  - Inside Repository");
//		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
//		eav.put(":v1", new AttributeValue().withS(userName));
//		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("userName = :v1")
//				.withExpressionAttributeValues(eav);
//		return mapper.scan(User.class, scanExpression).stream().filter(data -> userName.equals(data.getUserName()))
//				.findAny().orElse(null);
//	}
//
//	@Override
//	public User getUserByEmail(String email) throws UserException {
//		LoggerConst.LOG.info("getUserByEmail  - Inside Repository");
//		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
//		eav.put(":v1", new AttributeValue().withS(email));
//		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("email = :v1")
//				.withExpressionAttributeValues(eav);
//		return mapper.scan(User.class, scanExpression).stream().filter(data -> email.equals(data.getEmail()))
//				.findAny().orElse(null);
//	}
//
//	@Override
//	public String changePassword(User user) throws UserException {
//		LoggerConst.LOG.info("changePassword  - Inside Repository");
//		mapper.save(user);
//		return "Password updated Successfully";
//	}
//}
