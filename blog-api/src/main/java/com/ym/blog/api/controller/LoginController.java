package com.ym.blog.api.controller;

import com.ym.blog.api.service.LoginService;
import com.ym.blog.api.vo.Result;
import com.ym.blog.api.vo.params.LoginParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/29 21:36
 * @Desc:
 */
@RestController
@RequestMapping
@Api(tags = "账号相关")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result login(@RequestBody LoginParams loginParams){
        return loginService.login(loginParams);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "用户登出")
    public Result logout(@RequestHeader("Authorization")String token){
        return loginService.logout(token);
    }
}
