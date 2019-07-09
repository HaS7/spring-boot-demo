package com.spring.demo;

import com.spring.demo.mq.MessageBody;
import com.spring.demo.mq.MessagePublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.awt.print.Book;

import static com.spring.demo.mq.RabbitMqUtils.FANOUT_EXCHANGE;
import static com.spring.demo.mq.RabbitMqUtils.TOPIC_EXCHANGE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Resource private MessagePublisher messagePublisher;
    @Test
    public void testSendFanoutMessage(){
        messagePublisher.sendMessage(FANOUT_EXCHANGE,"",MessageBody.builder().messageContent("撒浪嘿").messageId(12979274123L).messageReceiver("小婷").messageSender("小贝").build());
    }

    @Test
    public void testSendTopicMessage(){
        messagePublisher.sendMessage(TOPIC_EXCHANGE,"demo.topic.xxx",MessageBody.builder().messageContent("撒浪嘿").messageId(12979274123L).messageReceiver("小婷").messageSender("小贝").build());

    }
}
