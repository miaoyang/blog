package com.ym.blog.api.vo.params;

import com.ym.blog.api.vo.CategoryVo;
import com.ym.blog.api.vo.TagVo;
import lombok.Data;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/13 09:49
 * @Desc:
 */
@Data
public class ArticleParams {
    private Long id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;
}
