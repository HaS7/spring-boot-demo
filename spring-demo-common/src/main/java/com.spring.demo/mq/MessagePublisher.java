package com.spring.demo.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    //fanout 不需要routingKey 传 "" 或 null
    public void sendMessage(String exchange, String routingKey, MessageBody message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
