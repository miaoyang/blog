package com.ym.blog.api.service;

import com.ym.blog.api.vo.CategoryVo;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/31 21:44
 * @Desc:
 */
public interface CategoryService {
    CategoryVo findCategoryById(Long id);

    List<CategoryVo> findAll();

    List<CategoryVo> findAllDetail();

    CategoryVo findCategoryDetailById(Long id);
}
