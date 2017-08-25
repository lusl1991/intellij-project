package com.softel.service.impl;

import com.softel.dao.BlogMapper;
import com.softel.model.Blog;
import com.softel.model.utils.ResultVo;
import com.softel.service.BlogService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    /**
     * 查询博客
     *
     * @param blog
     * @return
     */
    public ResultVo findAllBlog(Blog blog) {
        ResultVo resultVo = new ResultVo();
        List<Blog> list = blogMapper.selectByPrimaryKey(blog);
        if(list.isEmpty()){
            resultVo.setMessage("暂无相关数据");
        }else{
            resultVo.setResult(list);
        }
        return resultVo;
    }
}
