package com.ym.blog.api.dao.pojo;

import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/13 10:06
 * @Desc:
 */
@Data
public class ArticleTag {
    private Long id;

    private Long articleId;

    private Long tagId;
}
