package com.ym.blog.api.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/12 20:49
 * @Desc:
 */
@Data
public class CommentVo {
    private Long id;

    private UserVo author;

    private String content;

    private List<CommentVo> childrens;

    private String createDate;

    private Integer level;

    private UserVo toUser;
}
