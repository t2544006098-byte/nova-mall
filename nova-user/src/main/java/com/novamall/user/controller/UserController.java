package com.novamall.user.controller;


import com.novamall.common.Result;
import com.novamall.user.dto.LoginRequest;
import com.novamall.user.dto.RegisterRequest;
import com.novamall.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public Result<String> test(){
        return Result.success("nova-user启动成功！");
    }

    @RequestMapping("/register")
    public Result<Long> register(@Valid @RequestBody RegisterRequest request){
        return  userService.register(request);
    }

    @RequestMapping("/login")
    public Result<String> login(@Valid @RequestBody LoginRequest request){
        return userService.login(request);
    }
}
