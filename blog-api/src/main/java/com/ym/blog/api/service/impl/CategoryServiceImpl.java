package com.ym.blog.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ym.blog.api.dao.mapper.CategoryMapper;
import com.ym.blog.api.dao.pojo.Category;
import com.ym.blog.api.service.CategoryService;
import com.ym.blog.api.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/31 21:44
 * @Desc:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public CategoryVo findCategoryById(Long id) {
        Category category = categoryMapper.selectById(id);
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }

    /**
     * 所有文章分类
     * @return
     */
    @Override
    public List<CategoryVo> findAll() {
        List<Category> categoryList = categoryMapper.selectList(new LambdaQueryWrapper<>());
        return copyList(categoryList);
    }

    @Override
    public List<CategoryVo> findAllDetail() {
        List<Category> categoryList = categoryMapper.selectList(new LambdaQueryWrapper<>());
        return copyList(categoryList);
    }

    @Override
    public CategoryVo findCategoryDetailById(Long id) {
        Category category = categoryMapper.selectById(id);
        CategoryVo categoryVo = copyCategory(category);
        return categoryVo;
    }

    private List<CategoryVo> copyList(List<Category> categoryList) {
        List<CategoryVo> categoryVoList = new ArrayList<>();
        for (Category category:categoryList){
            categoryVoList.add(copyCategory(category));
        }
        return categoryVoList;
    }

    private CategoryVo copyCategory(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}
