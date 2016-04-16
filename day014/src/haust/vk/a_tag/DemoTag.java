package haust.vk.a_tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author vk
 *
 * 2016年4月15日
 */
public class DemoTag extends SimpleTagSupport{
	private Integer num;
	
	public void setNum(Integer num){
		this.num=num;
	}
	
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("shuchu");
		//得到标签体的内容
		JspFragment jspBody=this.getJspBody();
		
		/*
		//1.使用 null 输出 执行invoke方法
		jspBody.invoke(null);
		*/
		
		/*
		 * 2.使用out输出
		 */
		/*
		JspWriter out=this.getJspContext().getOut();
		jspBody.invoke(out);
		*/
		
		/*
		 * 循环输出此标签体的内容
		 */
		
		for(int i=0;i<num;i++){
			jspBody.invoke(null);
		}
		
		
		/*
		 * 改变标签体的内容
		 */
		//创建StringWriter临时容器
		
		/*StringWriter sw=new StringWriter();
		jspBody.invoke(sw);
		String content=sw.toString();
		content=content.toUpperCase();
		System.out.println(content);
		this.getJspContext().getOut().write(content);*/
		
		//控制标签体下的内容是否输出，输出什么都不干，不输出，跑出SkipPageException异常
		throw new SkipPageException();
	}
}
