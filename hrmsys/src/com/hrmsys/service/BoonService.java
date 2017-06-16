package com.hrmsys.service;

public interface BoonService {

	/**
	 * 查询清单
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
	 * 保存或修改
	 * @param json
	 * @return
	 */
	String modify(String json);

}
