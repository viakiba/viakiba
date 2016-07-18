package haust.vk.service;

import haust.vk.dao.DeptDao;
import haust.vk.entity.Dept;

public class DeptService {
	private DeptDao deptDao=new DeptDao();
	
	public Dept findById(int id){
		return deptDao.findById(id);
	}
}
