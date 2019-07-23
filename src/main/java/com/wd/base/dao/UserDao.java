package com.wd.base.dao;

import com.wd.base.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    User getUser(@Param("user") User user);
    List<User> getAllUser();
    void add(@Param("user") User user);
    void update(@Param("user") User user);
    void delete(@Param("user") User user);
}
