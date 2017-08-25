package com.softel.dao.base;

import java.util.List;

public interface BaseMapper<T> {
    Boolean insert(T var);
    Boolean deleteByPrimaryKey(T var);
    Boolean updateByPrimaryKeySelective(T var);
    List<T> selectByPrimaryKey(T var);
}
