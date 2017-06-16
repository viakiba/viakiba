package com.tdvm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdvm.cjgl.entity.CommonCode;
import com.tdvm.sys.dao.CommonCodeDao;
import com.tdvm.sys.service.CommonCodeService;


@Service
public class CommonCodeServiceImpl implements CommonCodeService{
	
	@Autowired
	private CommonCodeDao commonCodeDao;

	@Override
	public String getCodeNameByCode(String code, String type) {

        // 初始化返回值
        String rtn = null;
        
        // 获取数据字典对象
        CommonCode cc = getByCode(code, type);
        
        // 设置返回名称
        if (cc != null) {
            String tmpName = cc.getName();
            rtn = (tmpName == null) ? "" : tmpName;
        }
        
        return rtn;
	}
	
	@Override
	public CommonCode getByCode(String code,String type){
		return commonCodeDao.getByTypeAndCode(type, code);
	}

	@Override
	public List<CommonCode> getCodeList() {
		return commonCodeDao.getCodeList();
	}
	
	


}
