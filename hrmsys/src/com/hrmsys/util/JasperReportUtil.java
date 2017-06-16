package com.hrmsys.util;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.apache.struts2.ServletActionContext;


public class JasperReportUtil {
	/**
	 * 对jrxml文件进行编译
	 */
	public void compileJrxml(String filename){
		String path = ServletActionContext.getServletContext().getRealPath(filename);
		//JasperCompileManager.compileReportToFile(sourceFileName);
	}
}
