package com.novamall.user.mapper;

import com.novamall.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(User user);
    User findByUsername(String username);
}
