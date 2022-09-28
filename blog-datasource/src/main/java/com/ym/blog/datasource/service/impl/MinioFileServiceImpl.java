package com.ym.blog.datasource.service.impl;

import com.ym.blog.core.vo.Result;
import com.ym.blog.datasource.config.MinioConfig;
import com.ym.blog.datasource.pojo.MinioProp;
import com.ym.blog.datasource.service.IFileService;
import com.ym.blog.datasource.utils.FileUploadUtils;
import com.ym.blog.datasource.utils.MinioUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/18 18:54
 * @Desc: MinioService上传
 */
public class MinioFileServiceImpl implements IFileService {

    private static final Logger log = LoggerFactory.getLogger(MinioFileServiceImpl.class);

    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioProp minioProp;

    @Autowired
    private MinioUtil minioUtil;

    @Override
    public String upload(MultipartFile file) {
        String fileName = FileUploadUtils.extractFilename(file);
        try {
            minioUtil.putObject(null, fileName, file.getInputStream(), file.getSize(), file.getContentType());
            String url = minioProp.getEndpoint() + "/" + minioProp.getBucketName() + "/" + fileName;
            return url;
        }catch (Exception e){
            log.error("上传文件失败！error msg:{}",e);
            return "";
        }
    }
}
