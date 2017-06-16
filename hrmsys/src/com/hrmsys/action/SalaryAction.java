package com.hrmsys.action;

import java.util.Date;
import java.util.List;

import com.hrmsys.bean.SalaryBean;
import com.hrmsys.model.Salary;
import com.hrmsys.model.User;
import com.hrmsys.service.SalaryService;
import com.hrmsys.util.ConditionValidate;
import com.hrmsys.util.CurrentDate;

public class SalaryAction extends BaseAction{
	private SalaryService salaryService;
	private String empId;
	private Salary salary;
	private SalaryBean salBean;
	private String condition;
	private String conditionValue;
	private String type;
	private String salMonth;
	private String salId;
	private List<SalaryBean> salBeans;
	//未交税的总工资 
	private String allMoney;
	private String start;
	private String limit;
	private String year;
	private String month;
	private String ids;
	/**
	 * 当输入员工号时提取部分数据
	 */
	public void distill(){
		String salaryJson = salaryService.distill(empId);
		this.out(salaryJson);
	}
	public void delete(){
		String msg = salaryService.delete(this.getIds());
		this.out("{success: true, msg: '"+msg+"'}");
	}
	/**
	 * 计算总工资
	 * @return
	 */
	public void caculate(){
		float revenueMoney = salaryService.caculate(allMoney);
		float giveMoney = Float.parseFloat(allMoney) - revenueMoney;
		this.out("{success: true, revenueMoney:'"+revenueMoney+"',giveMoney: '"+giveMoney+"'}");
	}
	
	public void save(){
		User user = (User) this.getSession().get("user");
		String addPerson = user.getEmployee().getEmpName();
		Date addDate = CurrentDate.getDateAndTime();
		salary.setSalReleasePerson(addPerson);
		salary.setSalReleaseDate(addDate);
		salary.setSalYear(CurrentDate.getStringDate().substring(0,4));
		String msg = salaryService.save(salary);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void list(){
		String salaryJson = null;
		if("query".equals(type)){
			salBean = new SalaryBean();
			if("empName".equals(condition)){
				salBean.setEmpName(conditionValue);
			}
			if("empId".equals(condition)){
				salBean.setEmpId(conditionValue);
			}
			if(ConditionValidate.isEmpty(salMonth)){
				salBean.setSalMonth(Integer.parseInt(salMonth));
			}
			salaryJson = salaryService.getListByCondition(salBean, start, limit);
			this.setType(null);
		}else{
			salaryJson  = salaryService.list(start, limit);
		}
		this.out(salaryJson);
	}
	
	public void intoUpdate(){
		String salJson = salaryService.getSalById(salId);
		this.out(salJson);
	}
	
	public String view(){
		salBeans = salaryService.getSalary(empId, year, month);
		return "salView";
	}
	
	public void unique(){
		boolean msg = salaryService.unique(empId, CurrentDate.getStringDate().substring(0,4), month);
		this.out("{success: true, msg: "+msg+"}");
	}
	
	public void export(){
		salaryService.export(this.getResponse(), empId, year, month);
	}
	
	public SalaryService getSalaryService() {
		return salaryService;
	}

	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getConditionValue() {
		return conditionValue;
	}
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSalMonth() {
		return salMonth;
	}
	public void setSalMonth(String salMonth) {
		this.salMonth = salMonth;
	}
	public SalaryBean getSalBean() {
		return salBean;
	}
	public void setSalBean(SalaryBean salBean) {
		this.salBean = salBean;
	}
	public String getSalId() {
		return salId;
	}
	public void setSalId(String salId) {
		this.salId = salId;
	}
	public List<SalaryBean> getSalBeans() {
		return salBeans;
	}
	public void setSalBeans(List<SalaryBean> salBeans) {
		this.salBeans = salBeans;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
}
