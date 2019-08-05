//package com.example.solution.amqp.receiver;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CountDownLatch;
//import org.springframework.stereotype.Component;
//
//import com.example.solution.entity.UserEntity;
//
//@Component
//public class Receiver {
//
//    private CountDownLatch latch = new CountDownLatch(1);
//
//    public void receiveMessage(Map<String,List<UserEntity>> message) {
//        System.out.println("Received <" + message + ">");
//        latch.countDown();
//    }
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//
//}