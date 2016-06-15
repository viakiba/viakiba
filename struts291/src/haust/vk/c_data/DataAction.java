package haust.vk.c_data;



import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月15日
 */
public class DataAction extends ActionSupport{
	//1.请求数据的封装   2.调用service处理 的业务逻辑，拿到结果数据
	//把数据保存到域中
	
	@Override
	public String execute() throws Exception {
		/*
		//struts 中对数据操作 ，方式 1：直接拿到servletApi，执行操作
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext application = ServletActionContext.getServletContext();
		
		//操作
		request.setAttribute("request_data", "request_data5");
		session.setAttribute("session_data", "session_data1");
		application.setAttribute("application_data", "application_data1");
		*/
		
		ActionContext ac = ActionContext.getContext();
		
		Map<String, Object> application = ac.getApplication();
		Map<String, Object> session = ac.getSession();
		Map<String, Object> request = ac.getContextMap();
		
		request.put("request_data", "request_data1_actionContext7");
		session.put("session_data", "session_data1_actionContext7");
		application.put("application_data", "application_data1_actionContext7");
		
		
		return SUCCESS;
	}
}
	