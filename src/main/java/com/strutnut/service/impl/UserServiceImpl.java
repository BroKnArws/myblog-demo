package com.strutnut.service.impl;

import com.strutnut.dao.IUserMapper;
import com.strutnut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;


    @Override
    public void addUser(Map<String, String> userMap) {
        userMapper.addUser(userMap);
    }
}
