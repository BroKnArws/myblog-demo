package com.strutnut.service.impl;


import com.strutnut.dao.IUserMapper;
import com.strutnut.model.pojo.User;
import com.strutnut.service.IUserService;

import com.strutnut.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserService")
public class UserServiceImpl implements IUserService {

    private final IUserMapper userMapper;
    private final TokenUtils tokenUtils;


    @Autowired
    public UserServiceImpl(IUserMapper userMapper, TokenUtils tokenUtils) {
        this.userMapper = userMapper;
        this.tokenUtils = tokenUtils;
    }


    @Override
    public String login(User user) {
        User dbUser = this.getUserByEmail(user.getEmail());
        if (dbUser == null || !dbUser.getPassword().equals(user.getPassword())) {
            System.out.println("用户不存在");
            return null;
        }
        String token = tokenUtils.generateToken(user);
        return token;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userMapper.getUserByEmail(email);
        System.out.println(user.toString());
        return user;
    }

}
