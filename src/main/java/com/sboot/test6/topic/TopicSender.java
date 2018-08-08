package com.sboot.test6.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String content = "我发送的队列是topic.1，只有配置了topic.#匹配的队列topic.messages能接收到我~~";
        System.out.println("--->>sender : " + content);
        //第一个参数为TopicRabbitConfig配置中定义的Exchange，第二个参数为路由匹配上的queue名称，第三个参数为发送的内容
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", content);
    }

    public void send1() {
        String content = "我发送的队列是topic.message，可以由配置topic.message和topic.#队列接收端都可以接收我~~";
        System.out.println("sender1 : " + content);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", content);
    }

    public void send2() {
        String content = "我发送的队列是topic.messages，只有topic.#队列接收端都可以接收我~~";
        System.out.println("-->>sender2 : " + content);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", content);
    }

}
