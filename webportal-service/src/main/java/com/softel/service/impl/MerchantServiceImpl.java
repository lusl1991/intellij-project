package com.softel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.softel.dao.MerchantMapper;
import com.softel.model.Merchant;
import com.softel.service.MerchantService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @author: lsl
 * @description:
 * @date: Created in 18:05 2017/11/21
 * @modified By:
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    @Resource
    private MerchantMapper merchantMapper;

    @Override
    public PageInfo<Merchant> selectByPagehelper(Merchant merchant) {
        PageHelper.startPage(merchant.getPageNum(), merchant.getPageSize());
        List<Merchant> list = merchantMapper.selectByExample(merchant);
        PageInfo<Merchant> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
