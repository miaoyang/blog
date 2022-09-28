package com.ym.blog.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ym.blog.api.dao.mapper.TagMapper;
import com.ym.blog.api.dao.pojo.Tag;
import com.ym.blog.api.service.TagService;
import com.ym.blog.api.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/28 19:58
 * @Desc:
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long id) {
        List<Tag> tags = tagMapper.findTagsByArticleId(id);
        return copyTagList(tags);
    }

    @Override
    public List<Tag> listHotTags(int limit) {
        /**
         * 1.标签的文章数量最多
         * 2.根据tag_id 分组排序
         */
        List<Long> tagIds = tagMapper.findHotTagIds(limit);
        if (CollectionUtils.isEmpty(tagIds)){
            return Collections.emptyList();
        }
        List<Tag> tagList = tagMapper.findTagsByTagIds(tagIds);
        return tagList;
    }

    /**
     * 查询所有的文章标签
     * @return
     */
    @Override
    public List<TagVo> findAll() {
        List<Tag> tagList = tagMapper.selectList(new LambdaQueryWrapper<>());
        return copyTagList(tagList);
    }

    @Override
    public TagVo findTagDetailById(Long id) {
        Tag tag = tagMapper.selectById(id);
        TagVo tagVo = copyTag(tag);
        return tagVo;
    }

    private List<TagVo> copyTagList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag: tagList) {
            tagVoList.add(copyTag(tag));
        }
        return tagVoList;
    }

    public TagVo copyTag(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }
}
