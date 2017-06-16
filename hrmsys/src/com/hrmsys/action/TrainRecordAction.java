package com.hrmsys.action;

import com.hrmsys.bean.TrainRecordBean;
import com.hrmsys.model.TrainRecord;
import com.hrmsys.model.User;
import com.hrmsys.service.TrainRecordService;
import com.hrmsys.util.CurrentDate;

public class TrainRecordAction extends BaseAction{
	private TrainRecordService tRecordService;
	private TrainRecordBean tRecordBean;
	private TrainRecord trainRecord;
	private String empName;
	private String trainPerson;
	private String trainTitle;
	private String startDate;
	private String endDate;
	private String type;
	private String ids;
	private String start;
	private String limit;
	private String trainRecordId;
	
	public void list(){
		String jsonTRecord = null;
		//为query则为进行查询
		if("query".equals(type)){
			tRecordBean = new TrainRecordBean();
			tRecordBean.setEmpName(empName);
			tRecordBean.setTrainPerson(trainPerson);
			tRecordBean.setStartDate(startDate);
			tRecordBean.setEndDate(endDate);
			tRecordBean.setTrainTitle(trainTitle);
			jsonTRecord = tRecordService.queryList(tRecordBean, start, limit);
			this.setType(null);
		}else{
			jsonTRecord = tRecordService.list(start, limit);
		}
		this.out(jsonTRecord);
	}
	
	public void delete(){
		log.info("into delete TRecord...");
		String msg = tRecordService.delete(ids);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void save(){
		User user = (User) this.getSession().get("user");
		trainRecord.setTrecordAddPerson(user.getUserName());
		trainRecord.setTrecordAddDate(CurrentDate.getDate());
		String msg = null;
		if(null != trainRecord.getTrecordId()){
			msg = tRecordService.update(trainRecord);
		}else{
			msg = tRecordService.save(trainRecord);
		}
		this.setTrainRecord(null);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void edit(){
		String json = tRecordService.getTRecordById(trainRecordId);
		this.out(json);
	}
	
	/***setter and getter*********************/
	public TrainRecordService gettRecordService() {
		return tRecordService;
	}

	public void settRecordService(TrainRecordService tRecordService) {
		this.tRecordService = tRecordService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public TrainRecordBean gettRecordBean() {
		return tRecordBean;
	}

	public void settRecordBean(TrainRecordBean tRecordBean) {
		this.tRecordBean = tRecordBean;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTrainPerson() {
		return trainPerson;
	}

	public void setTrainPerson(String trainPerson) {
		this.trainPerson = trainPerson;
	}

	public String getTrainTitle() {
		return trainTitle;
	}

	public void setTrainTitle(String trainTitle) {
		this.trainTitle = trainTitle;
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

	public TrainRecord getTrainRecord() {
		return trainRecord;
	}

	public void setTrainRecord(TrainRecord trainRecord) {
		this.trainRecord = trainRecord;
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

	public String getTrainRecordId() {
		return trainRecordId;
	}

	public void setTrainRecordId(String trainRecordId) {
		this.trainRecordId = trainRecordId;
	}
}
