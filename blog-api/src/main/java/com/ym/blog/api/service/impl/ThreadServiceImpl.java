package com.ym.blog.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ym.blog.api.dao.mapper.ArticleMapper;
import com.ym.blog.api.dao.pojo.Article;
import com.ym.blog.api.service.IThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/12 17:58
 * @Desc:
 */
@Service
@EnableAsync
@Slf4j
public class ThreadServiceImpl implements IThreadService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    @Async("taskExecutor")
    public void updateViewCount(Article article) {
        log.error("updateViewCount article:{}",article);
        Article updateArticle = new Article();
        updateArticle.setViewCounts(article.getViewCounts()+1);
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Article::getId,article.getId());
        lambdaQueryWrapper.eq(Article::getViewCounts,article.getViewCounts());
        articleMapper.update(updateArticle,lambdaQueryWrapper);
        try {
            //睡眠5秒 证明不会影响主线程的使用
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
