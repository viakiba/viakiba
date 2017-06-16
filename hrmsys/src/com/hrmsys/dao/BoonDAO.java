package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.model.Boon;

public interface BoonDAO {

	PageBean findAll(String start, String limit);

	boolean delete(String[] reIds);

	boolean saveOrUpdate(Boon boon);

	List<Boon> findAll();

}
