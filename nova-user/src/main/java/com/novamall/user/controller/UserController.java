package com.novamall.user.controller;


import com.novamall.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/test")
    public Result<String> test(){
        return Result.success("nova-user启动成功！");
    }
}
