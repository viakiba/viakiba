package haust.vk.a_tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 * @author vk
 *标签处理器类，需要继承SimpleTagSupport
 * 2016年4月15日
 */
public class ShowIpTag extends SimpleTagSupport{
	//注意：
	/*
	 这里，要得到pageContext对象，即实例化一个context（JspContext），用于接收pageContext
	然后使用setJspContext方法得到context。
	上面的步骤，其实SimpleTagSupport类已经做好了，
	我们无需再写
	 */
	
	//覆盖doGet方法
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext=(PageContext)this.getJspContext();
		HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
		String ip=request.getRemoteHost();
		JspWriter out=pageContext.getOut();
		out.write("ip地址是"+ip);
	}
}
