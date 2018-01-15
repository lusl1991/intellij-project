package com.softel.model.utils;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0
 * @author: lsl
 * @description:
 * @date: Created in 10:09 2017/11/23
 * @modified By:
 */
public class UserAgentUtil {

    private static Logger log = LoggerFactory.getLogger(UserAgentUtil.class);

    public UserAgentUtil(HttpServletRequest request){
        //获取浏览器信息
        String ua = request.getHeader("User-Agent");
        //转成UserAgent对象
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        //获取浏览器信息
        Browser browser = userAgent.getBrowser();
        //获取系统信息
        OperatingSystem os = userAgent.getOperatingSystem();
        //系统名称
        String system = os.getName();
        log.info("操作系统名称:"+system);
        //浏览器名称
        String browserName = browser.getName();
        log.info("浏览器名称:"+browserName);
        //浏览器版本
        Version version = browser.getVersion(ua);
        log.info("浏览器版本:"+version.getVersion());
    }
}
