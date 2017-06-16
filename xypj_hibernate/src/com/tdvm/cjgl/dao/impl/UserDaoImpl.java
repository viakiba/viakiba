package com.tdvm.cjgl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tdvm.bean.PageInfo;
import com.tdvm.cjgl.bean.UserBean;
import com.tdvm.cjgl.dao.UserDao;
import com.tdvm.cjgl.entity.BaseUser;
import com.tdvm.common.dao.impl.CommonDaoImpl;
import com.tdvm.tool.HelpFunctions;

@Repository
public class UserDaoImpl extends CommonDaoImpl implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBean> getUserList(UserBean userBean, PageInfo pageInfo) {

		StringBuilder hql = new StringBuilder("from BaseUser where 1=1 ");
		List<String> params = new ArrayList<String>();

		if (!HelpFunctions.isEmpty(userBean.getUserName())) {
			hql.append(" and username =? ");
			params.add(userBean.getUserName());
		}
		List<UserBean> list = ((List<UserBean>) getListByHQL(hql.toString(),params.toArray(), pageInfo));
            
		return list;
	}
	
	public BaseUser getUserById(String id) {
		return (BaseUser)getObjectById(BaseUser.class, id);
	}

}
