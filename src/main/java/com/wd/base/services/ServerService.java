package com.wd.base.services;

import com.wd.base.entity.Server;

public interface ServerService {
    Server startService();
    void shutDown(Server server);
}
