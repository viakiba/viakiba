package haust.vk.b_curd;

import static org.junit.Assert.*;
import haust.vk.a_hello.Employee;

import org.junit.Test;

/**
 * @author vk
 *
 * 2016年6月20日
 */
public class App {
	private EmployeeDaoImpl dao = new IEmployeeDao();
	private Employee emp = new Employee();
	@Test
	public void testSave() {
		System.out.println(emp);
		dao.save(emp);
	}

	@Test
	public void testUpdate() {
		System.out.println(emp);
		dao.update(new Employee());
	}

	@Test
	public void testFindById() {
		System.out.println(dao.findById(1));
	}

	@Test
	public void testGetAll() {
		System.out.println(dao.getAll());
	}

	@Test
	public void testGetAllString() {
		System.out.println(dao.getAll("李四"));
	}

	@Test
	public void testGetAllIntInt() {
		dao.getAll(1, 2);
	}

	@Test
	public void testDelete() {
		dao.delete(3);
	}

}
