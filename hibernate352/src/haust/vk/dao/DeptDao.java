package haust.vk.dao;

import haust.vk.entity.Dept;
import haust.vk.utils.HibernateUtils;

public class DeptDao {
	/*
	 * Ö÷¼ü²éÑ¯
	 */
	public Dept findById(int id){
		return (Dept) HibernateUtils.getSf().get(Dept.class, id);
	}
}
