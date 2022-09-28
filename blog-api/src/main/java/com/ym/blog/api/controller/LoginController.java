package com.ym.blog.api.controller;

import com.ym.blog.api.service.LoginService;
import com.ym.blog.api.vo.Result;
import com.ym.blog.api.vo.params.LoginParams;
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
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginParams loginParams){
        return loginService.login(loginParams);
    }

    @GetMapping("/logout")
    public Result logout(@RequestHeader("Authorization")String token){
        return loginService.logout(token);
    }
}
