package com.sboot.rabbitmq;

import com.sboot.test6.Fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试RabbitMQ支持的广播传递信息，通过配置广播信息的队列，一个发送端发送信息，多个队列都可以接受到；
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void testFanout(){
        fanoutSender.send();
    }
}
