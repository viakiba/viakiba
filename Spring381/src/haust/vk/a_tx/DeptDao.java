package haust.vk.a_tx;

import org.springframework.jdbc.core.JdbcTemplate;

public class DeptDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void save(Dept dept){
		String sql="insert into t_dept (deptName) values(?) ";
		jdbcTemplate.update(sql,dept.getDeptName());
	}
}
