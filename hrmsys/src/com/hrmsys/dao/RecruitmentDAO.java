package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.RecruitmentBean;
import com.hrmsys.model.Recruitment;

public interface RecruitmentDAO {

	/**
	 * 保存
	 * @param recruitment
	 * @return
	 */
	boolean saveOrUpdate(Recruitment recruitment);
	/**
	 * 查询所有
	 * @return
	 */
	PageBean findAll(String start, String limit);
	List<Recruitment> findById(int recId);
	boolean deleteByIds(String[] recIds);
	/**
	 * 按查询面板的条件进行查询
	 * @param recBean
	 * @return
	 */
	public PageBean findAllByCondition(RecruitmentBean recBean, String start, String limit);
}
