package com.ym.blog.admin.service.impl;

import com.ym.blog.admin.dao.pojo.Admin;
import com.ym.blog.admin.dao.pojo.Permission;
import com.ym.blog.admin.service.IAdminService;
import com.ym.blog.admin.service.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/16 09:29
 * @Desc:
 */
@Service
@Slf4j
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IAdminService adminService;

    @Override
    public boolean auth(HttpServletRequest request, Authentication authentication) {

        String requestURI = request.getRequestURI();
        log.info("requestURI uri:{}",requestURI);
        Object principal = authentication.getPrincipal();
        if (principal == null || "anonymousUser".equals(principal)){
            return false;
        }
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();
        if (StringUtils.isEmpty(username)){
            return false;
        }
        Admin admin = adminService.findAdminByUserName(username);
        log.info("admin {}",admin);
        if (admin == null){
            return false;
        }
        if (admin.getId() == 1){
            log.info("admin account，admin:{}",admin.toString());
            return true;
        }
        List<Permission> permissionList = adminService.findAdminById(admin.getId());
        requestURI = StringUtils.split(requestURI,'?')[0];
        for (Permission permission : permissionList){
            if (requestURI.equals(permission.getPath())){
                log.info("auth success, requestUri:{}",requestURI);
                return true;
            }
        }
        return false;
    }
}
