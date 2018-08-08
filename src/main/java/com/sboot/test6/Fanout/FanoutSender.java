package com.sboot.test6.Fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "FanoutSender send: " + "我是来测试广播信息的~~";
        amqpTemplate.convertAndSend("fanoutExchange", "", context);
    }
}
