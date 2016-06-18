<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
  </head>
  
  <body>
  	<%@taglib uri="/struts-tags" prefix="s" %>
  	
  	
  	<br/>
  	<!-- 在页面文本框内，显示要修改记录的数据 -->
  	
  	<!-- 手动通过value设置显示的值 
  	<s:form action="#">
  		
  		用户名： <s:textfield name="user.userName" value="%{#request.userInfo.userName}"></s:textfield>   <br/>
  		
  		邮箱： <s:textfield name="user.email" value="%{#request.userInfo.email}"></s:textfield>     <br/>
  	</s:form>
  	-->
  	
  	<!-- 数据回显技术：s:textfield会自动查找根元素数据(Ognl表达式语言取值)  -->
  	<s:form action="#">
  		
  		用户名： <s:textfield name="userName"></s:textfield>   <br/>
  		
  		邮箱： <s:textfield name="email"></s:textfield>     <br/>
  		
  		<s:submit value="修改"></s:submit>
  	</s:form>
  	
  	<s:debug></s:debug>
  </body>
</html>









