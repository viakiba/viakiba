<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: viakiba
  Date: 2017/5/30
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>测试</title>
</head>
<body>
测试
${user.age }
${user.username }
haha
${requestScope.age}
${requestScope.username}

<form action="/code" method="post">
  <input type="text" value="code" name="code" >
  <input type="submit" value="提交">
</form>

<img src="/logincode.jpg" width="55" height="20" id="kaptchaImage"  style="margin-bottom: -3px"/>
</body>
</html>
