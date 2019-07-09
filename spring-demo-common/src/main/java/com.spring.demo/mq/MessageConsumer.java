package com.spring.demo.mq;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.spring.demo.mq.RabbitMqUtils.DIRECT_EXCHANGE;
import static com.spring.demo.mq.RabbitMqUtils.DURABLE_QUEUE;
import static com.spring.demo.mq.RabbitMqUtils.DirectRoutingKey;
import static com.spring.demo.mq.RabbitMqUtils.NOT_DURABLE_QUEUE;

@Service
public class MessageConsumer {

    //没有binding 用 bindings ,还是无差别消费消息 #有消息自动消费
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = DURABLE_QUEUE, durable = "true"),
        exchange = @Exchange(value = DIRECT_EXCHANGE, durable = "true"), key = DirectRoutingKey)})
    public void receive(MessageBody message) {
        System.out.println("消费消息：" + JSONObject.toJSONString(message));
    }

    @RabbitListener(queues = NOT_DURABLE_QUEUE)
    public void receive(Message message) {
        System.out.println("消费消息MessageProperties：" + JSONObject.toJSONString(message.getMessageProperties()) + "\n" +
            "消费消息body：" + JSONObject.toJSONString(new String(message.getBody())));

    }
}
