package com.ym.blog.datasource.service;

import com.ym.blog.core.vo.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/18 18:53
 * @Desc:
 */
public interface IFileService {
    String upload(@RequestParam("image") MultipartFile file);
}
