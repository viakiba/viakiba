package haust.vk.b_cases;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author vk
 *
 * 2016年4月16日
 */
public class ChooseTag extends SimpleTagSupport {
	//不是属性，而是临时变量
	private boolean flag;
	
	public boolean isFlag(){
		return flag;
	}
	
	public void setFlag(boolean flag){
		this.flag=flag;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		//输出标签体的内容
		this.getJspBody().invoke(null);
	}
}
