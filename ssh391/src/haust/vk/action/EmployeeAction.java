package haust.vk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import haust.vk.dao.IEmployeeDao;
import haust.vk.entity.Dept;
import haust.vk.entity.Employee;
import haust.vk.service.IDeptService;
import haust.vk.service.IEmployeeService;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

/**
 * 员工模块控制器开发：
 * 1. 员工列表展示
 * 2. 添加员工
 * 3. 修改员工信息
 * 5. 删除
 * Created by viakiba on 2016/8/19.
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>, RequestAware{
    private Employee employee = new Employee();
    private int deptId;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getDeptId() {
        return deptId;
    }

    @Override
    public Employee getModel(){
        return employee;
    }

    /****** 二：注入员工 Service *******/
    private IEmployeeService employeeService;
    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private IDeptService deptService;

    public void setDeptService(IDeptService deptService) {
        this.deptService = deptService;
    }

    private Map<String, Object> request;
    // 接收框架运行时候传入的代表request对象的map

    @Override
    public void setRequest(Map<String, Object> request){
        this.request = request ;
    }

    /**
     * 员工展示
     */
    public String list(){
        List<Employee> listEmp = employeeService.getAll();

        request.put("listEmp",listEmp);
        return "list";
    }

    //添加员工进入添加页面
    public String viewAdd(){
        //查询部门信息保存到request
        List<Dept> listDept = deptService.getAll();
        request.put("listDept", listDept);
        return "add";
    }

    //添加员工数据
    public String save(){
        //先根据部门主键进行查询
        Dept dept = deptService.findById(deptId);
        //先设置到员工对象中
        employee.setDept(dept);

        //调用service
        employeeService.save(employee);
        return "listAction";
    }

    /**
     * 3.修改员工信息 -- 进入修改视图
     */
    public String viewUpdate(){
        //获取需要修改的几录得id
        int id = employee.getId();

        //根据主键查询
        Employee emp = employeeService.findById(id);

        //查询所有的部门
        List<Dept> listDept = deptService.getAll();

        //数据回显
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.pop();//移除栈顶元素
        vs.push(emp);//入栈

        //保存
        request.put("listDept", listDept);

        return "edit";
    }

    /**
     * 4.修改员工信息 --确认修改
     */
    public String update(){
        //1. 先根据部门id， 查询部门对象; 再设置到员工属性中
        Dept dept = deptService.findById(deptId);
        employee.setDept(dept);
        //2. 更新员工
        employeeService.update(employee);
        return "listAction";//重定向到列表
    }

    /**
     * 5.删除员工信息
     */
    public String delete(){
        //获取员工祝君安
        int empId = employee.getId();

        //调用service 删除
        employeeService.delete(empId);
        return "listAction";
    }
}
