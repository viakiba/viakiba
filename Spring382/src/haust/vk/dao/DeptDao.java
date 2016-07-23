package haust.vk.dao;

import haust.vk.entity.Dept;

import org.hibernate.SessionFactory;

//数据访问层
public class DeptDao {
	private SessionFactory sessionFactory;
	// Spring与Hibernate整合： IOC容器注入
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	// 保存一个记录
	// Spring与Hibernate整合：事务管理交给Spring
	public void save(Dept dept) {
		sessionFactory.getCurrentSession().save(dept);
	}
}
