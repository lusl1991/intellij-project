package com.softel.dao;

import com.softel.dao.base.BaseMapper;
import com.softel.model.Blog;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BlogMapper extends BaseMapper<Blog> {
    Boolean insert(Blog var);

    Boolean deleteByPrimaryKey(Blog var);

    Boolean updateByPrimaryKeySelective(Blog var);

    List<Blog> selectByPrimaryKey(Blog var);
}