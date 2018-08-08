package com.sboot.test6.object;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    @RabbitHandler
    public void process(UserObject userObject) {
        System.out.println("--->>>Receiver object : " + userObject);
    }

}
