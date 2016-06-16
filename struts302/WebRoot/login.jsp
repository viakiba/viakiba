<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>login</title>
    
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/user_login" method="post">
    	用户名：<input type="text" name="admin.userName"><br>
    	密码：<input type="text" name="admin.pwd"><br>
    	<input type="submit" value="登陆"><br>
    </form>
  </body>
</html>
