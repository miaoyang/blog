package com.ym.blog.api.controller;

import com.ym.blog.api.dao.pojo.Tag;
import com.ym.blog.api.service.TagService;
import com.ym.blog.api.vo.Result;

import com.ym.blog.api.vo.TagVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.Temporal;
import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/28 22:40
 * @Desc:
 */
@RestController
@RequestMapping("/tags")
@Api(tags = "类别管理")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/hot")
    public Result listHotTags(){
        int limit = 6;
        List<Tag> tagVoList =  tagService.listHotTags(limit);

        return Result.success(tagVoList);
    }

    @GetMapping("/detail")
    public Result findAll(){
        List<TagVo> tagVoList = tagService.findAll();
        return Result.success(tagVoList);
    }

    @GetMapping("/detail/{id}")
    public Result findTagDetailById(@PathVariable("id") Long id){
        TagVo tagVo = tagService.findTagDetailById(id);
        return Result.success(tagVo);
    }
}
