package com.softel.dao;

import com.softel.dao.base.BaseMapper;
import com.softel.model.TbUser;

import java.util.List;

public interface TbUserMapper extends BaseMapper<TbUser> {

    @Override
    int insert(TbUser var);

    @Override
    int deleteByPrimaryKey(Integer id);

    @Override
    TbUser selectByPrimaryKey(Integer id);

    @Override
    int updateByPrimaryKeySelective(TbUser var);

    TbUser selectByAccount(String account);

    @Override
    List<TbUser> selectByExample(TbUser var);
}