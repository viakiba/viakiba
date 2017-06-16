package com.hrmsys.dao.impl;
/**
 * @author sux
 * @time 2011-1-11
 */
import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.UserBean;
import com.hrmsys.dao.UserDAO;
import com.hrmsys.model.User;
import com.hrmsys.util.ConditionValidate;

public class UserDAOImpl extends BaseDAO implements UserDAO{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByUsernameAndPassword(String username, String password) {
		log.info("start findByUsernaemAndPassword");
		String hql = "FROM User WHERE userName = ? AND userPwd= ? ";
		return this.findByHQLAndValue(hql, username, password);
	}

	@Override
	public PageBean findAll(String start, String limit) {
		log.info("find all user");
		String hql = "FROM User";
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql, Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findTotal(User.class));
		return pageBean;
	}

	@Override
	public PageBean findByCondition(UserBean userBean, String start, String limit) {
		StringBuffer sb = new StringBuffer("FROM User WHERE 1 = 1 ");
		if(ConditionValidate.isEmpty(userBean.getEmpName())){
			sb.append(" AND employee.empName = '"+userBean.getEmpName()+"'");
		}
		if(ConditionValidate.isEmpty(userBean.getUserName())){
			sb.append(" AND userName = '"+userBean.getUserName()+"'");
		}
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(sb.toString(), Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findByHQL(sb.toString()).size());
		return pageBean;
	}

	@Override
	public boolean deleteByIds(String[] userIds) {
		boolean flag = true;
		for(String userId : userIds){
			if(!this.deleteById(User.class, Integer.parseInt(userId))){
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public boolean saveOrUpdate(User user) {
		if(super.saveOrUpdate(user)) return true;
		return false;
	}

	@Override
	public List<User> findById(int userId) {
		return this.findByProperty(User.class, "userId", userId);
	}

	@Override
	public boolean update(User user) {
		List<User> users = this.findById(user.getUserId());
		if(users.size() < 0) return false;
		User newUser = users.get(0);
		if(user.getRole() == null) return true; //没有修改
		newUser.setRole(user.getRole());
		return super.update(newUser);
	}

	@Override
	public void deleteByRole(Integer roleId) {
		String hql = "from User where role.roleId = ?";
		List<User> users = super.findByHQLAndValue(hql, roleId);
		for(User user: users){
			super.delete(user);
		}
	}

}