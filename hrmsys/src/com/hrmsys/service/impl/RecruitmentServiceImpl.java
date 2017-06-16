package com.hrmsys.service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.RecruitmentBean;
import com.hrmsys.dao.RecruitmentDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.Recruitment;
import com.hrmsys.service.RecruitmentService;

public class RecruitmentServiceImpl implements RecruitmentService{
	private RecruitmentDAO recruitmentDAO;

	@Override
	public String save(Recruitment recruitment) {
		if(recruitmentDAO.saveOrUpdate(recruitment)){
			return StaticValue.SAVE_SUCCESS;
		}
		return StaticValue.SAVE_FAILURE;
	}

	@Override
	public String list(String start, String limit) {
		PageBean pageBean = recruitmentDAO.findAll(start, limit);
		String json = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+json+"}";
	}
	
	@Override
	public String getListByRecId(String recId) {
		List<Recruitment> recs = recruitmentDAO.findById(Integer.parseInt(recId));
		return JSONArray.fromObject(recs).toString();
	}
	
	@Override
	public String delete(String ids) {
		String[] recId = ids.split(",");
		if(recruitmentDAO.deleteByIds(recId)){
			return StaticValue.DELETE_SUCCESS;
		}
		return StaticValue.DELETE_FAILURE;
	}

	@Override
	public String getByCondition(RecruitmentBean recBean, String start, String limit) {
		PageBean pageBean = recruitmentDAO.findAllByCondition(recBean, start, limit);
		String json = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+json+"}";
	}
	
	public RecruitmentDAO getRecruitmentDAO() {
		return recruitmentDAO;
	}

	public void setRecruitmentDAO(RecruitmentDAO recruitmentDAO) {
		this.recruitmentDAO = recruitmentDAO;
	}
}
