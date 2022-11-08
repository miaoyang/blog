package com.ym.blog.admin.controller;

import com.ym.blog.admin.dao.pojo.Permission;
import com.ym.blog.admin.service.IPermissionService;
import com.ym.blog.admin.vo.PageResult;
import com.ym.blog.admin.vo.params.PageParams;
import com.ym.blog.core.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/15 10:04
 * @Desc:
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "权限管理")
public class AdminController {

    @Autowired
    private IPermissionService permissionService;

    @PostMapping("/permission/permissionList")
    @ApiOperation(value = "权限列表")
    public Result listPermission(@RequestBody PageParams params){
        PageResult<Permission> pageResult = permissionService.listPermission(params);
        return Result.success(pageResult);
    }

    @PostMapping("/permission/add")
    @ApiOperation(value = "添加权限")
    public Result add(@RequestBody Permission permission){
        permissionService.addPermission(permission);
        return Result.success();
    }

    @PostMapping("/permission/update")
    @ApiOperation(value = "更新权限")
    public Result update(@RequestBody Permission permission){
       permissionService.updatePermission(permission);
       return Result.success();
    }

    @GetMapping("/permission/delete/{id}")
    @ApiOperation(value = "删除某个权限")
    public Result delete(@PathVariable("id") Long id){
        permissionService.deletePermission(id);
        return Result.success();
    }


}
