package com.novamall.user.service.impl;

import com.novamall.common.Result;
//import com.novamall.common.ResultCode;
import com.novamall.common.ResultCode;
import com.novamall.common.ResultEnum;
import com.novamall.user.dto.LoginRequest;
import com.novamall.user.dto.RegisterRequest;
import com.novamall.user.entity.User;
import com.novamall.user.mapper.UserMapper;
import com.novamall.user.service.UserService;
import com.novamall.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    public static Integer YES = 1;
    public static Integer NO = 0;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public Result<Long> register(RegisterRequest request) {
        User exist = userMapper.findByUsername(request.getUsername());
        if (exist != null) {
            return Result.fail(ResultEnum.USER_EXISTS.toString());
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setNickname(request.getNickname());
        user.setStatus(YES);
        user.setPhone(request.getPhone());
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
        return Result.success(user.getId());
    }

    @Override
    public Result<String> login(LoginRequest request) {
        User user = userMapper.findByUsername(request.getUsername());
        String md5Password = DigestUtils.md5DigestAsHex(request.getPassword().getBytes());
        if (user == null){
            return Result.fail(ResultEnum.LOGIN_ERROR.toString());
        }
        if (!user.getPassword().equals(request.getPassword())){
            return Result.fail(ResultEnum.LOGIN_ERROR.toString());
        }
        if (!user.getStatus().equals(YES)){
            return Result.fail(ResultEnum.USER_DISABLED.toString());
        }
        String token = jwtUtil.generateToken(request.getUsername());
        return Result.success(token);
    }
}
