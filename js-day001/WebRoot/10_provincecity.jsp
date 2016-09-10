<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>省份联动</title>
  </head>
  
  <body>
  		<script type="text/javascript">
  			function createAjax(){
	  			var ajax=null;
	  			try{
	  				ajax = new ActiveXObject("microsoft.xmlhttp");
	  			}catch(e1){
	  				try{
	  					ajax = new XMLHttpRequest();
	  					}catch(e2){
	  						alert("ajax不支持")
	  					}
	  			}
	  			return ajax;
  			}
  		</script>
  		
  		<select id="provinceID" style="width:111px">
  			<option>选择省份</option>
  			<option>湖南</option>
  			<option>广东</option>
  		</select>
  		&nbsp;&nbsp;&nbsp;
  		<select id="cityID" style="width:111px">
			<option>选择城市</option>  			
  		</select>
  		
  		<script type="text/javascript">
  			//定位省份下拉菜单  同时添加内容改变事件
  			document.getElementById("provinceID").onchange = function(){
  				var cityElement = document.getElementById("cityID");
  				cityElement.options.length= 1;
  				//从option中获取索引号 0开始 省份
  				var index = this.selectedIndex;
  				//定位选中的option标签
  				var optionElement = this[index];
  				//定位选中的option标签
  				var province = optionElement.innerHTML;
  				//
  				if("选择省份"!=province){
  					var ajax = createAjax();
		  			var method ="POST";
		  			var url = "${pageContext.request.contextPath}/ProvinceCityServlet?time="+new Date().getTime();
		  			ajax.open(method, url);
		  			//
		  			ajax.setRequestHeader("content-type", "application/x-www-form-urlencoded");
		  			//
		  			var content = "province="+province;
		  			//
		  			ajax.send(content);
		  			//-----------------------等待
		  			ajax.onreadystatechange = function(){
		  			if(ajax.readyState== 4){
		  				if(ajax.status == 200) {
		  					var xml= ajax.responseXML;
		  					
		  					var cityElementArray = xml.getElementsByTagName("city");
		  					var size = cityElementArray.length;
		  					for(var i=0;i<size;i++){
		  						//innerHTML只能用在html/jsp中，不能用在xml中
								var city = cityElementArray[i].firstChild.nodeValue;
								//<option></option>
								var optionElement = document.createElement("option");	
								//<option>广州</option>
								optionElement.innerHTML = city;
								//<select><option>广州</option></select>
								cityElement.appendChild(optionElement);
		  					}
		  				}
		  			}
		  			}
  				}
  			}
  			
  		</script>
	 
  </body>
</html>
