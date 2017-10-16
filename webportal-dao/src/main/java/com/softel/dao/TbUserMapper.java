package com.softel.dao;

import com.softel.dao.base.BaseMapper;
import com.softel.model.TbUser;

public interface TbUserMapper extends BaseMapper<TbUser> {

    int insert(TbUser var);

    int deleteByPrimaryKey(Integer id);

    TbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUser var);

    TbUser selectByAccount(String account);
}