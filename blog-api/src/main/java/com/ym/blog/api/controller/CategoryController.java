package com.ym.blog.api.controller;

import com.ym.blog.api.service.CategoryService;
import com.ym.blog.api.vo.CategoryVo;
import com.ym.blog.api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/13 09:38
 * @Desc:
 */
@RestController
@RequestMapping("/categorys")
@Api(tags = "分类管理")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public Result listCategory(){
        List<CategoryVo> categoryVoList = categoryService.findAll();
        return Result.success(categoryVoList);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "列出所有分类")
    public Result findAllDetail(){
        List<CategoryVo> categoryVoList = categoryService.findAllDetail();
        return Result.success(categoryVoList);
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "根据id查询分类")
    public Result findCategoryDetailById(@PathVariable("id") Long id){
        CategoryVo categoryVo = categoryService.findCategoryDetailById(id);
        return Result.success(categoryVo);
    }
}
