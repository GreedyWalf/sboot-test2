package com.sboot.schedule;

import com.sboot.test7.ScheduleTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSchedule {
    @Autowired
    private ScheduleTask scheduleTask;


    @Test
    public void testSchedule(){
        scheduleTask.processTask();
    }
}
