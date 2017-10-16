package com.softel.service;

import com.softel.model.TbUser;
import com.softel.model.utils.ResultVo;

public interface UserService {
    ResultVo userLogin(TbUser tbUser);
}
