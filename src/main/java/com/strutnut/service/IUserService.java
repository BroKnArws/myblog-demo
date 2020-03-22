package com.strutnut.service;


import com.strutnut.model.pojo.User;


public interface IUserService {

    User getUserByEmail(String email);

    String login(User user);

}
