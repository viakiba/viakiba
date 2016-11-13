package haust.vk.dao;

import haust.vk.entity.Emp;
import haust.vk.util.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Component;

/**
 * 员工管理模块
 * 持久层的实现类
 * @author viakiba
 *
 */
@Component("empDao")
public class EmpDao {
	/**
	 * 获取所有成员
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> findAll() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		List<Emp> query = queryRunner.query("SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP", new BeanListHandler<Emp>(Emp.class));
		return query;
	}
	
	/**
	 * 测试
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		EmpDao dao = new EmpDao();
		for(Emp emp : dao.findAll()){
			System.out.println(emp);
		}
	}
}
