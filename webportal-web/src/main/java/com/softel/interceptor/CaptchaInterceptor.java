package com.softel.interceptor;

import com.google.code.kaptcha.Constants;
import com.softel.annotation.CaptchaAnnotation;
import com.softel.model.utils.PrintWriterJson;
import com.softel.model.utils.ResultVo;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class CaptchaInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        CaptchaAnnotation captchaAnnotation = method.getAnnotation(CaptchaAnnotation.class);
        if(captchaAnnotation != null){
            ResultVo resultVo = new ResultVo();
            if(captchaAnnotation.checkCaptcha()){
                String captchaCode = request.getParameter("captcha");
                String generateCode =(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
                if(!captchaCode.equals(generateCode)){
                    resultVo.setSuccess(false);
                    resultVo.setMessage("验证码错误");
                    PrintWriterJson.rspWrite(response,resultVo);
                    return false;
                }
            }
        }
        return true;
    }
}
