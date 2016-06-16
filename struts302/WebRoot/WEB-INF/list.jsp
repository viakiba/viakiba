<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>list.jsp</title>
    
  </head>
  
  <body>
    <h2>欢迎你，${userInfo.userName }</h2>
    <table align="center" border="1">
    	<tr>
    		<td>序号</td>
    		<td>编号</td>
    		<td>用户名</td>
    		<td>密码</td>
    	</tr>
    	<%@taglib uri="/struts-tags" prefix="s" %>
    	<s:iterator var="admin" value="#request.listAdmin" status="st">
    		<tr>
	    		<td>
					<s:property value="#st.count"/>
				</td>
	    		<td>
					<s:property value="#admin.id"/>
				</td>
	    		<td>
					<s:property value="#admin.userName"/>
				</td>
				<td>
					<s:property value="#admin.pwd"/>
				</td>
    		</tr>
    	
    	</s:iterator>
    </table>
  </body>
</html>
