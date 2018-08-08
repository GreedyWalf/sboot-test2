package com.sboot.rabbitmq;

import com.sboot.test6.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试路由匹配队列形式，发送端指定队列发送，只有满足路由匹配上的队列可以接受到发送的信息
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicSender topicSender;

    @Test
    public void topic() throws Exception {
        topicSender.send();
    }

    @Test
    public void topic1() throws Exception {
        topicSender.send1();
    }

    @Test
    public void topic2() throws Exception {
        topicSender.send2();
    }

}
