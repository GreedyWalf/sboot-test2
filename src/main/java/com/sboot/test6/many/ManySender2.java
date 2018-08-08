package com.sboot.test6.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManySender2 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i) {
        String content = "springBoot many queue" + " ***** " + i;
        System.out.println("send2：" + content);
        amqpTemplate.convertAndSend("many", content);
    }
}
