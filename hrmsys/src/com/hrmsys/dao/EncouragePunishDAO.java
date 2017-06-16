package com.hrmsys.dao;

import com.hrmsys.bean.EncouragePunishBean;
import com.hrmsys.bean.PageBean;
import com.hrmsys.model.EncouragePunish;

public interface EncouragePunishDAO {
	/**
	 * 查询全部
	 * @return
	 */
	PageBean findAll( String start, String limit);
	/**
	 * 按条件查询
	 * @return
	 */
	PageBean findAllByCondition(EncouragePunishBean ePunishBean,  String start, String limit);
	/**
	 * 删除
	 * @param epIds
	 * @return
	 */
	boolean delete(String[] epIds);
	/**
	 * 保存
	 * @param ePunish
	 * @return
	 */
	boolean save(EncouragePunish ePunish);
	/**
	 * 按id查询
	 * @param epId
	 * @return
	 */
	EncouragePunish findById(int epId);
	/**
	 * 修改
	 * @param ePunish
	 * @return
	 */
	boolean update(EncouragePunish ePunish);

}
