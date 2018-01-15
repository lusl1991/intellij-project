package com.softel.service;

import com.github.pagehelper.PageInfo;
import com.softel.model.Merchant;

/**
 * @version 1.0
 * @author: lsl
 * @description:
 * @date: Created in 18:05 2017/11/21
 * @modified By:
 */
public interface MerchantService {
    /**
     * 分页查询
     * @param merchant
     * @return
     */
    PageInfo<Merchant> selectByPagehelper(Merchant merchant);
}
