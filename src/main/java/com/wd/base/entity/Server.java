package com.wd.base.entity;

import java.util.Map;

public class Server {
    private int id;
    private String name;
    private int port;
    private Map<Integer, User> clientMap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Map<Integer, User> getClientMap() {
        return clientMap;
    }

    public void setClientMap(Map<Integer, User> clientMap) {
        this.clientMap = clientMap;
    }
}
