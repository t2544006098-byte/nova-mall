package com.novamall.common;

public enum ResultEnum {
    SUCCESS(200, "success"),
    ERROR(500, "系统错误"),
    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "鉴权失败"),
    FORBIDDEN(403, "服务器拒绝"),
    NOT_FOUND(404, "路径不存在"),
    FAIL(500, "程序错误"),
    USER_EXISTS(1001, "用户已存在"),
    LOGIN_ERROR(1002, "用户名或密码错误"),
    USER_DISABLED(1003, "用户已被禁用");

    ResultEnum(int code, String message) {
    }
}
