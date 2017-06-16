// 全兼容可高亮二级缓冲折叠菜单
// 作者：冰极峰 biny
// 博客：冰极峰博客:http://www.cnblogs.com/binyong/
// Email:szbiny@163.com
// 日期：2010-05-27

/*根据类名获得对象--引用自好友司徒正美*/
function getElementsByClassName(searchClass, node,tag){  
	if(document.getElementsByClassName){return  document.getElementsByClassName(searchClass)}
	else{        
		node = node || document;        
		tag = tag || "*";        
		var classes = searchClass.split(" "),        
		elements = (tag === "*" && node.all)? node.all : node.getElementsByTagName(tag),        
		patterns = [],         
		returnElements = [],        
		current,         
		match;        
		var i = classes.length;       
		while(--i >= 0){patterns.push(new RegExp("(^|\\s)" + classes[i] + "(\\s|$)"));}        
		var j = elements.length;       
		while(--j >= 0){            
			current = elements[j];           
			match = false;            
			for(var k=0, kl=patterns.length; k<kl; k++){                
				match = patterns[k].test(current.className);                
				if (!match)  break;           
			} 
			if (match)  returnElements.push(current);        
		}        
		return returnElements;   
	} 
}

/*通用加载函数，页面中如果要用到onload函数在窗体一加载时就执行的代码，可以直接添加到这个函数，否则会引起多个onload函数的执行冲突
  带参数的调用方法：addLoadEvent(new Function("refurFrame('单词管理');"));
*/
function addLoadEvent(func){
	var oldonload=window.onload;
	if(typeof window.onload!='function'){
		window.onload=func;	
	}
	else{
		window.onload=function(){
			oldonload();
			func();
		}	
	}
}

/*判断是否有className的函数，调用例子为：o.className=o.addClass(o,"normal");*/
function hasClass(element, className) {  
	var reg = new RegExp('(\\s|^)'+className+'(\\s|$)');     
	return element.className.match(reg); 
} 
/*动态添加className的函数，调用例子为：addClass(document.getElementById("test"), "test");*/
function addClass(element, className) {  
	if (!this.hasClass(element, className)){   
		element.className += " "+className;/*如果有多个样式叠加，则用这种方式，如class="style1 style2"*/
		/*element.className = className; */ 
	} 
}  
/*动态删除className的函数，调用例子为：removeClass(document.getElementById("test"), "test") */
function removeClass(element, className) {     
	if (hasClass(element, className)){ 
		var reg = new RegExp('(\\s|^)'+className+'(\\s|$)');         
		element.className = element.className.replace(reg,' ');     
	} 
} 
/*获取第一个子节点的函数，兼容FF*/
function getFirstChild(obj){
	var firstDIV;
	for (i=0; i<obj.childNodes.length; i++){
		if (obj.childNodes[i].nodeType==1){
			firstDIV=obj.childNodes[i];
			return firstDIV;
		}
		else 
			continue;
	}
}

addLoadEvent(new Function("hovermenu('level1','level2','hove','cur');"));
//menu代表菜单总的ID名称
//level1代表一级菜单项的父容器，level2代表二级菜单项的父容器，
//后面的三个参数style1,style2,style3分别代表鼠标移入，移出，点击的三态样式名
addLoadEvent(new Function("submenu('level2','hove1','hove1');"));

