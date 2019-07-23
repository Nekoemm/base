package com.wd.base.entity;

public class TransDto {
    public static final int ERROR = 0;
    public static final int SUCCESS = 1;
    private int status;
    private String msg;
    private Object transObject;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getTransObject() {
        return transObject;
    }

    public void setTransObject(Object transObject) {
        this.transObject = transObject;
    }
}
