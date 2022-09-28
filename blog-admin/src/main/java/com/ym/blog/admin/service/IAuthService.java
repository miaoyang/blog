package com.ym.blog.admin.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/15 21:03
 * @Desc:
 */
public interface IAuthService {

    boolean auth(HttpServletRequest request, Authentication authentication);
}
