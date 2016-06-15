<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  	<form action="${pageContext.request.contextPath }/fileup1" method="post" enctype="multipart/form-data">
  		用户名:<input type="text" name="userName"><br/>
  		文件:<input type="file" name="file1"><br/>
  		<input type="submit" value="上传">
  	</form>
  </body>
</html>







