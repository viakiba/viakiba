package com.hisoft.xypj.tool;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ControlUtil {

	private static final Logger log = LoggerFactory.getLogger(ControlUtil.class);
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 将对象转为JSON字符�?
	 * @param value
	 * @return
	 */
	public static String toJsonStr(Object value) {
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			mapper.setDateFormat(dateFormat);
			return mapper.writeValueAsString(value);
		} catch (Exception e) {
			log.error("转换对象为JSON字符串异", e);
		}
		return "";
	}

	/**
	 * 向response中写入内�?
	 * @param response
	 * @param text
	 */
	public static void writeJsonData(HttpServletResponse response, String text) {

		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		try {
			response.getWriter().write(text);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			log.error("向HttpServletResponse中写数据异常", e);
		}
	}

	/**
	 * 获取返回结果json
	 * @param msg
	 * @param state
	 * @return
	 */
	public static String getResultJson(String msg,String state) {
		
		HashMap<String, String> errorInfo = new HashMap<String, String>();
		errorInfo.put("state", state);
		errorInfo.put("data", msg);
		
		return toJsonStr(errorInfo);
	}
}
