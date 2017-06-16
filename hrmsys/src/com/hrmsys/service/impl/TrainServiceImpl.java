package com.hrmsys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.TrainBean;
import com.hrmsys.dao.TrainDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.Train;
import com.hrmsys.service.TrainService;
import com.hrmsys.util.CurrentDate;

public class TrainServiceImpl implements TrainService{
	private TrainDAO trainDAO;

	@Override
	public String list(String start, String limit) {
		PageBean pageBean = trainDAO.findAll(start, limit);
		String json = this.replace(pageBean.getRoot());
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+json+"}";
	}

	@Override
	public String queryList(TrainBean trainBean, String start, String limit) {
		PageBean pageBean = trainDAO.findAllByCondition(trainBean, start, limit);
		String json = this.replace(pageBean.getRoot());
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+json+"}";
	}
	
	@Override
	public String save(Train train) {
		if(trainDAO.save(train)){
			return StaticValue.SAVE_SUCCESS;
		}
		return StaticValue.SAVE_FAILURE;
	}

	@Override
	public String delete(String ids) {
		String[] trainIds = ids.split(",");
		if(trainDAO.delete(trainIds)){
			return StaticValue.DELETE_SUCCESS;
		}
		return StaticValue.DELETE_FAILURE;
	}

	
	public String replace(List<Train> trains){
		List<TrainBean> trainBeans= new ArrayList<TrainBean>();
		for(Train train : trains){
			TrainBean trainBean = new TrainBean();
			trainBean.setTrainId(train.getTrainId());
			trainBean.setTrainTitle(train.getTrainTitle());
			trainBean.setTrainDate(CurrentDate.getStringDate(train.getTrainDate()));
			trainBean.setTrainPerson(train.getTrainPerson());
			trainBean.setTrainPlace(train.getTrainPlace());
			trainBean.setTrainRemark(train.getTrainRemark());
			trainBean.setTrainContent(train.getTrainContent());
			trainBean.setTrainAddDate(CurrentDate.getStringDate(train.getTrainAddDate()));
			trainBean.setTrainAddPerson(train.getTrainAddPerson());
			trainBeans.add(trainBean);
		}
		String jsonTrain = JSONArray.fromObject(trainBeans).toString();
		return jsonTrain;
	}
	
	@Override
	public String getTrainById(String trainId) {
		List<Train> trains = trainDAO.findTrainById(Integer.parseInt(trainId));
		return replace(trains);
	}
	/*********setter and getter*************/
	public TrainDAO getTrainDAO() {
		return trainDAO;
	}

	public void setTrainDAO(TrainDAO trainDAO) {
		this.trainDAO = trainDAO;
	}
}
