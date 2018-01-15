package com.softel.filter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Component
public class CorsFilter implements Filter {

	private static final Logger log = Logger.getLogger(CorsFilter.class);
	
	private Map<String, String> map;
	private List<String> list;
	
	@Override
    public void destroy() {
		
	}

	@Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String origin = request.getHeader("origin");
		String[] alloworigin = map.get("Access-Control-Allow-Origin").toString().split(",");
		list = new ArrayList<String>();
		Collections.addAll(list, alloworigin);
		Set<String> set = map.keySet();
		// 取得里面的key的集合
		if(origin!=null){
			if(list.contains(origin)){
				response.setHeader("Access-Control-Allow-Origin", origin);
				for (String str : set) {
					// 遍历set去出里面的的Key
					if(!"Access-Control-Allow-Origin".equals(str)){
						response.setHeader(str, map.get(str).toString());
					}
				}
			}else{
				log.info(origin+"域名禁止跨域");
				return;
			}
		}
		filterChain.doFilter(request, response);
	}

	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
		Enumeration<String> enums = filterConfig.getInitParameterNames();
		map = new HashMap<String, String>(16);
		while(enums.hasMoreElements()){  
		    String paramName = enums.nextElement();  
		    String paramValue = filterConfig.getInitParameter(paramName);  
		    map.put(paramName, paramValue);
		} 
	}

}
