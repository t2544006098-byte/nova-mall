package com.novamall.user.service;

import com.novamall.common.Result;
import com.novamall.user.dto.LoginRequest;
import com.novamall.user.dto.RegisterRequest;

public interface UserService {
    Result<Long> register(RegisterRequest request);
    Result<String> login(LoginRequest request);
}
