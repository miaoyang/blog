package com.ym.blog.api.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ym.blog.api.dao.pojo.Article;
import com.ym.blog.api.vo.ArticleVo;
import com.ym.blog.api.vo.CategoryVo;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/26 21:41
 * @Desc:
 */
public interface ArticleMapper extends BaseMapper<Article> {

    List<ArticleVo> listArchives();

    CategoryVo findCategoryById(Long categoryId);
}
