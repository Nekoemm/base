package com.wd.base.entity;

import java.util.Map;

public class Server {
    private int id;
    private String name;
    private int port;
    private Map<Integer, Client> clientMap;
}
