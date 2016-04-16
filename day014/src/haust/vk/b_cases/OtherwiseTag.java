package haust.vk.b_cases;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author vk
 *
 * 2016年4月16日
 */
public class OtherwiseTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		ChooseTag parent=(ChooseTag)this.getParent();
		boolean test=parent.isFlag();
		if(!test){
			this.getJspBody().invoke(null);
		}
	}
}
