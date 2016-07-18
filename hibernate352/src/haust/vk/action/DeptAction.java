package haust.vk.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import haust.vk.entity.Dept;
import haust.vk.service.DeptService;

public class DeptAction extends ActionSupport{
	private DeptService deptService = new DeptService();
	
	public String execute(){
		Dept dept=deptService.findById(1);
		
		ActionContext.getContext().getContextMap().put("dept", dept);
		return SUCCESS;
	}
}
