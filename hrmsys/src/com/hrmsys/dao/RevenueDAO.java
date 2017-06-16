package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.model.Revenue;

public interface RevenueDAO {
	/**
	 * 查询所有
	 * @return
	 */
	List<Revenue> findAll();
	/**
	 * 删除
	 * @param reIds
	 * @return
	 */
	boolean delete(String[] reIds);
	/**
	 * 保存或修改
	 * @param revenue
	 * @return
	 */
	boolean saveOrUpdate(Revenue revenue);
	/**
	 * 根据工资查询税率表
	 * @param parseFloat
	 * @return
	 */
	Revenue findByMinAndMax(float allMoney);
	
	PageBean findAll(String start, String limit);

}
