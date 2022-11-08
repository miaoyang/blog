package com.ym.blog.api.dao.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/26 21:26
 * @Desc:
 */
@Data
@AllArgsConstructor
@ToString
@ApiModel(value = "tag表")
public class Tag {
    private Long id;

    private String avatar;

    private String tagName;
}
