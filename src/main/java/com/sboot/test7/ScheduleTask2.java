package com.sboot.test7;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 配置定时任务
 *  1、需要在Application.java启动项目类中使用@EnableScheduling注解；
 *  2、在定时任务（方法）上使用@Scheduled注解，定义好定时执行的时间；
 *
 *  @Scheduled(fixedRate=6000) 表示在上次开始执行时间点之后6s，再执行
 *  @Scheduled(fixedDelay=6000) 表示在上次开始执行完毕时间点之后6s，在执行
 *  @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行
 */
@Component
public class ScheduleTask2 {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 定时每隔6s打印出当前时间
     */
    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        String currentTime = "现在时间：" + dateFormat.format(new Date());
        System.out.println(currentTime);
    }
}
