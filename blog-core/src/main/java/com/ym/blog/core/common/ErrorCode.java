package com.ym.blog.core.common;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/29 21:42
 * @Desc:
 */
public enum ErrorCode {

    PARAMS_ERROR(10001,"参数有误"),
    ACCOUNT_PWD_NOT_EXIST(10002,"用户名或密码不存在"),
    NO_PERMISSION(70001,"无访问权限"),
    SESSION_TIME_OUT(90001,"会话超时"),
    NO_LOGIN(90002,"未登录"),
    ACCOUNT_EXIST(10004,"账号已存在");

    ErrorCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
