package com.hrmsys.service;

import com.hrmsys.bean.RecruitmentBean;
import com.hrmsys.model.Recruitment;

public interface RecruitmentService {
	/**
	 * 保存
	 * @param recruitment
	 * @return
	 */
	String save(Recruitment recruitment);

	String list(String start, String limit);

	String getListByRecId(String recId);
	
	String delete(String ids);
	/**
	 * 按条件查询
	 * @param recBean
	 * @return
	 */
	String getByCondition(RecruitmentBean recBean, String start, String limit);

}
