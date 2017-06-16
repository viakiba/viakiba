package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.model.Menu;

public interface MenuDAO {

	/**
	 * 依据父节点查找子节点
	 * @param parseInt
	 * @return
	 */
	List<Menu> findNoeById(int parentId);

	List<Menu> findAllLeaf();

}
