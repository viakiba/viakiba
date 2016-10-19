//创建 ajax异步对象 即 xmlHttprequest

function createAjax(){
	var ajax=null;
	try{
		ajax = new ActiveXObject("microsoft.xmlhhtp");
	}catch(e1){
		try{
			ajax = new XMLHttpRequest();
		}catch(e2){
			alert("浏览器不支持");
		}
	}
	return ajax;
}