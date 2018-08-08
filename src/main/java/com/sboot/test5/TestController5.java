package com.sboot.test5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController5 {

    @Autowired
    private CourseServiceImpl courseService;

    @RequestMapping(value = "/testTransaction")
    public String testTransaction(){
        courseService.transfer();
        return "test success";
    }
}
