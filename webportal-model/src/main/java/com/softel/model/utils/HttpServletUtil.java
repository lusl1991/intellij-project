package com.softel.model.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

 /**
 *  @Author: lsl
 *  @Description:
 *  @Param: null
 *  @Date: 12:03 2018/1/15
 */

public class HttpServletUtil {
	
	public static ServletRequestAttributes getServletRequestAttributes(){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		return sra;
	}
	
	public static RequestContext getRequestContext(){
		return new RequestContext(getHttpRequest());
	}
	
	public static HttpServletRequest getHttpRequest(){
		ServletRequestAttributes attr=getServletRequestAttributes();
		return attr.getRequest();
	}
	
	public static HttpServletResponse getHttpResponse(){
		ServletRequestAttributes attr = getServletRequestAttributes();
		return attr.getResponse();
	}
	
	public static String getI18nMessage(String key){
		return getRequestContext().getMessage(key);
	}
	
	public static String getLocale(){
		return getRequestContext().getLocale().toLanguageTag();
	}

}
