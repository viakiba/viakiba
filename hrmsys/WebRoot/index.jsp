<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html>
  <head>
  	<title>人力资源系统登录</title>
  	<link rel="stylesheet" type="text/css"
			href="js/extjs/resources/css/ext-all.css"/>
	<link rel="stylesheet" type="text/css"
		href="css/common.css"/>
	<script type="text/javascript" src="js/extjs/ext-base.js"></script>
	<script type="text/javascript" src="js/extjs/ext-all.js"></script>
  	<script type="text/javascript" src="<%=path%>/js/myjs/login.js"></script>
  </head>
  
  <body style="background-color: #ddeefb;">
  	<noscript>        
         <div>    
             <span style="font: bold 20px Arial; color:#F8F8FF; background: maroon; vertical-align: middle">浏览器没有打开JavaScript支持！</span>    
         </div>     
    </noscript>    
  	<div class="index">
  	<table class="login">
  		<tr>
  			<td height="20px" align="center" style="color: red;">&nbsp;<s:actionmessage/></td>
  		</tr>
  		<tr>
  			<td><div id="loginForm" ></div> </td>
  		</tr>
  	</table>
  	</div>
  	<div class="index_bottom">
  		&& 版权所有&copy;TRj1101 &&
  	</div>
  </body>
</html>
