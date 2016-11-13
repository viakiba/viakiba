package haust.vk.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import haust.vk.dao.EmpDao;
import haust.vk.entity.Emp;

@Component("empService")
public class EmpService {
	private EmpDao empDao;
	@Resource(name="empDao")
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	public List<Emp> findAllEmp() throws Exception{
		return empDao.findAll();
	}
	
}
