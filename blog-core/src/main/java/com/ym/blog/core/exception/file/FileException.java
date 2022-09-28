package com.ym.blog.core.exception.file;

import com.ym.blog.core.exception.BaseException;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/18 10:24
 * @Desc:
 */
public class FileException extends BaseException {

    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args){
        super("file",code, args, null);
    }
}
