package com.sboot.test12.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    private String userId;
    private String userName;
    private int age;


    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
