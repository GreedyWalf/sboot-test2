package com.sboot.test6.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String message = "this is hello queue send message " + new Date();
        System.out.println("-->>Sender:" + message);
        this.amqpTemplate.convertAndSend("hello", message);
    }
}
