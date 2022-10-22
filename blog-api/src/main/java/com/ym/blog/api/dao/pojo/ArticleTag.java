package com.ym.blog.api.dao.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/13 10:06
 * @Desc:
 */
@Data
@ApiModel("文章tag")
public class ArticleTag {
    private Long id;

    private Long articleId;

    private Long tagId;
}
