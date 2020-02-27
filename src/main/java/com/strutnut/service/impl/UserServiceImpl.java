package com.strutnut.service.impl;


import com.strutnut.dao.IUserMapper;
import com.strutnut.bean.User;
import com.strutnut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserService")
public class UserServiceImpl implements IUserService {

    private final IUserMapper userMapper;

    @Autowired
    public UserServiceImpl(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);

    }
}
