package com.softel.dao;

import com.softel.dao.base.BaseMapper;
import com.softel.model.TbMenu;
import java.util.List;

public interface TbMenuMapper extends BaseMapper<TbMenu> {

    int deleteByPrimaryKey(Integer id);

    int insert(TbMenu record);

    TbMenu selectByPrimaryKey(Integer id);

    TbMenu selectByPrimaryKeySelective(TbMenu record);

    int updateByPrimaryKeySelective(TbMenu record);

    int updateByPrimaryKey(TbMenu record);

    int deleteByExample(TbMenu var);

    List<TbMenu> selectByExample(TbMenu var);

    List<TbMenu> selectByLevel(Integer level);

    List<TbMenu> selectByParentId(Integer id);
}