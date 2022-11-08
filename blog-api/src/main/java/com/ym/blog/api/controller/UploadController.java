package com.ym.blog.api.controller;

import com.ym.blog.api.utils.QiniuUtils;
import com.ym.blog.api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/13 21:30
 * @Desc:
 */
@RestController
@RequestMapping("/uploads")
@Api(tags = "用户上传")
public class UploadController {

    @Autowired
    private QiniuUtils qiniuUtils;

    @PostMapping
    @ApiOperation(value = "上传文件")
    public Result upload(@RequestParam("image") MultipartFile file){
        String fileName = UUID.randomUUID() + "."+ StringUtils.substringAfterLast(file.getOriginalFilename(),".");
        boolean isUpload = qiniuUtils.upload(file, fileName);
        if (isUpload){
            return Result.success(QiniuUtils.url + fileName);
        }
        return Result.fail(20001,"上传失败");
    }
}
