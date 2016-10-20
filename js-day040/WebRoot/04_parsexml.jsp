<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jQuery解析XML</title>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
  </head>
  <body>
	
	<input type="button" value="解析服务器响应的xml文件"/>

	<script type="text/javascript">
		$(":button").click(function(){
			var url = "${pageContext.request.contextPath}/03_city.xml?time="+new Date().getTime();
			var sendData = null;
			$.get(url,sendData,function(xml){
				//用jquery中的api解析xml文件，这时的xml是js对象
				var $xml = $(xml).find("city");
				//迭代
				$xml.each(function(){
					var city = $(this).text();
					alert(city);
				});
			});
		});
	</script>
	
  </body>
</html>







