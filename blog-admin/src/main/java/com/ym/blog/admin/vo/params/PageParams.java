package com.ym.blog.admin.vo.params;

import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/15 10:00
 * @Desc:
 */
@Data
public class PageParams {
    private Integer currentPage;

    private Integer pageSize;

    private String queryString;
}
