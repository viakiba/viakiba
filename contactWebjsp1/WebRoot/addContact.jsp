<%@ page language="java" import="java.util.*,haust.vk.entity.Contact" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>addContact</title>
  </head>
  
  <body>
    <center><h3>添加联系人</h3></center>
    <form action="${pageContext.request.contextPath }/AddContactServlet" method="post">
    	<table align="center" border="1" width="400px">
    	<tr>
    		<th>姓名</th>
    		<td><input type="text" name="name"/><font color="red" >${msg }</font></td>
    	</tr>
    	<tr>
    		<th>性别</th>
    		<td>
    			<input type="radio" name="gender" value="男">男
    			<input type="radio" name="gender" value="女">女
    		</td>
    	</tr>
    	<tr>
    		<th>年龄</th>
    		<td><input type="text" name="age"/></td>
    	</tr>
    	<tr>
    		<th>电话</th>
    		<td><input type="text" name="phone"/></td>
    	</tr>
    	<tr>
    	<th>邮箱</th>
        <td><input type="text" name="email"/></td>
    </tr>
    <tr>
    	<th>QQ</th>
        <td><input type="text" name="qq"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
        <input type="submit" value="保存"/>&nbsp;
        <input type="reset" value="重置"/></td>
    </tr>
    </table>
    </form>
  </body>
</html>
