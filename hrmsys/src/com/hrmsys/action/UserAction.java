package com.hrmsys.action;
/**
 * @author sux
 * @date 2011-01-09
 */
import java.util.List;

import javax.servlet.http.HttpSession;

import com.hrmsys.bean.UserBean;
import com.hrmsys.model.User;
import com.hrmsys.service.UserService;
import com.hrmsys.util.ConditionValidate;
import com.hrmsys.util.CurrentDate;
import com.hrmsys.util.MD5;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction{
	private UserService userService;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 验证码
	 */
	private String validateCode;
	private String condition;
	private String conditionValue;
	private UserBean userBean;
	private String ids;
	private User user;
	private String userId;
	private String start;
	private String limit;
	private String oldPassword;
	
	public String login(){
		String validateCode2 = (String)ActionContext.getContext().getSession().get("validateCode");
		List<User> users = userService.validateUser(username.trim(),new MD5().complie(password.trim()));
		
		if(users.size()>0){
			if(!validateCode.trim().equalsIgnoreCase(validateCode2.trim())){
				this.addActionMessage("验证码不正确");
				return INPUT;
			}
		}else{
			this.addActionMessage("用户名或密码错误");
			return INPUT;
		}
		ActionContext.getContext().getSession().put("user", users.get(0));
		log.info(users.get(0).getUserName() + "login sucess!");
		userService.updateIPAndTimeById(users.get(0).getUserId(), this.getRequest().getRemoteAddr(), 
				CurrentDate.getStringDateAndTime());
		return SUCCESS;
	}
	
	public String exit(){
		User user = (User) this.getSession().get("user");
		if(null != user)
		log.info(user.getUserName() + " exited!");
		this.getSession().clear();
		return "exit";
	}
	
	public void list(){
		String userJson = null;
		if(ConditionValidate.isEmpty(condition)){
			userBean = new UserBean();
			if("userName".equals(condition)){
				userBean.setUserName(conditionValue);
			}
			if("empName".equals(condition)){
				userBean.setEmpName(conditionValue);
			}
			userJson = userService.getUserByCondition(userBean, start, limit);
		}else{
			userJson = userService.list(start, limit);
		}
		this.out(userJson);
	}
	
	public void delete(){
		String msg = userService.deleteByIds(ids);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void save(){
		user.setUserPwd(new MD5().complie(user.getEmployee().getEmpId()));//默认密码为工号
		user.setUserDate(CurrentDate.getDate());
		String msg = userService.save(user);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void updateRole(){
		String msg = userService.update(user);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void intoUpdate(){
		String userJson = userService.getById(userId);
		this.out(userJson);
	}
	
	public void updatePwd(){
		User oldUser = (User)this.getSession().get("user");
		oldUser.setUserName(user.getUserName());
		oldUser.setUserPwd(new MD5().complie(user.getUserPwd()));
		String msg = userService.save(oldUser);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	public void validatePwd(){
		User user = (User) this.getSession().get("user");
		boolean msg = false;
		if(new MD5().complie(oldPassword).equals(user.getUserPwd())){
			msg = true;
		}
		this.out("{success: true, msg: "+msg+"}");
	}
	/**follow is getter and setter method**/
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getConditionValue() {
		return conditionValue;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
}
