<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="/emp_save" method="post">
		<!-- 防止表单重复提交，第一步：生成id(客户端、服务器) -->
  		<s:token></s:token>
		
		<table>
			<tr>
				<td>员工名</td>
				<td><s:textfield name="empName"></s:textfield></td>
			</tr>
			<tr>
				<td>日期</td>
				<td><s:textfield name="workDate"></s:textfield></td>
			</tr>
			<tr>
				<td colspan="2">
					<s:submit value="保存员工"></s:submit>
				</td>
			</tr>
		</table>
	
	</s:form>
</body>
</html>