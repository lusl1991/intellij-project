package com.softel.controller;

import com.softel.annotation.CaptchaAnnotation;
import com.softel.model.TbUser;
import com.softel.model.utils.CookiesUtil;
import com.softel.model.utils.ResultVo;
import com.softel.model.utils.SessionUtils;
import com.softel.model.utils.TokenProcessor;
import com.softel.service.MenuService;
import com.softel.service.UserService;
import com.softel.vo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/login")
    @CaptchaAnnotation(checkCaptcha = false)
    @ResponseBody
    public ResultVo UserLogin(@RequestBody TbUser tbUser, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultVo resultVo = userService.userLogin(tbUser);
        if(resultVo.isSuccess()){
            this.CreateToken(request, response);
        }
        return resultVo;
    }

    public void CreateToken(HttpServletRequest request, HttpServletResponse response){
        String token = TokenProcessor.getInstance().generateTokeCode();
        CookiesUtil.addCookie("token", token, -1, false, false, response);
        SessionUtils.setSessionValue("token", token, request);
    }

    @RequestMapping("/selectMenu")
    @ResponseBody
    public List<Menu> selectMenu(HttpServletRequest request, HttpServletResponse response){
       return menuService.selectByLevel();
    }

}
