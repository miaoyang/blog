package com.ym.blog.api.service;

import com.ym.blog.api.dao.pojo.Tag;
import com.ym.blog.api.vo.TagVo;

import java.util.List;

public interface TagService {

    List<TagVo> findTagsByArticleId(Long id);

    List<Tag> listHotTags(int limit);

    List<TagVo> findAll();

    TagVo findTagDetailById(Long id);
}
