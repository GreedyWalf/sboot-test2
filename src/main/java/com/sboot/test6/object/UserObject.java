package com.sboot.test6.object;

import java.io.Serializable;

/**
 * rabbitMQ传递的对象，需要时间Serializable接口
 */
public class UserObject implements Serializable {
    private String userName;
    private int age;

    public UserObject(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public UserObject() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
