Ext.namespace("Ext.hrmsys.grid");

Ext.hrmsys.grid.tooltip = {
	//内容过长用省略号显示 
	subLength : function(value){
		if(value != "" && value.length > 10){
			return "<span ext:qtip="+value+">"+value.substring(0, 10)+"...</span>";
		}else{
			return "<span ext:qtip="+value+">"+value+"</span>";
		}
	}
}