package com.sboot.test6.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 只能接受queue为topic.message队列发送过来的信息
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver1  : " + message);
    }
}
