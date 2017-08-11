package com.example.dbtest;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class dbtest2 {
	public static void main(String[] args) throws SQLException {
		Connection conn = ConnGetUtil.getConn();
		DatabaseMetaData metaData = conn.getMetaData();
		ResultSet columns = metaData.getColumns("", "", "activity", "%");
		ResultSetMetaData metaData2 = columns.getMetaData();
		System.out.println(metaData2.getColumnCount()+metaData2.getColumnName(2));
		conn.close();
	}
}
