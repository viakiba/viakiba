<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
  </head>
  
  <body>
    <table border="1" align="center">
    	<tr>
    		<th>序号</th>
    		<th>编号</th>
    		<th>员工名称</th>
    		<th>日志日期</th>
    		<th>操作</th>
    	</tr>
    	
    	<!-- 1.先判断  2.迭代 -->
    	<s:if test="#request.listEmp != null">
    		<s:iterator var="emp" value="#request.listEmp" status="st">
    			<tr>
    				<td><s:property value="#st.count"/></td>
    				<td><s:property value="#emp.id"/></td>
    				<td><s:property value="#emp.empName"/></td>
    				<td><s:property value="#emp.workDate"/></td>
    				<td>
    					<s:a href="emp_viewUpdate?id=%{#emp.id}">修改</s:a>
    				</td>
    			</tr>
    		</s:iterator>
    	</s:if>
    	<s:else>
    		<tr>
    			<td colspan="5"> 对不起，没有你想要的数据</td>
    		</tr>
    	</s:else>
    </table>
  </body>
</html>
