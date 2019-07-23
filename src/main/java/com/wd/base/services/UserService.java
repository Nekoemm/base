package com.wd.base.services;

import com.wd.base.entity.User;

import java.util.List;

public interface UserService {
    public User getUser(User user);
    public List<User> getAllUser();
    public void add(User user);
    public void update(User user);
    public void delete(User user);
    public boolean LoginCheck(User user);
}
