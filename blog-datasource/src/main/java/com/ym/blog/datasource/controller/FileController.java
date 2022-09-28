package com.ym.blog.datasource.controller;

import com.ym.blog.core.vo.Result;
import com.ym.blog.datasource.config.MinioConfig;
import com.ym.blog.datasource.pojo.MinioProp;
import com.ym.blog.datasource.service.IFileService;
import com.ym.blog.datasource.utils.FileUploadUtils;
import com.ym.blog.datasource.utils.MinioUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/18 10:54
 * @Desc:
 */
@RestController
public class FileController {

    @Value("minio.enable")
    private boolean isOpenMinio;

    @Autowired
    private IFileService fileService;

    @PostMapping("/uploads")
    public Result upload(@RequestParam("image") MultipartFile file) throws Exception {
        String fileUrl = fileService.upload(file);
        return Result.success(fileUrl);
    }
}