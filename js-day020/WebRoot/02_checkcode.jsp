<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>验证码检查</title>
    <script type="text/javascript" src="js/ajax.js"></script>
  </head>
  <body>
	
	<form>
		<table border="0" align="center">
			<tr>
				<th>验证码：</th>
				<td><input size="2" type="text" name="checkcode" id="checkcodeID" maxlength="4"/></td>
				<td><img src="01_image.jsp"/>
				<td id="res"></td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript">
		//去掉二边的空格
		function trim(str){"  zhaojun  "
		//   /^ 必须是字母开头   ^都行。。。。
			str = str.replace(/^\s*/,"");//"zhaojun  " 	
			str = str.replace(/\s*$/,"");//"zhaojun"
			return str; 	
		}
	</script>
	
	<script type="text/javascript">
		document.getElementById("checkcodeID").onkeyup = function(){
			var checkcode = this.value;
			checkcode = trim(checkcode);//2525
			if(checkcode.length == 4){
				//NO1)
				var ajax = createAJAX();
				//NO2)
				var method = "POST";
				var url = "${pageContext.request.contextPath}/checkRequest?time="+new Date().getTime();
				ajax.open(method,url);
				//NO3)
				ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
				//NO4)
				var content = "checkcode=" + checkcode;
				ajax.send(content);
			
				//--------------------------------------------------------等待
				
				//NO5)
				ajax.onreadystatechange = function(){
					if(ajax.readyState == 4){
						if(ajax.status == 200){
							//NO6)
							var tip = ajax.responseText;
							
							//NO7)
							var img = document.createElement("img");
							img.src = tip;
							img.style.width = "14px";
							img.style.height = "14px";
							var td = document.getElementById("res");
							td.innerHTML = "";
							td.appendChild(img);
						}
					}
				}
			}else{
				//清空图片
				var td = document.getElementById("res");
				td.innerHTML = "";
			}
		}
	</script>	

  </body>
</html>
