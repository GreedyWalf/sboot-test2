package com.sboot.test6.object;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void sendObject(UserObject userObject) {
        System.out.println("-->>sendObject:" + userObject.toString());
        //第一个参数是定义的queue名称，第二个参数是传递的对象
        amqpTemplate.convertAndSend("object", userObject);
    }
}
