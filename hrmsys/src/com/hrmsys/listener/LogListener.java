package com.hrmsys.listener;
/**
 * 添加监听器为日志提供路径path
 */
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LogListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		String url = sce.getServletContext().getRealPath("/");
		System.setProperty("path", url);
	}

}
