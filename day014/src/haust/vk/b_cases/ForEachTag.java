package haust.vk.b_cases;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.w3c.dom.Entity;

/**
 * @author vk
 *
 * 2016年4月16日
 */
public class ForEachTag extends SimpleTagSupport {
	private Object items;
	private String var;
	
	public void setItems(Object items) {
		this.items = items;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext=(PageContext) this.getJspContext();
		
		/*if(items instanceof List){
			List list=(List) items;
			for(Object object : list){
				pageContext.setAttribute(var, object);
				this.getJspBody().invoke(null);
			}
		}
		
		if(items instanceof Map){
			Map map=(Map) items;
			Set<Entry> entrySet=map.entrySet();
			for(Entry entry:entrySet){
				pageContext.setAttribute(var, entry);
				
				this.getJspBody().invoke(null);
			}
		}*/
		Collection cool=null;
		if(items instanceof List){
			cool=(List) items;
		}
		
		if(items instanceof Map){
			Map map=(Map) items;
			cool=(Collection) map.entrySet();
		}
		
		for(Object object:cool){
			pageContext.setAttribute(var, object);
			
			this.getJspBody().invoke(null);
		}
	}
}
