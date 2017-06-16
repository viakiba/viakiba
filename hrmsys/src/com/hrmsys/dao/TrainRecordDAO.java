package com.hrmsys.dao;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.TrainRecordBean;
import com.hrmsys.model.TrainRecord;

public interface TrainRecordDAO {
	/**
	 * 查询所有
	 * @return
	 */
	PageBean findAll(String start, String limit);
	/**
	 * 删除
	 * @param tRecordIds
	 * @return
	 */
	boolean delete(String[] tRecordIds);
	/**
	 * 按条件查询
	 * @param tRecordBean
	 * @return
	 */
	PageBean findAllByCondition(TrainRecordBean tRecordBean, String start, String limit);
	/**
	 * 保存或修改
	 * @param tRecord
	 * @return
	 */
	boolean saveOrUpdate(TrainRecord tRecord);
	
	/**
	 * 按id查询
	 * @param parseInt
	 * @return
	 */
	TrainRecord findById(int tRecordId);
	/**
	 * 修改
	 * @param trainRecord
	 * @return
	 */
	boolean update(TrainRecord trainRecord);

}
