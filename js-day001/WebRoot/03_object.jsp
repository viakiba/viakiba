<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>js中的四种对象</title>
  </head>
  
  <body>
    	<script type="text/javascript">
    	//date
    		var nowStr = new Date().toLocaleString();
    		/* window.document.write(nowStr+"</br>");
    		window.document.write(nowStr+"</br>"); */
    	</script>
    	
    	<script type="text/javascript">
    		//Math
    		for(var i=1;i<11;i++){
    			//1到9之间的随机整数
    			document.write(Math.floor(Math.random()*9)+1+"</br>");
    		}
    		
    			var coss = Math.cos(1);
    			document.write(coss+"</br>");
    			document.write(Math.sqrt(9));
    	</script>
    	
    	<script type="text/javascript">
    		//string
    		
    		//空格也算
    		var str="你好 hello  ";
    		var len = str.length;
    		alert(len);
    	</script>
    	
    	<script type="text/javascript">
    		//Array
    		var arr =new Array("语文","数学","英语",123,true);
    		for(var i=0;i<arr.length;i++){
    			window.document.write("arr"+">>"+i+":::"+arr[i]+"<<"+"</br>")
    		}
    	</script>
    	
    	<script type="text/javascript">
			//自定义对象
			function Person(id,name,sal){
				this.id = id;
				this.name = name;
				this.sal = sal;
			}
			var p = new Person(1,"哈哈",7000);
			
			document.writeln(p.id+"</br>");
			document.write(p.name);
			document.write(p.sal);
    	</script>
    	
    	<script type="text/javascript">
    		//window对象，打开新窗口
    		//var url = "02_function.jsp";
    		//window.open(url);
    	</script>
    	
    	<script type="text/javascript">
    		//status对象 将当前时间设置到状态栏
    		var sta = new Date().toLocaleDateString();
    		window.status = sta;
    	</script>
    	
    	<script type="text/javascript">
    	//location对象，模拟用户在地址栏输入url访问其它页面的情况
    		//var url = "02_function.jsp";
    		//window.location.href = url;
    	</script>
    	
    	<script type="text/javascript">
    	//history 演示刷新
    		window.history.go(0);
    	</script>
  </body>
</html>
