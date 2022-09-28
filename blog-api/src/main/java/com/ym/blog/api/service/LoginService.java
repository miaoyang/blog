package com.ym.blog.api.service;

import com.ym.blog.api.dao.pojo.SysUser;
import com.ym.blog.api.vo.Result;
import com.ym.blog.api.vo.params.LoginParams;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/29 21:36
 * @Desc:
 */
public interface LoginService {
    Result login(LoginParams loginParams);

    Result logout(String token);

    Result register(LoginParams loginParams);

    SysUser checkToken(String token);
}
