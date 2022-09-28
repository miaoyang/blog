package com.ym.blog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ym.blog.admin.dao.mapper.AdminMapper;
import com.ym.blog.admin.dao.mapper.PermissionMapper;
import com.ym.blog.admin.dao.pojo.Admin;
import com.ym.blog.admin.dao.pojo.Permission;
import com.ym.blog.admin.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/15 10:08
 * @Desc:
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Admin findAdminByUserName(String userName) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,userName);
        queryWrapper.last("limit 1");
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }

    @Override
    public List<Permission> findAdminById(Long id) {
        return permissionMapper.findPermissionsByAdminId(id);
    }
}
