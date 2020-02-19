package com.strutnut.dao;

import com.strutnut.pojo.User;

import java.util.List;
import java.util.Map;

public interface IUserMapper {

    void addUser(Map<String,String> map);
    void updateUser(String uname);
    void deleteUser(long uid);
    User findUserByUname(String uame);
    List<User> findAllUsers();

}
