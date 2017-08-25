package com.softel.controller;

import com.softel.model.Blog;
import com.softel.model.utils.ResultVo;
import com.softel.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
@RequestMapping("/blogApi/")
public class BlogController {
    @Resource
    private BlogService blogService;

    @RequestMapping("findAllBlogInfo")
    @ResponseBody
    public ResultVo findAllStudentInfo (String id){
        Blog blog = new Blog();
        //不做过多验证判断
        if(id != null && id.equals("")){
            blog.setId(new Integer(id));
        }else{
            blog = null;
        }
        return blogService.findAllBlog(blog);
    }
}