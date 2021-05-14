//package com.tweetapp.tweetservice.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.tweetapp.tweetservice.dao.UserDao;
//import com.tweetapp.tweetservice.util.LoggerConst;
//
///**
// * @author Sandeep
// *
// */
//@Service
//public class KafkaConsumer {
//	
//
//		@Autowired
//		private  UserDao userDao;
//
//		@KafkaListener(topics = "TweetPosted", groupId = "tweetkafka")
//		public void consumeService(String notification) {
//			LoggerConst.LOG.info("Kafka-Consumer :: Active User");
//			userDao.pushNotifications(notification);
//		}
//}