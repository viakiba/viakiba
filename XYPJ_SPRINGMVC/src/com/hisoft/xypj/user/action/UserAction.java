package com.hisoft.xypj.user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hisoft.xypj.common.bean.DataTablesReply;
import com.hisoft.xypj.common.bean.PageInfo;
import com.hisoft.xypj.common.bean.UserInfo;
import com.hisoft.xypj.login.service.UserInfoService;
import com.hisoft.xypj.tool.ControlUtil;
import com.hisoft.xypj.tool.HelpFunctions;

@Controller
@RequestMapping(value = "/user")
public class UserAction {
	
	@Autowired
	private UserInfoService infoService;

    @RequestMapping("/main")
    public String getMain(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
    	model.addAttribute("name", "111111111111");
        return "main/main";
    }
    
    @RequestMapping("/toUserList")
    public String toUserList(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
        return "user/list";
    }
    
    @RequestMapping("/getUserList")
    public void getUserList(HttpServletRequest request, HttpServletResponse response,
    		ModelMap model,UserInfo user,String userName) {
    	
    	PageInfo pageInfo = PageInfo.newInstance(request);

		HelpFunctions.initPageInfoStartEnd(pageInfo);

		List<UserInfo> list = infoService.getPingShenList();
		
		DataTablesReply<UserInfo> dataTablesReply = new DataTablesReply<UserInfo>();
		dataTablesReply.setData(list);
		dataTablesReply.setDraw(pageInfo.getDraw());
		dataTablesReply.setRecordsFiltered(100);
		dataTablesReply.setRecordsTotal(100);
		String json = ControlUtil.toJsonStr(dataTablesReply);
		ControlUtil.writeJsonData(response, json);
    }
    
    @RequestMapping("/toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
        return "user/add";
    }
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/userSave.do")
	public void userSave(HttpServletRequest request, HttpServletResponse response,UserInfo user,
			ModelMap model){
	    	Map map = new HashMap();
		try{
			infoService.addUserInfo(user);
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
