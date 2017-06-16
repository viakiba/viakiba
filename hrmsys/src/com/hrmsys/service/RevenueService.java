package com.hrmsys.service;

import java.util.List;

import com.hrmsys.model.Revenue;

public interface RevenueService {
	/**
	 * 查询全部
	 * @return
	 */
	String list(String start, String limit);
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	String delete(String ids);
	/**
	 * 修改
	 * @param modifyList
	 * @return
	 */
	String modify(String json);

}
