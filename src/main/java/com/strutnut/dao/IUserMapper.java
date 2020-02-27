package com.strutnut.dao;

import com.strutnut.bean.User;

public interface IUserMapper {
    User getUserByEmail(String email);

}
