package com.strutnut.dao;

import com.strutnut.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    User getUserByEmail(String email);
}
