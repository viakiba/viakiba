<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>检查注册用户名和密码是否存在</title>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
  </head>
  <body>
	<table>
		<tr>
			<th>用户名</th><td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<th>密码</th><td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
					<input type="button" value="检查" style="width:111px"/>
			</td>
		</tr>
	</table>
	<span></span>
	<script type="text/javascript">
		$(":button").click(function(){
			var username = $(":text").val();
			var password = $(":password").val();
			
			var url = "${pageContext.request.contextPath}/servlet/UserServlet?time="+new Date().getTime();
			
			var sendData = $("form").serialize();
			
			$.post(url,sendData,function(backDate){
				var $img = $("<img src='"+backDate+"' width='14px' height='14px'>");
				$("span").text("");
				$("span").append($img);
			});
		});
	
	</script>
  </body>
</html>







