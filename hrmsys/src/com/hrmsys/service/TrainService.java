package com.hrmsys.service;

import com.hrmsys.bean.TrainBean;
import com.hrmsys.model.Train;

public interface TrainService {
	/**
	 * 查询全部
	 * @return
	 */
	String list(String start, String limit);
	/**
	 * 按条件查询
	 * @param trainBean
	 * @return
	 */
	String queryList(TrainBean trainBean, String start, String limit);
	/**
	 * 保存
	 * @param trainBean
	 * @return
	 */
	String save(Train train);
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	String delete(String ids);
	/**
	 * 按id查询
	 * @param trainId
	 * @return
	 */
	String getTrainById(String trainId);

}
