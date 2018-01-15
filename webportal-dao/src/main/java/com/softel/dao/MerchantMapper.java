package com.softel.dao;

import com.softel.dao.base.BaseMapper;
import com.softel.model.Merchant;

import java.util.List;

public interface MerchantMapper extends BaseMapper<Merchant> {
    @Override
    int insert(Merchant var);

    @Override
    int deleteByPrimaryKey(Integer var);

    @Override
    int deleteByExample(Merchant var);

    @Override
    int updateByPrimaryKey(Merchant var);

    @Override
    int updateByPrimaryKeySelective(Merchant var);

    @Override
    Merchant selectByPrimaryKey(Integer var);

    @Override
    Merchant selectByPrimaryKeySelective(Merchant var);

    @Override
    List<Merchant> selectByExample(Merchant var);
}