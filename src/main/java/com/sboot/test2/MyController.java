package com.sboot.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试内容：
 *  1、通过@Value("${属性名}")读取application.yml配置的自定义属性名；
 *  2、将application.yml中自定义属性配置到javaBean中；
 */
@RestController
public class MyController {
    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private int age;

    @RequestMapping(value = "/my")
    public String my() {
        return name + ":" + age;
    }

    @Autowired
    private UserEntity userEntity;

    @RequestMapping(value = "/myEntity")
    public String myEntity(){
        return userEntity.getName() + ":" + userEntity.getAge();
    }


    @Autowired
    private User user;

    @RequestMapping(value = "/myUser")
    public String myUser(){
        return user.getUserName() + ":" + user.getAge();
    }
}
