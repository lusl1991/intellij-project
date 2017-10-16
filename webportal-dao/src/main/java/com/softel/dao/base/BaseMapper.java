package com.softel.dao.base;

import java.util.List;

public interface BaseMapper<T> {
    int insert(T var);
    int deleteByPrimaryKey(T var);
    int updateByPrimaryKeySelective(T var);
    List<T> selectByPrimaryKey(T var);
}
