package com.ym.blog.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ym.blog.api.dao.mapper.CommentMapper;
import com.ym.blog.api.dao.pojo.Comment;
import com.ym.blog.api.dao.pojo.SysUser;
import com.ym.blog.api.service.ICommentService;
import com.ym.blog.api.service.SysUserService;
import com.ym.blog.api.utils.UserThreadLocal;
import com.ym.blog.api.vo.CommentVo;
import com.ym.blog.api.vo.UserVo;
import com.ym.blog.api.vo.params.CommentParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/12 20:41
 * @Desc:
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<CommentVo> commentByArticleId(Long articleId) {
        LambdaQueryWrapper<Comment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Comment::getArticleId,articleId);
        lambdaQueryWrapper.eq(Comment::getLevel,1);
        List<Comment> comments = commentMapper.selectList(lambdaQueryWrapper);
        return copyList(comments);
    }

    @Override
    public void createChange(CommentParams commentParams) {
        SysUser sysUser = UserThreadLocal.get();
        Comment comment = new Comment();
        comment.setArticleId(commentParams.getArticleId());
        comment.setContent(commentParams.getContent());
        comment.setAuthorId(sysUser.getId());
        comment.setCreateDate(System.currentTimeMillis());
        Long parentId = commentParams.getParent();
        if (parentId == null || parentId == 0){
            comment.setLevel(1);
        }else {
            comment.setLevel(2);
        }
        comment.setParentId(parentId==null ? 0 : parentId);
        commentMapper.insert(comment);
    }

    private List<CommentVo> findCommentsByParentId(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getParentId,id);
        queryWrapper.eq(Comment::getLevel,2);
        List<Comment> comments = this.commentMapper.selectList(queryWrapper);
        return copyList(comments);
    }


    private List<CommentVo> copyList(List<Comment> comments) {
        List<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment:comments){
            commentVoList.add(copyComment(comment));
        }
        return commentVoList;
    }

    private CommentVo copyComment(Comment comment) {
        CommentVo commentVo = new CommentVo();
        BeanUtils.copyProperties(comment,commentVo);
        commentVo.setCreateDate(new DateTime(comment.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        Long authorId = comment.getAuthorId();
        UserVo userVo = sysUserService.findUserVoById(authorId);
        commentVo.setAuthor(userVo);

        List<CommentVo> commentVoList = findCommentsByParentId(comment.getParentId());
        commentVo.setChildrens(commentVoList);
        if (comment.getLevel()>1){
            Long toUid = comment.getToUid();
            UserVo toUserVo = sysUserService.findUserVoById(toUid);
            commentVo.setToUser(toUserVo);
        }
        return commentVo;
    }
}
