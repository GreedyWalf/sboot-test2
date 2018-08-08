package com.sboot.test10.controller;

import com.sboot.test10.model.SendModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    @RequestMapping(value = "/testAop")
    public void testAop(SendModel model){
        System.out.println("----->>testAop");
        System.out.println(model.getMessage());
        System.out.println(model.getCreateTime());
    }
}
