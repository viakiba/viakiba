package haust.vk.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import haust.vk.entity.Admin;
import haust.vk.service.AdminService;

/**
 * @author vk
 *
 * 2016年6月16日
 */
public class UserAction extends ActionSupport{
	//   封装请求数据
	private Admin admin;
	public Admin getAdmin(){
		return admin;
	}
	
	public void setAdmin(Admin admin){
		this.admin=admin;
	}
	
	private AdminService admindao=new AdminService();
	//登陆
	public String login(){
		try {
			Admin userInfo = admindao.login(admin);
			//
			if(userInfo == null){
				
				return "input";
			}
			ActionContext.getContext().getSession().put("userInfo", userInfo);
			
			return "loginSuccess";
		} catch (Exception e) {
			System.out.println("error2_login");
			
			return ERROR;
		}
	}
	
	
	//列表
	public String list(){
		try {
			List<Admin> list=admindao.getAll();
			
			ActionContext.getContext().getContextMap().put("listAdmin", list);
			
			return "list";
		} catch (Exception e) {
			System.out.println("list_error");
			return ERROR;
		}
	}
	
	public String add(){
		return null;
		
	}
}
