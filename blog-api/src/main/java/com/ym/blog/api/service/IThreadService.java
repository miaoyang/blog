package com.ym.blog.api.service;

import com.ym.blog.api.dao.pojo.Article;

public interface IThreadService {
    void updateViewCount(Article article);
}
