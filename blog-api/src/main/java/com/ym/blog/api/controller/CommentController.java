package com.ym.blog.api.controller;

import com.ym.blog.api.dao.pojo.Comment;
import com.ym.blog.api.service.ICommentService;
import com.ym.blog.api.vo.CommentVo;
import com.ym.blog.api.vo.Result;
import com.ym.blog.api.vo.params.CommentParams;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/12 20:40
 * @Desc:
 */
@RestController
@RequestMapping("/comments")
@Slf4j
@Api(tags = "评论管理")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/article/{id}")
    public Result comment(@PathVariable("id")Long articleId){
        List<CommentVo> commentVoList = commentService.commentByArticleId(articleId);
        return Result.success(commentVoList);
    }

    @PostMapping("/create/change")
    public Result createChange(@RequestBody CommentParams commentParams){
        commentService.createChange(commentParams);
        return Result.success();
    }

}
