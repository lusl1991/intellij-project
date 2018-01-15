package com.softel.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceException;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.softel.exception.BusinessException;
import com.softel.model.utils.ResultVo;
import com.softel.service.exception.RootRuntimeException;
import com.softel.service.exception.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 图片验证码
 */
@Controller
@RequestMapping("/captcha")
 public class CaptchaController {
 
     @Resource
     private Producer captchaProducer;
     /**
      *             
      * 获取验证码图片
      * @param         request
      * @param         response
      * @return
      * @throws         IOException
      * Created        2017年1月17日 下午5:07:28
      */
     @RequestMapping("/getCaptchaCode")
     public ModelAndView getCaptchaCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
         HttpSession session = request.getSession();
         
         response.setDateHeader("Expires", 0);  
         response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
         response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
         response.setHeader("Pragma", "no-cache");  
         response.setContentType("image/jpeg"); 
         
         //生成验证码文本
         String capText = captchaProducer.createText();  
         session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
         System.out.println("生成验证码文本===="+capText);
         //利用生成的字符串构建图片
         BufferedImage bi = captchaProducer.createImage(capText);
         ServletOutputStream out = response.getOutputStream();  
         ImageIO.write(bi, "jpg", out);
         
         try {  
             out.flush();  
         } finally {  
             out.close();  
         }
         return null;
     }
     
     /**
      *             
      * 前端输入的验证码与生成的对比
      * @param         request
      * @param         response
      * @param         captchaCode
      * Created        2017年1月17日 下午5:34:23
      */
     @RequestMapping("/checkCaptchaCode")
     @ResponseBody
     public ResultVo checkCaptchaCode(HttpServletRequest request, HttpServletResponse response, @RequestParam("captcha") String captcha){
         ResultVo resultVo = new ResultVo();
         System.out.println("页面输入验证码===="+captcha);
         
         response.setCharacterEncoding("UTF-8");
         response.setHeader("Pragma", "No-cache");
         response.setHeader("Cache-Control", "no-cache");
         response.setDateHeader("Expires", 0);
         
         String generateCode =(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
         String result = "";
         if(generateCode.equals(captcha)){
             resultVo.setSuccess(true);
             resultVo.setMessage("验证成功");
         }else{
             resultVo.setSuccess(false);
             resultVo.setMessage("输入错误");
         }
         return resultVo;
     }
}
