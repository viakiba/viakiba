<%@ page language="java" import="java.util.*,haust.vk.entity.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>listContact</title>
	<style type="text/css">
		table td{
			/*文字居中*/
			text-align:center;
		}
		
		/*合并表格的边框*/
		table{
			border-collapse:collapse;
		}
	</style>
  </head>
  
  <body>
   	<center><h3>查看所有联系人</h3></center>
   	<table align="center" border="1" width="700px">
   		<tr>
   			<th>编号</th>
   			<th>姓名</th>
	        <th>性别</th>
	        <th>年龄</th>
	        <th>电话</th>
	        <th>邮箱</th>
	        <th>QQ</th>
	        <th>操作</th>
   		</tr>
   		<c:forEach items="${contacts }" var="con" varStatus="varSta">
   		<tr>
   			<td>${varSta.count }</td>
   			<td>${con.name }</td>
   			<td>${con.gender }</td>
	        <td>${con.age }</td>
	        <td>${con.phone }</td>
	        <td>${con.email }</td>
	        <td>${con.qq }</td>
   			<td><a href="${pageContext.request.contextPath }/QueryContactServlet?id=${con.id}">修改</a>&nbsp;<a href="${pageContext.request.contextPath }/DeleteContactServlet?id=${con.id}">删除</a></td>
   		</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="8" align="center"><a href="${pageContext.request.contextPath}/addContact.jsp">添加联系人</a></td>
   		
   		</tr>
   	</table>
  </body>
</html>
