<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>下载列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	<table border="1" align="center">
  		<tr>
  			<td>编号</td>
  			<td>文件名</td>
  			<td>操作</td>
  		</tr>
  		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  		<c:forEach var="fileName" items="${fileNames}" varStatus="vs">
  			<tr>
  				<td>${vs.count }</td>
  				<td>${fileName }</td>
  				<td>
  					<!-- 构建一个url -->
  					<c:url var="url" value="down_down">
  						<c:param name="fileName" value="${fileName}"></c:param>
  					</c:url>
  					
  					<a href="${url }">下载</a>
  				</td>
  			</tr>
  		</c:forEach>
  	</table>
  </body>
</html>







