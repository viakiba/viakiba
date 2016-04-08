package haust.vk.c_jdbc;

import java.util.List;



public class AdminDao extends BaseDao {
		public void delete(int id){
			String sql="delete from admin where id=?";
			Object[] paramsValue={id};
			super.update(sql, paramsValue);
		}
	
		// 插入
		public void save(Admin admin) {
			String sql = "insert into admin (userName,pwd) values (?,?)";
			Object[] paramsValue = {admin.getUserName(),admin.getPwd()};
			super.update(sql, paramsValue);
		}
		
		// 查询全部
		public List<Admin> getAll(){
			String sql = "select * from admin";
			List<Admin> list = super.query(sql, null, Admin.class);
			return list;
		}
		
		// 根据条件查询(主键)
		public Admin findById(int id){
			String sql = "select * from admin where id=?";
			List<Admin> list = super.query(sql, new Object[]{id}, Admin.class);
			return  (list!=null&&list.size()>0) ? list.get(0) : null;
		}
		
}
