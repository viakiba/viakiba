package haust.vk.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import haust.vk.entity.Employee;
import haust.vk.service.EmployeeService;

public class EmployeeAction extends ActionSupport{
	private EmployeeService empService;
	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}
	
	@Override
	public String execute() {
		int empid=1;
		//调用Service 获取
		Employee emp = empService.save(empid);
		//保存到request
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		
		request.put("emp", emp);
		return SUCCESS;
	}
}
