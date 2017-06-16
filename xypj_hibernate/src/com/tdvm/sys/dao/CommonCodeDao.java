package com.tdvm.sys.dao;

import java.util.List;

import com.tdvm.cjgl.entity.CommonCode;


public interface CommonCodeDao {
	/**
	 * 
	 * 方法描述：根据公用代码类型和代码获取公用代码
	 * @param type
	 * @param code
	 * @return
	 */
	public CommonCode getByTypeAndCode(String type ,String code);
	public List<CommonCode> getCodeList();
}
