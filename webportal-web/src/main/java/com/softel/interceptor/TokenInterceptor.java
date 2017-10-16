package com.softel.interceptor;

import com.softel.annotation.TokenAnnotation;
import com.softel.model.utils.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        TokenAnnotation tokenAnnotation = method.getAnnotation(TokenAnnotation.class);
        if(tokenAnnotation != null){
            ResultVo resultVo = new ResultVo();
            if(tokenAnnotation.checkToken()){
                String token = CookiesUtil.getCookieValue("token",request);
                String server = SessionUtils.getSessionValue("token",request);
                if(token != "" && server != "" && !token.equals(server)){
                    resultVo.setSuccess(false);
                    resultVo.setMessage("页面已过期，请刷新");
                    PrintWriterJson.rspWrite(response,resultVo);
                    return false;
                }else{
                    String afresh = TokenProcessor.getInstance().generateTokeCode();
                    CookiesUtil.addCookie("token",afresh, -1, false, false, response);
                    SessionUtils.setSessionValue("token", afresh, request);
                }
            }
        }
        return true;
    }
}
