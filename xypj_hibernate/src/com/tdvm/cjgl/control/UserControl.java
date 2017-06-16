package com.tdvm.cjgl.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tdvm.bean.DataTablesReply;
import com.tdvm.bean.PageInfo;
import com.tdvm.cjgl.bean.UserBean;
import com.tdvm.cjgl.entity.BaseUser;
import com.tdvm.cjgl.service.UserService;
import com.tdvm.tool.ControlUtil;
import com.tdvm.tool.HelpFunctions;

@Controller
@Scope("session")
public class UserControl {
	private static final Logger log = LoggerFactory.getLogger(LoginControl.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/toList.do")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "user/list";
	}
	@RequestMapping("/user/toAdd.do")
	public String toAdd(HttpServletRequest request, HttpServletResponse response) {
		return "user/add";
	}
	@RequestMapping("/user/getUserList.do")
	public void getListControlPerson(HttpServletRequest request, HttpServletResponse response, UserBean userBean,
			ModelMap model) {

		PageInfo pageInfo = PageInfo.newInstance(request);
		log.debug("获取用户信息");
		log.debug("query:" + ControlUtil.toJsonStr(userBean));

		HelpFunctions.initPageInfoStartEnd(pageInfo);

		List<UserBean> list = userService.getUserList(userBean, pageInfo);
		
		DataTablesReply<UserBean> dataTablesReply = new DataTablesReply<UserBean>();
		dataTablesReply.setData(list);
		dataTablesReply.setDraw(pageInfo.getDraw());
		dataTablesReply.setRecordsFiltered(pageInfo.getTotolPage());
		dataTablesReply.setRecordsTotal(pageInfo.getTotolPage());
		String json = ControlUtil.toJsonStr(dataTablesReply);
		log.debug("json:" + json);
		ControlUtil.writeJsonData(response, json);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/user/save.do")
	public void userSave(HttpServletRequest request, HttpServletResponse response,BaseUser user,
			ModelMap model){
	    	Map map = new HashMap();
		try{ 
			userService.insertUser(user);
		    map.put("success", Boolean.valueOf(true));
		    map.put("message", "保存成功");
			ControlUtil.writeJsonData(response, ControlUtil.toJsonStr(map));
		} catch (Exception e) {
			e.getMessage();
			map.put("message", "保存失败");
			ControlUtil.writeJsonData(response, ControlUtil.toJsonStr(map));
		}
	}

	
}
