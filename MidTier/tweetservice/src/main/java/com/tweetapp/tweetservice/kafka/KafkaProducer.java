//package com.tweetapp.tweetservice.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import com.tweetapp.tweetservice.util.LoggerConst;
//
///**
// * @author Sandeep
// *
// */
//@Service
//public class KafkaProducer {
//
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//
//	public void pushService(String userName) {
//		LoggerConst.LOG.info("KafkaProducer :: pushService :: Start");
//		this.kafkaTemplate.send("TweetPosted", userName);
//		LoggerConst.LOG.info("KafkaProducer :: pushService :: End");
//	}
//}