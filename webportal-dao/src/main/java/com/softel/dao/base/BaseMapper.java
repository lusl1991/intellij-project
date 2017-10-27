package com.softel.dao.base;

import java.util.List;

public interface BaseMapper<T> {
    int insert(T var);
    int deleteByPrimaryKey(Integer var);
    int deleteByExample(T var);
    int updateByPrimaryKey(T var);
    int updateByPrimaryKeySelective(T var);
    T selectByPrimaryKey(Integer var);
    T selectByPrimaryKeySelective(T var);
    List<T> selectByExample(T var);
}
