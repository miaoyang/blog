package com.ym.blog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.blog.admin.dao.mapper.PermissionMapper;
import com.ym.blog.admin.dao.pojo.Permission;
import com.ym.blog.admin.service.IPermissionService;
import com.ym.blog.admin.vo.PageResult;
import com.ym.blog.admin.vo.params.PageParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/15 10:10
 * @Desc:
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public PageResult<Permission> listPermission(PageParams params) {
        Page<Permission> page = new Page<>(params.getCurrentPage(), params.getPageSize());
        LambdaQueryWrapper<Permission> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNoneEmpty(params.getQueryString())) {
            queryWrapper.eq(Permission::getName, params.getQueryString());
        }
        Page<Permission> permissionPage = permissionMapper.selectPage(page, queryWrapper);
        PageResult<Permission> pageResult = new PageResult<>();
        pageResult.setList(permissionPage.getRecords());
        pageResult.setTotal(pageResult.getTotal());
        return pageResult;
    }

    @Override
    public void addPermission(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.update(permission,new LambdaQueryWrapper<>());
    }

    @Override
    public void deletePermission(Long id) {
        permissionMapper.deleteById(id);
    }


}
