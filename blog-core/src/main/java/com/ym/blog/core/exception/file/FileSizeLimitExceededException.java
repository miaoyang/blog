package com.ym.blog.core.exception.file;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/18 10:28
 * @Desc:
 */
public class FileSizeLimitExceededException extends FileException{
    private static final long serialVersionUID = 1L;

    public FileSizeLimitExceededException(long defaultMaxSize) {
        super("upload.exceed.maxSize", new Object[] { defaultMaxSize });
    }
}
