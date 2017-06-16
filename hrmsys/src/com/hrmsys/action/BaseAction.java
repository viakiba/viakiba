package com.hrmsys.action;
/**
 * @author sux
 * @date 2011-01-10
 * @class BaseAction
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	Log log = LogFactory.getLog("BaseAction.class");
	
	/**
	 * by ServletActionContext get Response
	 * @return response
	 */
	public HttpServletResponse getResponse(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=UTF-8");
		return response;
	}
	
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	/**
	 * get session
	 * @return
	 */
	public Map<String, Object> getSession(){
		return ActionContext.getContext().getSession();
	}
	/**
	 * Open PrintWriter
	 * @return
	 */
	public PrintWriter getWriter(){
		HttpServletResponse response = this.getResponse();
		PrintWriter pw = null;
		try {
			 pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pw;
	}
	/**
	 * close PrintWriter
	 * @param out
	 */
	public void close(PrintWriter out){
		if(out != null){
			out.close();
		}
	}
	/**
	 * write json string
	 * @param json
	 */
	public void out(String json){
		PrintWriter out = this.getWriter();
		out.write(json);
		this.close(out);
	}
}
