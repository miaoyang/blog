package com.ym.blog.api.dao.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/26 21:23
 * @Desc: 文章实体类
 */
@Data
public class Article {
    public static final int Article_TOP = 1;
    public static final int Article_Common = 0;
    //一定要记得加 要不然 会出现精度损失
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String title;

    private String summary;
    /**
     * 不能设置int，更新时导致为0
     */
    private Integer commentCounts;

    private Integer viewCounts;

    /**
     * 作者id
     */
    private Long authorId;
    /**
     * 内容id
     */
    private Long bodyId;
    /**
     *类别id
     */
    private Long categoryId;

    /**
     * 置顶
     */
    private Integer weight = Article_Common;
    /**
     * 创建时间
     */
    private Long createDate;
}
