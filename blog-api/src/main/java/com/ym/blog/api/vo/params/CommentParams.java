package com.ym.blog.api.vo.params;

import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/13 09:26
 * @Desc:
 */
@Data
public class CommentParams {
    private Long articleId;

    private String content;

    private Long parent;

    private Long toUserId;
}
