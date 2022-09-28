package com.ym.blog.api.service;

import com.ym.blog.api.vo.ArchivesVo;
import com.ym.blog.api.vo.ArticleVo;
import com.ym.blog.api.vo.Result;
import com.ym.blog.api.vo.params.ArticleParams;
import com.ym.blog.api.vo.params.PageParams;

public interface ArticleService {

    Result listArticle(PageParams params);

    Result hotArticle(int limit);

    Result newArticle(int limit);

    Result listArchives();

    ArticleVo findArticleById(Long id);

    ArticleVo publish(ArticleParams articleParams);
}
