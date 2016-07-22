package haust.vk.a_tx;

public class DeptService {
	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	/**
	 * 事务控制
	 */
	public void save(Dept dept) {
		//第一次调用
		deptDao.save(dept);
		
		//int i = 1/0;
		
		//第二次调用
		deptDao.save(dept);
	}
}
