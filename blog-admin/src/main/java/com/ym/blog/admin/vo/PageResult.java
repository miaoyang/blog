package com.ym.blog.admin.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/15 10:03
 * @Desc:
 */
@Data
public class PageResult<T> {

    private List<T> list;

    private Long total;
}
