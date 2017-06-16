Ext.namespace("hrmsys.dept.add");

DeptAddWin = Ext.extend(Ext.Window,{
	id: 'deptAddWinId',
	addForm: null,
	constructor: function(){
		addForm = new DeptAddForm();
		DeptAddWin.superclass.constructor.call(this,{
			title: '部门录入',
			width: 400,
			modal: true,
			height: 350,
			collapsible: true,
			colsable: true,
			layout: 'form',
			items: [addForm]
		})
	}
})
DeptAddForm = Ext.extend(Ext.form.FormPanel,{
	id: 'deptAddFormId', 
	constructor: function(){
		Ext.QuickTips.init();
		//加载后台数据，进行转换
		var reader = new Ext.data.JsonReader({},[{
			name: 'dept.deptId'	, mapping: 'deptId'
		},{
			name: 'dept.deptName', mapping: 'deptName'
		},{
			name: 'dept.deptMgr', mapping: 'deptMgr'
		},{
			name: 'dept.deptRemark', mapping: 'deptRemark'
		}]);
	    DeptAddWin.superclass.constructor.call(this, {
	    	labelWidth: 80,
	    	padding: '20 0 0 50',
	    	reader: reader,
	    	labelAlign: 'right',
	    	border: false,
	    	frame: true,
	    	items: [{
	    		xtype: 'textfield',
	    		fieldLabel: '部门编号',
	    		allowBlank: false,
	    		msgTarget: 'side',
	    		blankText: '不能为空',
	    		emptyText: '不能为空',
	    		width: 150,
	    		name: 'dept.deptId'
	    	},{
	    		xtype: 'textfield',
	    		fieldLabel: '部门名称',
	    		allowBlank: false,
				msgTarget: 'side',
				blankText: '不能为空',
				emptyText: '不能为空',	
	    		width: 150,
	    		name: 'dept.deptName'
	    	},{
	    		xtype: 'textfield',
	    		width: 150,
	    		fieldLabel: '部门经理工号',
	    		id: 'empId',
	    		msgTarget: 'side',
	    		listeners: {'blur': blurFn}
	    	},{
	    		xtype: 'textfield',
	    		fieldLabel: '部门经理姓名',
	    		width: 150,
	    		id: 'empName',
	    		name: 'dept.deptMgr',
	    		readOnly: true
	    	},{
	    		xtype: 'textarea',
	    		fieldLabel: '备注',
	    		width: 150,
	    		height: 150,
	    		name: 'dept.deptRemark'
	    	}],
	    	buttonAlign: 'center',
	    	buttons: [{
	    		text: '保存',
	    		handler: function(){
	    			if(!Ext.getCmp('deptAddFormId').getForm().isValid()){
	    				return;
	    			}
	    			Ext.getCmp('deptAddFormId').getForm().submit({
	    				url: 'dept_save.action',
	    				method: 'post',
	    				waitMsg: '正在保存数据...',
	    				waitTitle: '提示',
	    				scope: this,
	    				success: saveDeptSuccessFn,
	    				failure: save_failure
	    			})
	    		}
	    	},{
	    		text: '关闭',
	    		handler: function(){
	    			Ext.getCmp('deptAddWinId').destroy();
	    		}
	    	}]
	    })
	}
});
saveDeptSuccessFn = function(form, action){
	Ext.Msg.confirm('提示', action.result.msg, function(button, text){
		if(button == "yes"){
			form.reset();
			Ext.getCmp('deptAddWinId').destroy();
			Ext.getCmp('deptInfoPanel').getStore().reload();//刷新部门显示列表
		}
	});
};
save_failure = function(form, action){
	Ext.Msg.alert('提示',"连接失败", function(){
		
	});
};
//工号失焦点事件
blurFn = function(value){
	var empId = value.getRawValue();
	Ext.Ajax.request({
		url: 'emp_isExist.action',
		method: 'post',
		params: {
			empId: empId
		},
		success: isExistSuccessFn,
		failure: save_failure
	})
};
isExistSuccessFn = function(response, options){
	if(response.responseText != "")
		Ext.get('empName').dom.value = response.responseText;
	else{
		Ext.getCmp('empId').markInvalid('此工号不存在');
	}
};
