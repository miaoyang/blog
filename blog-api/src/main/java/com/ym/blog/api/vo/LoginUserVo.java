package com.ym.blog.api.vo;

import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/30 12:02
 * @Desc:
 */
@Data
public class LoginUserVo {

    private Long id;

    private String account;

    private String nickname;

    private String avatar;
}
