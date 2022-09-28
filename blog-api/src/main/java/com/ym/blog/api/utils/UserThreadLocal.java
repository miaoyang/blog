package com.ym.blog.api.utils;

import com.ym.blog.api.dao.pojo.SysUser;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/30 20:04
 * @Desc:
 */
public class UserThreadLocal {

    private UserThreadLocal(){

    }

    private static ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();

    public static SysUser get() {
        return LOCAL.get();
    }

    public static void set(SysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static void remove(){
        LOCAL.remove();
    }
}
