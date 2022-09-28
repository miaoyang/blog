package com.ym.blog.datasource.service.impl;

import com.ym.blog.core.vo.Result;
import com.ym.blog.datasource.service.IFileService;
import com.ym.blog.datasource.utils.FileUploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/18 18:54
 * @Desc: 本地文件上传service
 */
public class LocalFileServiceImpl implements IFileService {

    private static final Logger log = LoggerFactory.getLogger(LocalFileServiceImpl.class);

    /**
     * 资源映射路径 前缀
     */
    @Value("${file.prefix}")
    public String localFilePrefix;

    /**
     * 域名或本机访问地址
     */
    @Value("${file.domain}")
    public String domain;

    /**
     * 上传文件存储在本地的根路径
     */
    @Value("${file.path}")
    private String localFilePath;

    @Override
    public String upload(MultipartFile file) {
        try {
            String name = FileUploadUtils.upload(localFilePath, file);
            String url = domain + localFilePrefix + name;
            return url;
        }catch (Exception e){
            log.error("上传文件失败！error msg:{}",e);
            return "";
        }
    }
}
