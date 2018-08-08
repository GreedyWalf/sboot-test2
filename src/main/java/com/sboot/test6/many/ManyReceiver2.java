package com.sboot.test6.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "many")
public class ManyReceiver2 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("receive2：" + message);
    }
}
