package com.sboot.test7;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

    private int i = 0;

    /**
     * 定时每隔6s，执行
     */
    @Scheduled(cron = "*/6 * * * * ?")
    public void processTask() {
        System.out.println("processTask running: " + (i++));
    }
}
