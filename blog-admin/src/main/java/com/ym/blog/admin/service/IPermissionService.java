package com.ym.blog.admin.service;

import com.ym.blog.admin.dao.pojo.Permission;
import com.ym.blog.admin.vo.PageResult;
import com.ym.blog.admin.vo.params.PageParams;

public interface IPermissionService {
    PageResult<Permission> listPermission(PageParams params);

    void addPermission(Permission permission);

    void updatePermission(Permission permission);

    void deletePermission(Long id);
}
