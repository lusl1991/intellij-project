package com.softel.dao;

import com.softel.dao.base.BaseMapper;
import com.softel.model.TbMenu;
import java.util.List;

public interface TbMenuMapper extends BaseMapper<TbMenu> {

    @Override
    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(TbMenu record);

    @Override
    TbMenu selectByPrimaryKey(Integer id);

    @Override
    TbMenu selectByPrimaryKeySelective(TbMenu record);

    @Override
    int updateByPrimaryKeySelective(TbMenu record);

    @Override
    int updateByPrimaryKey(TbMenu record);

    @Override
    int deleteByExample(TbMenu var);

    @Override
    List<TbMenu> selectByExample(TbMenu var);

    List<TbMenu> selectByLevel(Integer level);

    List<TbMenu> selectByParentId(Integer id);
}