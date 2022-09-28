package com.ym.blog.core.exception.file;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/18 10:27
 * @Desc:
 */
public class FileNameLengthLimitExceededException extends FileException{
    private static final long serialVersionUID = 1L;

    public FileNameLengthLimitExceededException(int defaultFileNameLength)
    {
        super("upload.filename.exceed.length", new Object[] { defaultFileNameLength });
    }
}
