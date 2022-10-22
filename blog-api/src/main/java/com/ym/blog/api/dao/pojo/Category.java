package com.ym.blog.api.dao.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/30 20:36
 * @Desc:
 */
@Data
@ApiModel("类别表")
public class Category {
    private Long id;

    private String avatar;

    private String categoryName;

    private String description;
}
