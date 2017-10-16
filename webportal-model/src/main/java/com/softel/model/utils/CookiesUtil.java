package com.softel.model.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @Project  : elogistics
 * @ClassName   CookiesUtil
 * @Description   cookies 操作类
 * @author   Administrator
 * @date   2016年11月25日
 * @Copyright: 2016 Softel Inc. All rights reserved.
 */
public class CookiesUtil {
	
	public static void addCookie(String key,String value,Integer maxAge,boolean httponly,boolean secure,HttpServletResponse response){
		Cookie cookie=new Cookie(key,value);
		cookie.setPath("/");
		if(maxAge!=null){
			cookie.setMaxAge(maxAge);
		}
		cookie.setHttpOnly(httponly);
		cookie.setSecure(secure);
		response.addCookie(cookie);
	}

	/**
	 * 
	 * @Title: getCookieValue 
	 * @Description: 获取cookie value
	 * @param key
	 * @param request
	 * @return 
	 * @throws
	 */
	public static String getCookieValue(String key,HttpServletRequest request){
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equalsIgnoreCase(key)){
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: removeCookie 
	 * @Description: 删除cookie
	 * @param key
	 * @param request
	 * @param response 
	 * @throws
	 */
	public static void removeCookie(String key,HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equalsIgnoreCase(key)){
					Cookie newCookie=new Cookie(key,null);
					newCookie.setPath("/");
					newCookie.setMaxAge(0);
					response.addCookie(newCookie);
				}
			}
		}
	}
	
	/**
	 * 
	 * @Title: removeCookie 
	 * @Description: 设置cookie过期时间
	 * @param key
	 * @param request
	 * @param response 
	 * @throws
	 */
	public static void setMaxAge(String key, int expiry, HttpServletRequest request, HttpServletResponse response){
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equalsIgnoreCase(key)){
					cookie.setMaxAge(expiry);
				}
			}
		}
	}
}
