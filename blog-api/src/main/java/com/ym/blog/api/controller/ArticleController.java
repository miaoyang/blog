package com.ym.blog.api.controller;

import com.ym.blog.api.service.ArticleService;
import com.ym.blog.api.vo.ArticleVo;
import com.ym.blog.api.vo.Result;
import com.ym.blog.api.vo.params.ArticleParams;
import com.ym.blog.api.vo.params.PageParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/28 18:49
 * @Desc:
 */
@RestController
@RequestMapping("/articles")
@Api("文章")
public class ArticleController {
    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    /**
     * 首页文章列表
     * @param params
     * @return
     */
    @PostMapping
    @ApiOperation("首页文章列表")
    public Result listArticle(@RequestBody PageParams params){

        return articleService.listArticle(params);
    }

    @PostMapping("/hot")
    @ApiOperation("最热文章")
    public Result hotArticle(){
        int limit = 6;
        return articleService.hotArticle(limit);
    }

    @PostMapping("/new")
    public Result newArticle(){
        int limit = 6;
        return articleService.newArticle(limit);
    }

    @PostMapping("/listArchives")
    public Result listArchives(){
        return articleService.listArchives();
    }

    @PostMapping("/view/{id}")
    public Result findArticleById(@PathVariable("id")Long id){
        log.debug("articleId:{}",id);
        ArticleVo articleVo = articleService.findArticleById(id);
        return Result.success(articleVo);
    }

    /**
     * 发布文章
     * @param articleParams
     * @return
     */
    @PostMapping("/publish")
    @ApiOperation("发布文章")
    public Result publish(@RequestBody ArticleParams articleParams){
        ArticleVo articleVo = articleService.publish(articleParams);
        return Result.success(articleVo);
    }
}
