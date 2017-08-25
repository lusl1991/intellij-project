package com.softel.service;

import com.softel.model.Blog;
import com.softel.model.utils.ResultVo;

public interface BlogService {
    /**
     * 查询博客
     * @param blog
     * @return
     */
    ResultVo findAllBlog(Blog blog);
}
