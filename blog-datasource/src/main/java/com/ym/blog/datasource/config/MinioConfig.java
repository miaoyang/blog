package com.ym.blog.datasource.config;

import com.ym.blog.datasource.pojo.MinioProp;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/16 19:50
 * @Desc:
 */
@Configuration
public class MinioConfig {

    @Autowired
    private MinioProp prop;

    /**
     * 获取 MinioClient
     * @return MinioClient
     */
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(prop.getEndpoint()).
                credentials(prop.getAccesskey(),prop.getSecretkey()).build();
    }
}
