package com.ym.blog.api.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/26 21:38
 * @Desc:
 */
@Data
public class ArticleVo {
    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private int weight;
    /**
     * 创建时间
     */
    private String createDate;

    private String author;

    private ArticleBodyVo body;

    private List<TagVo> tags;

    private CategoryVo categorys;
}
