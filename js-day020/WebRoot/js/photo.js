function photo(){
	var img = document.images[0];
	//隐藏方法
	this.hide = function(){
		img.style.visibility = "hidden";
	}
	//显示方法
	this.show= function(){
		img.style.visibility = "visible";
	}
	
	//$()表示定位指定的标签
	
	function $(str){
		//获取str变量的类型
		var type = typeof(str);
		
		//如果是string类型的话
		if(type == "string"){
			//截取字符串的第一个字符
			var first  = str.substring(0,1);
			if("#" == first){
				var end = str.substring(1,str.length);
				var ele = document.getElementById(end);
				if(ele != null){
					return element;
				}else{
					alert("查无此标签");
				}
			}else{
				
			}
			
		}else{
			alert("参数必须是字符串类型");
		}
		
	}
}