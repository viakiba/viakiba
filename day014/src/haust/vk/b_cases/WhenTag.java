package haust.vk.b_cases;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author vk
 *
 * 2016年4月16日
 */
public class WhenTag extends SimpleTagSupport {
	private boolean test;
	
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//获取父标签
				ChooseTag parent=(ChooseTag)this.getParent();
				parent.setFlag(test);
		//根据test的返回值决定是否输出标签体的内容
		if(test){
			this.getJspBody().invoke(null);
		}
		
	}
	
	
}
