package com.ym.blog.admin.controller;

import com.ym.blog.admin.dao.pojo.Permission;
import com.ym.blog.admin.service.IPermissionService;
import com.ym.blog.admin.vo.PageResult;
import com.ym.blog.admin.vo.params.PageParams;
import com.ym.blog.core.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/15 10:04
 * @Desc:
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IPermissionService permissionService;

    @PostMapping("/permission/permissionList")
    public Result listPermission(@RequestBody PageParams params){
        PageResult<Permission> pageResult = permissionService.listPermission(params);
        return Result.success(pageResult);
    }

    @PostMapping("/permission/add")
    public Result add(@RequestBody Permission permission){
        permissionService.addPermission(permission);
        return Result.success();
    }

    @PostMapping("/permission/update")
    public Result update(@RequestBody Permission permission){
       permissionService.updatePermission(permission);
       return Result.success();
    }

    @GetMapping("/permission/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        permissionService.deletePermission(id);
        return Result.success();
    }


}
