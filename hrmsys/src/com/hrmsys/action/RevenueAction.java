package com.hrmsys.action;

import com.hrmsys.service.RevenueService;

public class RevenueAction extends BaseAction{
	private RevenueService revenueService;
	private String ids; 
	private String json;
	private String start;
	private String limit;
	
	public void edit(){
		String revernueJson = revenueService.list(start, limit);
		this.out(revernueJson);
	}
	
	public void delete(){
		String msg = revenueService.delete(ids);
		this.out("{success: true, msg:'"+msg+"'}");
	}
	
	public void modify(){
		String msg = revenueService.modify(json);
		this.setJson("");
		this.out("{success: true, msg:'"+msg+"'}");
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public RevenueService getRevenueService() {
		return revenueService;
	}

	public void setRevenueService(RevenueService revenueService) {
		this.revenueService = revenueService;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
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
