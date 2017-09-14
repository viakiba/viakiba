package com.longma.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Component
public class JdbcUtil {
	
	@Resource
	private ComboPooledDataSource dataSource1;
	
	public List<String> exquerySql(String querySql) throws Exception{
		ArrayList<String> arrayList = new ArrayList<String>();
		Connection connection = dataSource1.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(querySql);
		ResultSet executeQuery = prepareStatement.executeQuery();
		while(executeQuery.next()){
			String string = executeQuery.getString(1);
			arrayList.add(string);
		}
		return arrayList;
	}
	
}
