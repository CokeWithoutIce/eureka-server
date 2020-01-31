package com.kelebujiabing.userserver.mapper;

import com.kelebujiabing.userapi.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    int selectByPhone(String phone);
}