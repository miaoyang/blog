package com.ym.blog.api.controller;

import com.ym.blog.api.service.SysUserService;
import com.ym.blog.api.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/30 11:53
 * @Desc:
 */
@RestController
@RequestMapping("/users")
@Api(tags = "账号信息")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/currentUser")
    public Result currentUser(@RequestHeader("Authorization")String token){
        return sysUserService.findUSerByToken(token);
    }
}
