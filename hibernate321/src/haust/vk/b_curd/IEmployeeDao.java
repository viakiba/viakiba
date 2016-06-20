package haust.vk.b_curd;

import haust.vk.a_hello.Employee;
import haust.vk.utils.HibernateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author vk
 *
 * 2016年6月19日
 */
public class IEmployeeDao implements EmployeeDaoImpl{

	@Override
	public void save(Employee emp) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			session.save(emp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
		
		
	}

	@Override
	public void update(Employee emp) {
		Session session = null;
		Transaction tx =  null; 
		try {
			session=HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			session.update(emp);
		} catch (Exception e) {

			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public Employee findById(Serializable id) {
		Session session = null;
		Transaction tx =  null;
		
		try {
			session = HibernateUtils.getSession();
			tx=session.beginTransaction();
			return (Employee) session.get(Employee.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public List<Employee> getAll() {
		Session session = null;
		Transaction tx =  null;
		
		try {
			session = HibernateUtils.getSession();
			tx=session.beginTransaction();
			Query q = session.createQuery("from Employee");
			
			return q.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public List<Employee> getAll(String employeeName) {
		Session session = null;
		Transaction tx =  null;
		
		try {
			session = HibernateUtils.getSession();
			tx=session.beginTransaction();
			Query q = session.createQuery("from Employee where empName=?");
			q.setParameter(0, employeeName);
			return q.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public List<Employee> getAll(int index, int count) {
		Session session = null;
		Transaction tx =  null;
		
		try {
			session = HibernateUtils.getSession();
			tx=session.beginTransaction();
			Query q = session.createQuery("from employee");
			q.setFirstResult(index);
			q.setMaxResults(count);
			List<Employee> list = q.list();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public void delete(Serializable id) {
		Session session = null;
		Transaction tx =  null;
		
		try {
			session = HibernateUtils.getSession();
			tx=session.beginTransaction();
		//
			Object obj = session.get(Employee.class, id);
			if(obj != null){
				session.delete(obj);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}
	
}
