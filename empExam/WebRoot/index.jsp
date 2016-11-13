<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工管理系统</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/add.do" method="post">
    	<table border="2" align="center">
    		<tr>
				<th>姓名</th>
				<td> <input type="text" name="username"/></td>
			</tr>
    		
    		<tr>
    			<th>期望薪水</th>
    			<td><input type="text" name="salary" value="7000"></td>
    		</tr>
    		<tr>
    			<th>入职日期</th>
    			<td>
    				<input type="text" name="hiredate" value="2015-5-10" />
    			</td>
    			
    		</tr>
    		
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="提交">
    			</td>	
    		</tr>
    	</table>
    
    
    </form>
  </body>
</html>
