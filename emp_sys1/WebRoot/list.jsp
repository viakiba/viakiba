<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>
    
  </head>
  
  <body>
  <h1>欢迎，${sessionScope.loginInfo.userName }</h1>
    <table align="center" border="1" width="80%" cellpadding="3" cellspacing="0">
    	<tr>
    		<td>序号</td>
    		<td>编号</td>
    		<td>员工名称</td>
    	</tr>
    	
    	<c:if test="${not empty requestScope.listEmp }" varStatus="vs">
    		<c:forEach var="emp" items="${requsetScope.listEmp }" varStatus="vs">
    			<tr>
    				<td>${vs.count }</td>
    				<td>${emp.emoId }</td>
    				<td>${emp.empName }</td>
    			</tr>
    		</c:forEach>
    	</c:if>
    	
    	
    </table>
  </body>
</html>
