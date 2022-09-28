package com.ym.blog.api.service;

import com.ym.blog.api.vo.CommentVo;
import com.ym.blog.api.vo.params.CommentParams;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/12 20:41
 * @Desc:
 */
public interface ICommentService {

    List<CommentVo> commentByArticleId(Long articleId);

    void createChange(CommentParams commentParams);
}
