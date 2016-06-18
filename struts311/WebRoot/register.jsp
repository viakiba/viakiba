<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	<!-- 修改struts标签默认的样式： 不让换行 
	<style type="text/css">
	ul{
		display: inline;
	}
	ul li{
		display: inline;
		color: red;
	}
	</style>
	--> 
  </head>
  
  <body>
  	<%@taglib uri="/struts-tags" prefix="s" %>
  	
  	
  	<br/>
  	
  	 <form method="post" action="${pageContext.request.contextPath }/user_register.action">
  	 	用户名：<input type="text" name="user.userName">
  	 	 		<s:fielderror fieldName="user.userName"></s:fielderror>
  	 	<br/>
  	 	密码：<input type="text" name="user.pwd">
  	 			<s:fielderror fieldName="user.pwd"></s:fielderror>
  	 	<br/>
  	 	邮箱：<input type="text" name="user.email"><br/>
  	 	<s:fielderror fieldName="user.email"></s:fielderror>
  	 	生日：<input type="text" name="user.birth"><br/>
  	 	<s:fielderror fieldName="user.birth"></s:fielderror>
  	 	<input type="submit" value="注册"><br/>
  	 </form>
  </body>
</html>
