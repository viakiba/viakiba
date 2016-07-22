package haust.vk.b_anno;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void save(Dept dept){
		String sql="insert into t_dept (deptName) values(?) ";
		jdbcTemplate.update(sql,dept.getDeptName());
	}
}
