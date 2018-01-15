package com.softel.controller;

import com.github.pagehelper.PageInfo;
import com.softel.model.Merchant;
import com.softel.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @author: lsl
 * @description:
 * @date: Created in 18:03 2017/11/21
 * @modified By:
 */
@Controller
@RequestMapping("/api/")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping("merchant")
    @ResponseBody
    public PageInfo<Merchant> merchant(@RequestBody Merchant merchant){
        return merchantService.selectByPagehelper(merchant);
    }
}
