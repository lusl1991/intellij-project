package com.softel.service;

import com.softel.model.TbUser;
import com.softel.model.utils.Response;
import com.softel.model.utils.ResultVo;

import java.util.List;

public interface UserService {
    ResultVo userLogin(TbUser tbUser);

    ResultVo findUser(TbUser tbUser);

}
