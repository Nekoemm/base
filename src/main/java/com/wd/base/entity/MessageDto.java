package com.wd.base.entity;

public class MessageDto {
    //消息发送人
    private String name;
    //消息内容
    private String message;
    //消息发送时间
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