/*滑动显隐菜单列表*/
var temp;
var temp1;
function hovermenu(cssName1,cssName2,style2,style3){ 
    var ArrLinks=getElementsByClassName(cssName1);//一级菜单父容器的数组
	var ArrLevel = new Array();//第一级菜单的数组
	for(var i=0;i<ArrLinks.length;i++){
		var curobj= getFirstChild(ArrLinks[i]);//获得第一个子对象		    		
		ArrLevel.push(curobj);		
	}
    var ArrDivs=getElementsByClassName(cssName2);//二级菜单的父容器数组，要显示的二级菜单容器
    for(var i=0;i<ArrLinks.length;i++){        
        var obj=getFirstChild(ArrLinks[i]);//获得第一个子对象
        obj.index=i
        obj.onmouseover= function(){overme(this,ArrLevel,style2,temp)};           
        obj.onmouseout=function(){outme(this,ArrLevel,style2,temp)};
		obj.onclick=function(){clickme(this,ArrLinks,ArrDivs,style2,style3,temp)};
		obj.onfocus=function(){this.blur()};//去掉虚线框
    }    
}
//二级菜单绑定事件
function submenu(cssName2,style2,style3){ 
    var ArrLinks=getElementsByClassName(cssName2);//一级菜单父容器的数组
	var ArrLevel = new Array();//第一级菜单的数组
	for(var i=0;i<ArrLinks.length;i++){
		var sublinks= ArrLinks[i].getElementsByTagName('A');//获得第一个子对象
		for(var m=0;m<sublinks.length;m++){
			ArrLevel.push(sublinks[m]);
		}   		
	}	
    for(var i=0;i<ArrLevel.length;i++){        
        var obj=ArrLevel[i];
        obj.index=i
        obj.onmouseover= function(){overme(this,ArrLevel,style2,temp1)};           
        obj.onmouseout=function(){outme(this,ArrLevel,style2,temp1)};
		obj.onclick=function(){subclick(this,ArrLevel,style2,style3,temp1)};
		obj.onfocus=function(){this.blur()};//去掉虚线框
    }    
}
function overme(o,links,style2,state){
	if (state!=o.index){	    
		addClass(o,style2);						
    }
}
function outme(o,links,style2,state){
	if (state!=o.index){
		removeClass(o,style2);	    				
	};
}
//一级菜单点击事件
function clickme(o,links,divs,style2,style3,state){
	//要判断是否有子菜单项
	var objUl=links[o.index].getElementsByTagName('UL');
	var subNum=objUl.length;//是否有二级菜单，0为无，大于0为有;
	if (state!=o.index){		
	    for(var i=0;i<divs.length;i++){ 
		    if(subNum>0){//如果存在二级菜单项，即隐藏它
				divs[i].style.display="none";
				//closeObj(divs[i]);
			}											
	    }		
	    if(subNum>0){//如果存在二级菜单项，显示当前点击的二级菜单
	      objUl[0].style.display="block";
		  showObj(objUl[0]);
		}		
        temp=o.index;
    }	
	for(var i=0;i<links.length;i++){
		var curobj= getFirstChild(links[i]);//获得第一个子对象		    		
		removeClass(curobj,style3);
		removeClass(curobj,style2);
	}								
	addClass(o,style3);
}
//二级菜单点击事件
function subclick(o,links,style2,style3,state){
	if (state!=o.index){
		for(var i=0;i<links.length;i++){
			removeClass(links[i],style2);	
		}
		temp1=o.index;		
	    addClass(o,style2);	
	}
}

//缓冲显示
var flag=0;
function showObj(obj){
	var allhight;
	allhight=obj.getElementsByTagName("li").length*26;//26为每个菜单项的高度，用来计算二级菜单的总高度。
   obj.style.height="1px";   
   var changeW=function(){ 	 		
	  var obj_h=parseInt(obj.style.height);
	  if(obj_h<=allhight){ 
		obj.style.height=(obj_h+Math.ceil((allhight-obj_h)/10))+"px";
	  }
	  else{ 
	  clearInterval(bw1);
	  }
   }       
   bw1= setInterval(changeW,40);//时间开关
   if(flag>0){
	 clearInterval(bw2);
   }
}
//缓冲关闭
function closeObj(obj){	
   flag++;       
   var closeDiv=function(){	   		 
	  clearInterval(bw1);
	  var obj_h=parseInt(obj.style.height);
	  if(obj_h>1){ 
			 obj.style.height=(obj_h-Math.ceil(obj_h)/100)+"px";
	  }
	  else{
	  clearInterval(bw2);
	  obj.style.display="none";
	  }
   }         
  bw2= setInterval(closeDiv,1);
  //alert(flag)
}