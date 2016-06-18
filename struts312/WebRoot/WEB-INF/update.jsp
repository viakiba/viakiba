<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'update.jsp' starting page</title>
  </head>
  
  <body>
    <s:form action="/emp_update" method="post">
    	
    	<!-- 隐藏域 保存主键 -->
    	<s:hidden name="id"></s:hidden>
    	
    	<table>
    		<tr>  
    			<td>员工</td>
    			<td><s:textfield name="empName"></s:textfield></td>
    		</tr>
    		<tr>  
    			<td>日期</td>
    			<td><s:textfield name="workDate"></s:textfield></td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<s:submit value="修改员工"></s:submit>
    			</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
