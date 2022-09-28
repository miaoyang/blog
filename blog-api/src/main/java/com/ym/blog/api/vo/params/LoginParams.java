package com.ym.blog.api.vo.params;

import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/29 21:37
 * @Desc:
 */
@Data
public class LoginParams {

    private String account;

    private String password;

    private String nickname;
}
