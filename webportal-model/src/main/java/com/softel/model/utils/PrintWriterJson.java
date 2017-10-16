package com.softel.model.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @Project  : elog
 * @ClassName   PrintWriterJson
 * @Description   TODO
 * @author   Administrator
 * @date   2016年11月10日
 * @Copyright: 2016 Softel Inc. All rights reserved.
 */
public class PrintWriterJson {
	
	public static void rspWrite(HttpServletResponse response, ResultVo resultVo){
		PrintWriter out = null;
		try
		{
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			String jsonStr = JSON.toJSONString(resultVo);
			out.print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			if (out != null)
			{
				out.close();
			}
		}
	}

}
