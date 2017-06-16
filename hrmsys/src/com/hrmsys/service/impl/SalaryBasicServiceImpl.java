package com.hrmsys.service.impl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.SalaryBasicBean;
import com.hrmsys.dao.SalaryBasicDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.Employee;
import com.hrmsys.model.SalaryBasic;
import com.hrmsys.service.SalaryBasicService;

public class SalaryBasicServiceImpl implements SalaryBasicService{
	private SalaryBasicDAO salaryBasicDAO;
	
	@Override
	public String list(String start, String limit) {
		PageBean pageBean = salaryBasicDAO.findAll(start, limit);
		String sbJson = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+sbJson+"}";
	}

	@Override
	public String getListByCondition(SalaryBasicBean salBasicBean, String start, String limit) {
		PageBean pageBean = salaryBasicDAO.findByCondition(salBasicBean, start, limit);
		String sbJson = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+sbJson+"}";
	}

	@Override
	public String delete(String ids) {
		String[] sbIds = ids.split(",");
		if(salaryBasicDAO.deleteById(sbIds)){
			return StaticValue.DELETE_SUCCESS;
		}
		return StaticValue.DELETE_FAILURE;
	}
	
	@Override
	public String saveOrUpdate(String json) {
		boolean flag = true;
		JSONArray jsonArray = JSONArray.fromObject(json);
		for(int i = 0; i < jsonArray.size(); i++){
			JSONObject obj = jsonArray.getJSONObject(i);
			SalaryBasic salBasic = new SalaryBasic();
			salBasic.setSbId(obj.getInt("sbId"));
			salBasic.setSbBasic((float)obj.getInt("sbBasic"));
			Employee employee = new Employee();
			employee.setEmpId(obj.getString("empId"));
			//employee.setEmpName(obj.getString("empName"));
			salBasic.setEmployee(employee);
			salBasic.setSbEatery((float)obj.getInt("sbEatery"));
			salBasic.setSbEndowment(obj.getInt("sbEndowment"));
			salBasic.setSbHospitalization(obj.getInt("sbHospitalization"));
			salBasic.setSbHousing(obj.getInt("sbHousing"));
			salBasic.setSbInjury(obj.getInt("sbInjury"));
			salBasic.setSbMaternity(obj.getInt("sbMaternity"));
			salBasic.setSbTelephone((float)obj.getInt("sbTelephone"));
			salBasic.setSbTraffic((float)obj.getInt("sbTraffic"));
			salBasic.setSbUnemployment(obj.getInt("sbUnemployment"));
			if(null != salBasic.getSbId()){
				if(!salaryBasicDAO.update(salBasic)){
					flag = false;
				}
			}else{
				if(!salaryBasicDAO.save(salBasic)){
					flag = false;
				}
			}
		}
		if(flag){
			return StaticValue.UPDATE_SUCCESS;
		}
		return StaticValue.UPDATE_FAILURE;
	}

	@Override
	public boolean uniqueEmp(String empId) {
		if(salaryBasicDAO.uniqueEmp(empId)){
			return true;
		}
		return false;
	}
	
	public SalaryBasicDAO getSalaryBasicDAO() {
		return salaryBasicDAO;
	}

	public void setSalaryBasicDAO(SalaryBasicDAO salaryBasicDAO) {
		this.salaryBasicDAO = salaryBasicDAO;
	}

}
