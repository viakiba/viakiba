package haust.vk.action;

import java.util.List;

import haust.vk.entity.Employee;
import haust.vk.service.IEmployeeService;
import haust.vk.service.impl.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author vk
 *
 * 2016年6月18日
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	/**
	 * 封装数据
	 */
	private Employee employee = new Employee();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	//重写模型驱动方法
	@Override
	public Employee getModel() {
		return employee;
	}
	
	/**
	 * 调用service
	 */
	private IEmployeeService employeeService = new EmployeeService();
	
	/**
	 * 1.添加员工
	 */
	public String save(){
		try {
			//调用service保存
			employeeService.save(employee);
			//添加成功，去到列表页面
			return list();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 2.列表显示
	 */
	public String list() {
		try {
			//查询全部
			List<Employee> listEmp = employeeService.list();
			//保存到request域中
			ActionContext.getContext().getContextMap().put("listEmp", listEmp);
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 3.修改页面  使用到了数据回显  需要struts标签的支持 jsp
	 */
	public String viewUpdate(){
		try {
			//1.获取当前修改的记录的主键值
			int id = employee.getId();
			//2.service进行查询
			Employee emp = employeeService.findById(id);
			//3.数据回显
			//首先得到值栈
			ValueStack vs = ActionContext.getContext().getValueStack();
			//把数据放到栈顶   根据栈的特性pop方法可以略去
			vs.pop();
			vs.push(emp);
			
			return "update";
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改员工
	 */
	public String update(){
		try {
			employeeService.update(employee);
			return list();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
}
