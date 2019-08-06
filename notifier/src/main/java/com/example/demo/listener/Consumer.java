package com.example.demo.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import com.example.demo.entity.UserEntity;

import java.util.List;
import java.util.Map;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(name="notification",durable = "false"),
                exchange = @Exchange("solution-exchange"),
                key = "user.creation.successful"
        )
//        queuesToDeclare = @Queue("myQueue"), bindings={}, queues = {"notification"}
        )
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @RabbitHandler
    public void receiveMessage(String message
//            Map<String, List<UserEntity>> users
    )
    {
        LOGGER.info(" receive message [" + message + "] ");
    }
}
