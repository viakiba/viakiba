<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>取得服务端当前时间</title>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
  </head>
  <body>
	当前时间：<div id="timeid"></div>
	<input type="button" id="but" value="获取时间">
	
	<script type="text/javascript">
		$("#but").click(function(){
			var url = "${pageContext.request.contextPath}/servlet/TimeServlet?time="+new Date().getTime();
			var sendDate = {
				"name":"haha",
				"id":465
			};
			
			$("#timeid").load(url, sendDate, function(backData,textStatus,xmlHttpRequest){
				
			});
		});
	</script>
  </body>
</html>
