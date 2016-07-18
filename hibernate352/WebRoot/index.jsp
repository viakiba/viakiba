<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	 <h2>部门： <s:property value="#request.dept.deptName"/></h2>
  	 <!-- 部门下的员工(懒加载数据) -->
  	 <table border="1" align="center">
  	 	<tr>
  	 		<td>员工编号</td>
  	 		<td>员工姓名</td>
  	 		<td>员工薪水</td>
  	 	</tr>
  	 	<s:if test="#request.dept.emps != null">
  	 		<s:iterator var="emp" value="#request.dept.emps">
  	 			<tr>
  	 				<td><s:property value="#emp.empId" /></td>
  	 				<td><s:property value="#emp.empName" /></td>
  	 				<td><s:property value="#emp.salary" /></td>
  	 			</tr>
  	 		</s:iterator>
  	 	</s:if>
  	 	<s:else>
  	 		<tr><td colspan="3">没有员工信息！</td></tr>
  	 	</s:else>
  	 </table>
  	 
  </body>
</html>