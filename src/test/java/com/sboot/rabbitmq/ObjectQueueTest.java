package com.sboot.rabbitmq;

import com.sboot.test6.object.ObjectSender;
import com.sboot.test6.object.UserObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试使用rabbitMQ发送和接受对象
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectQueueTest {

    @Autowired
    private ObjectSender objectSender;

    @Test
    public void testObjectSend(){
        UserObject userObject = new UserObject();
        userObject.setAge(25);
        userObject.setUserName("zhangsan");
        objectSender.sendObject(userObject);
    }
}
