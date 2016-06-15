package haust.vk.c_data;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月15日
 */
/*
 * 数据处理实现接口方法
 */
public class DataAction_bak extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	
	@Override
	public void setApplication(Map<String, Object> request) {
		this.request=request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	@Override
	public void setRequest(Map<String, Object> application) {
		this.application=application;
	}
	
	@Override
	public String execute() throws Exception {
		
		// 数据
		request.put("request_data", "request_data1_actionAware");
		session.put("session_data", "session_data1_actionAware");
		application.put("application_data", "application_data1_actionAware");

		return SUCCESS;
	}
}
