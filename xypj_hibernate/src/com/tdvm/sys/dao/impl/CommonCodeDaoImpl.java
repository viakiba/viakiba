package com.tdvm.sys.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.tdvm.cjgl.entity.CommonCode;
import com.tdvm.common.dao.impl.CommonDaoImpl;
import com.tdvm.sys.dao.CommonCodeDao;

@Repository
public class CommonCodeDaoImpl extends CommonDaoImpl implements CommonCodeDao{

	@Override
	public CommonCode getByTypeAndCode(String type, String code) {
		if(StringUtils.isNotBlank(type)){
			String select="select b from CommonCode a,CommonCode b where a.code=? and b.code=? and a.id=b.pCode.id";
			String[] values=new String[]{type,code};
			return (CommonCode) getObjectByHQLAsCache(select, values,null);
		}else{
			String select="from CommonCode where type is null and code=?";
			String[] values=new String[]{code};
			return (CommonCode) getObjectByHQLAsCache(select, values,null);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CommonCode> getCodeList() {
		String select="from CommonCode where type is null";
        return (List<CommonCode>)getListByHQL(select, null, null);             
	}

}
