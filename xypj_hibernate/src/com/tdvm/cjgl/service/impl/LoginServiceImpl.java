package com.tdvm.cjgl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdvm.base.UpdateConst;
import com.tdvm.cjgl.bean.UserBean;
import com.tdvm.cjgl.dao.LoginDao;
import com.tdvm.cjgl.entity.BaseUser;
import com.tdvm.cjgl.service.LoginService;
import com.tdvm.tool.HelpFunctions;


/**
 * 登录业务处理�?
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Transactional
	public UserBean checkUserInfo(UserBean userBean) {

		UserBean ub = new UserBean();

		try {
			String password = HelpFunctions.getStringMD5(userBean.getPassword());
			userBean.setPassword(password);
			List<BaseUser> list = loginDao.checkUserInfo(userBean);

			if (!HelpFunctions.isEmpty(list)) {
				BaseUser ui = list.get(0);
				BeanUtils.copyProperties(ui, ub);
				ub.setState(UpdateConst.RESULT_BEAN_STATE_PASS);
//				ui.setLastLoginTime(new Date());
//				loginDao.update(ui);
			} else {
				ub.setData("用户名密码验证失败");
			}
		} catch (Exception e) {
			ub.setData("用户名密码验证失败");
		}

		return ub;
	}
}
