package com.hrmsys.action;

import com.hrmsys.bean.EncouragePunishBean;
import com.hrmsys.model.EncouragePunish;
import com.hrmsys.model.User;
import com.hrmsys.service.EncouragePunishService;
import com.hrmsys.util.ConditionValidate;
import com.hrmsys.util.CurrentDate;

public class EncouragePunishAction extends BaseAction{
	private EncouragePunishService ePunishService;
	private EncouragePunishBean epunishBean; 
	private EncouragePunish epunish;
	private String ids;
	private String empIdOrName;
	private String empValue;
	private String epTitle;
	private String epType;
	private String type;
	private String start;
	private String limit;
	private String epId;
	
	public void list(){
		String ePunishJson = null;
		if("query".equals(type)){
			epunishBean = new EncouragePunishBean();
			if(ConditionValidate.isEmpty(empIdOrName)){
				if(empIdOrName.equals("empName")){
					epunishBean.setEmpName(empValue);
				}else if(empIdOrName.equals("empId")){
					epunishBean.setEmpId(empValue);
				}
			}
			epunishBean.setEpTitle(epTitle);
			epunishBean.setEpType(epType);
			ePunishJson = ePunishService.listByCondition(epunishBean, start, limit);
			this.setEpType(null);
		}else{
			ePunishJson = ePunishService.list(start, limit);
		}
		this.out(ePunishJson);
	}
	
	public void delete(){
		String msg = ePunishService.delete(ids);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void save(){
		String msg = null;
		if(null != epunish.getEpId()){
			msg = ePunishService.update(epunish);
		}else{
			User user = (User) this.getSession().get("user");
			epunish.setEpReleasePerson(user.getUserName());
			epunish.setEpReleaseDate(CurrentDate.getDate());
			msg = ePunishService.save(epunish);
		}
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void edit(){
		String json = ePunishService.getEPunishById(epId);
		this.out(json);
	}
	
	public EncouragePunishService getePunishService() {
		return ePunishService;
	}

	public void setePunishService(EncouragePunishService ePunishService) {
		this.ePunishService = ePunishService;
	}

	public String getEmpIdOrName() {
		return empIdOrName;
	}

	public void setEmpIdOrName(String empIdOrName) {
		this.empIdOrName = empIdOrName;
	}

	public String getEmpValue() {
		return empValue;
	}

	public void setEmpValue(String empValue) {
		this.empValue = empValue;
	}

	public String getEpTitle() {
		return epTitle;
	}

	public void setEpTitle(String epTitle) {
		this.epTitle = epTitle;
	}

	public String getEpType() {
		return epType;
	}

	public void setEpType(String epType) {
		this.epType = epType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getEpId() {
		return epId;
	}

	public void setEpId(String epId) {
		this.epId = epId;
	}

	public EncouragePunishBean getEpunishBean() {
		return epunishBean;
	}

	public void setEpunishBean(EncouragePunishBean epunishBean) {
		this.epunishBean = epunishBean;
	}

	public EncouragePunish getEpunish() {
		return epunish;
	}

	public void setEpunish(EncouragePunish epunish) {
		this.epunish = epunish;
	}
}
