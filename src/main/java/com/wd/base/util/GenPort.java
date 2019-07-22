package com.wd.util;

import com.wd.base.entity.Server;

public class GenPort {
    private static final int DEFULT_PORT = 1000;
    public static int getSum(Server server) {
        return server.getId() + DEFULT_PORT;
    }
}
