package haust.vk.dao;

import java.io.Serializable;

import haust.vk.entity.Employee;

import org.hibernate.SessionFactory;

public class EmployeeDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * ≤È—Ø
	 */
	public Employee findById(Serializable id){
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}
}
