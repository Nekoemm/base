package com.wd.base.services.Impl;

import com.wd.base.dao.UserDao;
import com.wd.base.entity.User;
import com.wd.base.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    public boolean LoginCheck(User user){
        return (user.getName() == null ||  user.getPassword() == null ||userDao.getUser(user) == null)?false : true;
    }
}
