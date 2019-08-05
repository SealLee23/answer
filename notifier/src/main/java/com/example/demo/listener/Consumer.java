package com.example.demo.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.demo.entity.UserEntity;

import java.util.List;
import java.util.Map;

@Component
@RabbitListener(queues = {"notification"})
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @RabbitHandler
    public void receiveMessage(Map<String, List<UserEntity>> users)
    {
        LOGGER.info(" receive message [" + users.toString() + "] ");
    }
}