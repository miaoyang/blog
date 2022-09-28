package com.ym.blog.admin.service;

import com.ym.blog.admin.dao.pojo.Admin;
import com.ym.blog.admin.dao.pojo.Permission;

import java.util.List;

public interface IAdminService {

    Admin findAdminByUserName(String userName);

    List<Permission> findAdminById(Long id);
}
