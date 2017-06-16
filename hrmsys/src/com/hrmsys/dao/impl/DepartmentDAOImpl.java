package com.hrmsys.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.DepartmentDAO;
import com.hrmsys.model.Department;
import com.hrmsys.util.ConditionValidate;

public class DepartmentDAOImpl extends BaseDAO implements DepartmentDAO{
	private static final Log log = LogFactory.getLog(DepartmentDAOImpl.class);
	// property constants
	public static final String DEPT_NAME = "deptName";
	public static final String DEPT_REMARK = "deptRemark";

	protected void initDao() {
		// do nothing
	}

	@Override
	public List<Department> findAllDept(String start, String limit) {
		String 	hql = "FROM Department";
		return this.page(hql, Integer.parseInt(start), Integer.parseInt(limit));
	}

	@Override
	public boolean save(Department dept) {
		if(super.save(dept)) return true;
		return false;
	}

	@Override
	public boolean delete(String[] deptIds) {
		boolean flag = true;
		for(String deptId: deptIds){
			if(!super.deleteById(Department.class, deptId)) flag = false;
		}
		return flag;
	}

	@Override
	public PageBean findDeptByCondition(String condition,
			String conditionValue, int start, int limit) {
		StringBuffer hql = new StringBuffer("FROM Department WHERE 1=1");
		if(ConditionValidate.isEmpty(conditionValue) && ConditionValidate.isEmpty(condition)){
			hql.append(" and "+condition+" = '" + conditionValue+"'");
		}
		PageBean pageBean = new PageBean();
		pageBean.setRoot(page(hql.toString(), start, limit));
		pageBean.setTotalProperty(this.findByHQL(hql.toString()).size());
		return pageBean;
	}

	@Override
	public boolean saveOrUpdate(Department dept) {
		if(super.saveOrUpdate(dept)) return true;
		return false;
	}

	@Override
	public List<Department> findById(String deptId) {
		return super.findByProperty(Department.class, "deptId", deptId);
	}

//	@Override
//	public List<Department> findDeptByCondition(DepartmentBean deptBean) {
//		StringBuffer hql = new StringBuffer("FROM Department WHERE 1=1");
//		if(ConditionValidate.isEmpty(deptBean.getDeptId())){
//			hql.append("and DeptId = " + deptBean.getDeptId());
//		}
//		if(ConditionValidate.isEmpty(deptBean.getDeptName())){
//			hql.append("and DeptName = " + deptBean.getDeptName());
//		}
//		if(ConditionValidate.isEmpty(deptBean.getDeptMgr())){
//			hql.append("and DeptMgr = "+ deptBean.getDeptMgr());
//		}
//		return super.findByHQL(hql.toString());
//	}
	
}