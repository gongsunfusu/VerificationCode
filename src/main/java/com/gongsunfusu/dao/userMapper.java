package com.gongsunfusu.dao;

import com.gongsunfusu.pojo.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userMapper {
    //新建用户
    void insertUser(user user);
    //通过用户名查询用户
    user selectUser(user user);
    //查询所有用户
    List<user> selectUserList();
}