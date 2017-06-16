package com.hrmsys.action;

import com.hrmsys.service.BoonService;

public class BoonAction extends BaseAction{
	private BoonService boonService;
	private String ids;
	private String json;
	private String start;
	private String limit;

	public void edit(){
		String boonJson = boonService.list(start, limit);
		this.out(boonJson);
	}
	
	public void delete(){
		String msg = boonService.delete(ids);
		this.out("{success: true, msg:'"+msg+"'}");
	}
	
	public void modify(){
		String msg = boonService.modify(json);
		this.setJson("");
		this.out("{success: true, msg:'"+msg+"'}");
	}
	
	public BoonService getBoonService() {
		return boonService;
	}

	public void setBoonService(BoonService boonService) {
		this.boonService = boonService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
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
