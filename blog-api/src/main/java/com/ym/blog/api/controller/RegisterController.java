package com.ym.blog.api.controller;

import com.ym.blog.api.service.LoginService;
import com.ym.blog.api.service.SysUserService;
import com.ym.blog.api.vo.Result;
import com.ym.blog.api.vo.params.LoginParams;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/30 19:24
 * @Desc:
 */
@RestController
@RequestMapping("/register")
@Api(tags = "用户注册")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginParams loginParams){
        return loginService.register(loginParams);
    }

}
