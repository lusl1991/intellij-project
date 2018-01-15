package com.softel.service.impl;

import com.softel.dao.TbUserMapper;
import com.softel.model.TbUser;
import com.softel.model.utils.Response;
import com.softel.model.utils.ResultVo;
import com.softel.model.utils.TokenProcessor;
import com.softel.service.UserService;
import com.softel.service.exception.ServiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.naming.ServiceUnavailableException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public ResultVo userLogin(TbUser tbUser) {
        ResultVo resultVo = new ResultVo();
        TbUser tbUser1 = tbUserMapper.selectByAccount(tbUser.getAccount());
        if(tbUser1 != null){
            if(tbUser1.getPassword().equals(tbUser.getPassword())){
                resultVo.setSuccess(true);
            }else{
                resultVo.setSuccess(false);
                resultVo.setMessage("密码错误");
            }
        }else{
            resultVo.setSuccess(false);
            resultVo.setMessage("用户不存在");
        }
        Response response = null;
        System.out.println(response.getData());
        return resultVo;
    }

    @Override
    public ResultVo findUser(TbUser tbUser) {
        ResultVo resultVo = new ResultVo();
        List<TbUser> list = tbUserMapper.selectByExample(tbUser);
        resultVo.setResult(list);
        return resultVo;
    }

}
