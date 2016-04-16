package haust.vk.b_cases;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author vk
 *
 * 2016年4月16日
 */
public class IfTag extends SimpleTagSupport{
	private boolean test;
	
	public void setTest(boolean test){
		this.test=test;
	}
	
	
	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			this.getJspBody().invoke(null);
		}
	}
}
