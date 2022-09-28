package com.ym.blog.api.dao.pojo;

import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/30 20:35
 * @Desc:
 */
@Data
public class ArticleBody {

    private Long id;

    private String content;

    private String contentHtml;

    private Long articleId;
}
