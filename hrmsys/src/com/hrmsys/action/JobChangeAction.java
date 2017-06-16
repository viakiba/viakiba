package com.hrmsys.action;

import com.hrmsys.model.JobChange;
import com.hrmsys.model.User;
import com.hrmsys.service.JobChangeService;
import com.hrmsys.util.ConditionValidate;
import com.hrmsys.util.CurrentDate;

public class JobChangeAction extends BaseAction{
	private JobChangeService jobChangeService;
	private JobChange jobChange;
	private String ids;
	private String start;
	private String limit;
	private int jcId;
	private String condition;
	private String conditionValue;
	/**
	 * 员工调动信息查询
	 */
	public void list(){
		String json = null;
		if(ConditionValidate.isEmpty(condition) && ConditionValidate.isEmpty(conditionValue)){
			json = jobChangeService.getAllJobChange(condition, conditionValue, start, limit);
			this.setCondition(null);
			this.setConditionValue(null);
		}else{
			json = jobChangeService.getAllJobChange(start, limit);
		}
		this.out(json);
	}
	
	public void save(){
		String msg = null;
		User user = (User) this.getSession().get("user");
		jobChange.setJcAddPerson(user.getUserName());
		jobChange.setJcDate(CurrentDate.getDate());
		if(jobChange.getJcId() == null){
			//添加人与添加时间
			 msg = jobChangeService.save(jobChange);
		}else{
			msg = jobChangeService.update(jobChange);
		}
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void delete(){
		String msg = jobChangeService.delete(ids);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void edit(){
		String json = jobChangeService.getJobChangeById(jcId);
		this.out(json);
	}
	
	
	public JobChangeService getJobChangeService() {
		return jobChangeService;
	}
	public void setJobChangeService(JobChangeService jobChangeService) {
		this.jobChangeService = jobChangeService;
	}
	public JobChange getJobChange() {
		return jobChange;
	}
	public void setJobChange(JobChange jobChange) {
		this.jobChange = jobChange;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
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
	public int getJcId() {
		return jcId;
	}
	public void setJcId(int jcId) {
		this.jcId = jcId;
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
	
}
