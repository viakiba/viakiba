<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<s:form action="/admin_login" method="POST" theme="simple">
  <table border="1" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <td>管理员账号</td>
      <td>
        <s:textfield name="adminName" id="adminName" value=""></s:textfield>
      </td>
    </tr>
    <tr>
      <td>密码：</td>
      <td><s:textfield name="pwd" id="pwd" value=""></s:textfield></td>
    </tr>
    <tr>
      <td colspan="2">
        <s:submit value="登录"></s:submit>
      </td>
    </tr>
  </table>
</s:form>
</body>
</html>
