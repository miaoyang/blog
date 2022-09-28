package com.ym.blog.api.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ym.blog.api.dao.pojo.Tag;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/26 21:43
 * @Desc:
 */
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 根据文章id查询标签列表
     * @param id
     * @return
     */
    List<Tag> findTagsByArticleId(Long id);

    List<Long> findHotTagIds(int limit);

    List<Tag> findTagsByTagIds(List<Long> tagIds);
}
