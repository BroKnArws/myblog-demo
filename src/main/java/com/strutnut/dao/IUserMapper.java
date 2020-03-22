package com.strutnut.dao;

import com.strutnut.model.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    User getUserByEmail(String email);
}
