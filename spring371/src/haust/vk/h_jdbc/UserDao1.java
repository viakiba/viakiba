package haust.vk.h_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDao1 {
	// IOC容器注入
	//	private DataSource dataSource;
	//	public void setDataSource(DataSource dataSource) {
	//		this.dataSource = dataSource;
	//	}
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void save() {
		String sql="insert into t_dept(deptName) values('test');";
		jdbcTemplate.update(sql);
	}
	
	public Dept findById(int id){
		String sql = "select * from t_dept where deptId=?";
		List<Dept> list = jdbcTemplate.query(sql,new MyResult(), id);
		return (list!=null && list.size()>0) ? list.get(0) : null;
	}
	
	public List<Dept> getAll() {
		String sql = "select * from t_dept";
		List<Dept> list = jdbcTemplate.query(sql, new MyResult());
		return list;
	}
	
	class MyResult implements RowMapper<Dept>{

		// 如何封装一行记录
		@Override
		public Dept mapRow(ResultSet rs, int index) throws SQLException {
			Dept dept = new Dept();
			dept.setDeptId(rs.getInt("deptId"));
			dept.setDeptName(rs.getString("deptName"));
			return dept;
		}
		
	}
}
