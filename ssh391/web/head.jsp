<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!-- 判断：如果用户登陆： 显示欢迎你，退出 -->
<!-- 判断：如果用户没有登陆： 显示登陆、注册 -->

<div align="center" style="width: 80%">
  <s:if test="#session.adminInfo != null">
    欢迎你： <s:property value="#session.adminInfo.adminName"/> &nbsp;
    <s:a href="#">退出</s:a>
    <s:a href="emp_viewAdd">添加员工</s:a>
  </s:if>

  <s:else>
    <s:a href="login.jsp">登录</s:a>
    <s:a href="resister.jsp">注册</s:a>
  </s:else>
</div>

