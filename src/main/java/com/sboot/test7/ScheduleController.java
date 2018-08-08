package com.sboot.test7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleTask2 scheduleTask2;

    @RequestMapping(value = "/showDate")
    public String showDate() {
        return "";
    }
}
