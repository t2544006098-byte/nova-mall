package com.novamall.common;

import lombok.Getter;

@Getter
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
    USER_DISABLED(1003, "用户已被禁用"),
    PRODUCT_NOT_FOUND(2001, "商品不存在"),
    PRODUCT_IS_EXIST(2002, "商品已存在");

    private Integer code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
