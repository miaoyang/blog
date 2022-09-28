package com.ym.blog.datasource.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/16 20:05
 * @Desc:
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProp {
    //连接url
    private String endpoint;

    //公钥
    private String accesskey;

    //私钥
    private  String secretkey;

    //桶名称
    private String bucketName;
}
