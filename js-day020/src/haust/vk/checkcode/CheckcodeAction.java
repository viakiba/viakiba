package haust.vk.checkcode;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckcodeAction extends ActionSupport{
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	/**
	 * 验证
	 */
	public String check() throws Exception{
		String tip = "images/MsgError.gif";
		String checkserver = (String) ActionContext.getContext().getSession().get("CHECKNUM");
		if(checkcode.equals(checkserver)){
			tip = "images/MsgSent.gif";
		}
		//
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(tip);
		pw.flush();
		pw.close();
		return null;
	}
}
