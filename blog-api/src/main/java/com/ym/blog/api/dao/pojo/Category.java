package com.ym.blog.api.dao.pojo;

import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/30 20:36
 * @Desc:
 */
@Data
public class Category {
    private Long id;

    private String avatar;

    private String categoryName;

    private String description;
}
