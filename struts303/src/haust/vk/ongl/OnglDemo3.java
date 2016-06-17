package haust.vk.ongl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;


/**
 * @author vk
 *
 * 2016年6月17日
 */
public class OnglDemo3 extends ActionSupport{
	// 根元素值
    private User user = new User(100,"Jacks");
    public User getUser() {
		return user;
	}
    public void setUser(User user) {
		this.user = user;
	}
    
    public String login() throws Exception{
    	//getVs();
    	
    	
    	
    	//得到actionContext对象 用于valuestatck的操作
    	ActionContext ac = ActionContext.getContext();
    	//映射数据
    	ac.getContextMap().put("request_data", "request_data");
    	//数据存储到request
    	//Map<String, Object> map=(Map<String, Object>) ac.get("request");
    	//map.put("request_data", "request_data");
    	//map.put("cn", "china");
    	
    	ac.getSession().put("Session_data", "Session_data");
    	ac.getApplication().put("Session_data", "Session_data");
    	
    	ValueStack vs = ac.getValueStack();
    	
    	vs.push(new User(1002,"sa"));
    	
    	
    	return "success";
    	
    }
    
    
    
    //获取值栈对象的两种方式
    private void  getVs(){
    	//获取值栈对象，方式1  通过servlet
    	HttpServletRequest request = ServletActionContext.getRequest();
    	
    	ValueStack vs1=(ValueStack) request.getAttribute("struts.valueStack");
    	
    	//获取值栈对象，方式2：通过ActionContext对象
    	ActionContext ac = ActionContext.getContext();
    	ValueStack vs2 = ac.getValueStack();
    	
    	System.out.println(vs1  == vs2);
    	
    }
    
}
