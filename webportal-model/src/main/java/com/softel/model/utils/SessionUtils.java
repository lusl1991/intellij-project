package com.softel.model.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    public static String getSessionValue(String key, HttpServletRequest request){
        HttpSession session = request.getSession();
        return (String) session.getAttribute(key);
    }

    public static void setSessionValue(String key, String value, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }
}
