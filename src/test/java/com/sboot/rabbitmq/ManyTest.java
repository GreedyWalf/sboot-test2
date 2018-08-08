package com.sboot.rabbitmq;

import com.sboot.test6.many.ManySender;
import com.sboot.test6.many.ManySender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 无论是一个发送端多个接收端还是多个发送端多个接收端，发送的信息都能够被接收一次，不会出现接收重复的现象；
 *
 * 一个发送者，N个接受者,经过测试会均匀的将消息发送到N个接收者中；
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
    @Autowired
    private ManySender manySender;

    @Autowired
    private ManySender2 manySender2;

    /**
     * 一端发送，两个接受端接收
     * @throws Exception
     */
    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            manySender.send(i);
        }
    }

    /**
     * 两端发送，两个接收端接收
     * @throws Exception
     */
    @Test
    public void manyToMany() throws Exception {
        for (int i=0;i<100;i++){
            manySender.send(i);
            manySender2.send(i);
        }
    }
}
