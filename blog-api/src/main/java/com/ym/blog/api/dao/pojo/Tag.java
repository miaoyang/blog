package com.ym.blog.api.dao.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/26 21:26
 * @Desc:
 */
@Data
@ApiModel("tag表")
public class Tag {
    private Long id;

    private String avatar;

    private String tagName;
}
