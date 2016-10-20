<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>省份-城市，基于jQuery的AJAX二级联动</title>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
  </head>
  <body>
	
	<select id="province">
		<option>选择省份</option>
		<option>湖南</option>
		<option>广东</option>
	</select>
	
	<select id="city">
		<option>选择城市</option>
	</select>

	
	<!-- 省份->城市 -->	
	<script type="text/javascript">
		//定位省份下拉框，同时添时内容改变事件
		$("#province").change( function(){
			//清空原城市下拉框中的内容，除第一项外
			$("#city option:gt(0)").remove();
			//获取选中的省份
			var province = $("#province option:selected").text();
			//如果选中的不是"选择省份"
			if("选择省份"!=province){
				$.ajax( {
					type    : "POST",
					url     : "${pageContext.request.contextPath}/struts2/findCityByProvinceRequest?time="+new Date().getTime(),
					data    : {"province":province},
					success : function(backDate,textStatus,ajax){
								//alert(backDate!=null?"收到":"为收到");	
								//alert(ajax.responseText);
								//解析json文本
								var array = backDate.setCity;
							  	var size = array.length;
							  	for(var i=0;i<size;i++){
							  		var city = array[i];
							  		var $option = $("<option>"+city+"</option>");
							  		$("#city").append($option);
							  	}
							  }
				} );
			}
		} );
	</script>

  </body>
</html>







