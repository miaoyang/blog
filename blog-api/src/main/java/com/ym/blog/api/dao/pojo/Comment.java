package com.ym.blog.api.dao.pojo;

import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/12 20:39
 * @Desc:
 */
@Data
public class Comment {
    private Long id;

    private String content;

    private Long createDate;

    private Long articleId;

    private Long authorId;

    private Long parentId;

    private Long toUid;

    private Integer level;
}
