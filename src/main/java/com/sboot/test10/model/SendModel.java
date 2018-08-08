package com.sboot.test10.model;

import java.io.Serializable;

public class SendModel extends CommonModel {

    private String message = "12345";
    private String sendType;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }
}
