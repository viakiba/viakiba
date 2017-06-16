package com.tdvm.sys.service;

import java.util.List;

import com.tdvm.cjgl.entity.CommonCode;



public interface CommonCodeService {
	
	/**
	 * 
	 * 方法描述：根据代码类型和代码code获取代码对象
	 * @param code
	 * @param type
	 * @return
	 */
	public String getCodeNameByCode(String code,String type);
	public CommonCode getByCode(String code,String type);
	public List<CommonCode> getCodeList();

}
