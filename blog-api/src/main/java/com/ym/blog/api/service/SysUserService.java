package com.ym.blog.api.service;

import com.ym.blog.api.dao.pojo.SysUser;
import com.ym.blog.api.vo.Result;
import com.ym.blog.api.vo.UserVo;

public interface SysUserService {
    SysUser findUserById(Long authorId);

    UserVo findUserVoById(Long authorId);

    SysUser findUser(String account, String pwd);

    Result findUSerByToken(String token);

    SysUser findUserByAccount(String account);

    void save(SysUser sysUser);
}
