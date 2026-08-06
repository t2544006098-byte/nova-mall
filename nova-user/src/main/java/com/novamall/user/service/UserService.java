package com.novamall.user.service;

import com.novamall.common.Result;
import com.novamall.user.dto.LoginRequest;
import com.novamall.user.dto.RegisterRequest;
import com.novamall.user.entity.User;

public interface UserService {
    Result<User> register(RegisterRequest request);
    Result<String> login(LoginRequest request);
}
