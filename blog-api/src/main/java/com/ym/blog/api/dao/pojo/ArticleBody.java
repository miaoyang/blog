package com.ym.blog.api.dao.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/30 20:35
 * @Desc:
 */
@Data
@ApiModel("文章body")
public class ArticleBody {

    private Long id;

    private String content;

    private String contentHtml;

    private Long articleId;
}
