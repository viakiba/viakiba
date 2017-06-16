package com.hrmsys.action;

import java.util.Date;

import com.hrmsys.bean.RecruitmentBean;
import com.hrmsys.model.Recruitment;
import com.hrmsys.model.User;
import com.hrmsys.service.RecruitmentService;
import com.hrmsys.util.CurrentDate;

public class RecruitmentAction extends BaseAction{
	private RecruitmentService recruitmentService;
	private Recruitment recruitment;
	private String recId;
	private String ids;
	private RecruitmentBean recBean;
	private String recTitle;
	private String recJob;
	private String startDate;
	private String endDate;
	private String type;
	private String start;
	private String limit;
	
	public void list(){
		String recJson = null;
		if("query".equals(type)){
			recBean = new RecruitmentBean();
			recBean.setEndDate(endDate);
			recBean.setRecJob(recJob);
			recBean.setRecTitle(recTitle);
			recBean.setStartDate(startDate);
			recJson = recruitmentService.getByCondition(recBean, start, limit);
		}else{
			recJson = recruitmentService.list(start, limit);
		}
		this.out(recJson);
	}
	
	public void save(){
		User user = (User) this.getSession().get("user");
		recruitment.setRecPerson(user.getEmployee().getEmpName());
		recruitment.setRecDate(CurrentDate.getDate());
		String msg = recruitmentService.save(recruitment);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void intoUpdate(){
		String recJson = recruitmentService.getListByRecId(recId);
		this.setRecId(null);
		this.out(recJson);
	}
	
	
	public void delete(){
		String msg = recruitmentService.delete(ids);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public RecruitmentService getRecruitmentService() {
		return recruitmentService;
	}
	public void setRecruitmentService(RecruitmentService recruitmentService) {
		this.recruitmentService = recruitmentService;
	}
	public Recruitment getRecruitment() {
		return recruitment;
	}
	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}

	public String getRecId() {
		return recId;
	}

	public void setRecId(String recId) {
		this.recId = recId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public RecruitmentBean getRecBean() {
		return recBean;
	}

	public void setRecBean(RecruitmentBean recBean) {
		this.recBean = recBean;
	}

	public String getRecTitle() {
		return recTitle;
	}

	public void setRecTitle(String recTitle) {
		this.recTitle = recTitle;
	}

	public String getRecJob() {
		return recJob;
	}

	public void setRecJob(String recJob) {
		this.recJob = recJob;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
}
