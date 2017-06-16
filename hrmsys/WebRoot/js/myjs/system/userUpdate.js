Ext.namespace("hrmsys.user.update");

UserUpdateWin = Ext.extend(Ext.Window,{
	id: 'userUpdateWinId',
	addForm: null,
	constructor: function(title){
		var updateForm = new UserUpdateForm();
		UserUpdateWin.superclass.constructor.call(this,{
			title: title,
			width: 400,
			modal: true,
			height: 350,
			collapsible: true,
			colsable: true,
			layout: 'form',
			items: [updateForm]
		})
	}
})
UserUpdateForm = Ext.extend(Ext.form.FormPanel,{
	id: 'userUpdateFormId', 
	constructor: function(){
	 	Ext.form.Field.prototype.msgTarget = 'side';
		Ext.QuickTips.init();
		//加载后台数据，进行转换
		var reader = new Ext.data.JsonReader({},[{
			name: 'user.userId'	, mapping: 'userId'
		},{
			name: 'user.employee.empId', mapping: 'employee', convert: function(v){return v.empId;}
		},{
			name: 'user.employee.empName', mapping: 'employee', convert: function(v){return v.empName;}
		},{
			name: 'user.role.roleId', mapping: 'role', convert: function(v){ return v.roleId;}
		},{
			name: 'user.userName', mapping: 'userName'
		},{
			name: 'user.userRemark', mapping: 'userRemark'
		}]);
	    UserUpdateForm.superclass.constructor.call(this, {
	    	labelWidth: 80,
	    	padding: '20 0 0 50',
	    	labelAlign: 'right',
	    	border: false,
	    	frame: true,
	    	reader: reader,
	    	items: [{
	    		xtype: 'textfield',
	    		width: 150,
	    		fieldLabel: '员工工号',
	    		id: 'empId',
	    		readOnly: true,
	    		name: 'user.employee.empId'
	    	},{
	    		xtype: 'textfield',
	    		fieldLabel: '员工名',
	    		width: 150,
	    		id: 'empName',
	    		name: 'user.employee.empName',
	    		readOnly: true
	    	},{
	    		xtype: 'textfield',
	    		fieldLabel: '用户名',
	    		width: 150,
	    		readOnly: true,
	    		id: 'updateUserName',
	    		name: 'user.userName'
	    	},{
	    		xtype: 'combo',
	    		fieldLabel: '角色',
	    		store: new Ext.data.JsonStore({
	    			url: 'role_listAll.action',
	    			autoLoad: true,
	    			fields: ['roleId','roleName']
	    		}),
	    		triggerAction:"all",
	    		editable: false,
	    		width: 150,
	    		displayField: 'roleName',
				valueField: 'roleId',
				hiddenName: 'user.role.roleId'
	    	},{
	    		xtype: 'textarea',
	    		fieldLabel: '备注',
	    		width: 150,
	    		height: 150,
	    		name: 'user.userRemark'
	    	},{
	    		xtype: 'hidden',
	    		name: 'user.userId'
	    	}],
	    	buttonAlign: 'center',
	    	buttons: [{
	    		text: '保存',
	    		handler: function(){
	    			if(!Ext.getCmp('userUpdateFormId').getForm().isValid()){
						return;
					}
	    			Ext.getCmp('userUpdateFormId').getForm().submit({
	    				url: 'user_updateRole.action',
	    				method: 'post',
	    				waitMsg: '正在保存数据...',
	    				waitTitle: '提示',
	    				scope: this,
	    				success: updateUserSuccess,
	    				failure: save_failure
	    			})
	    		}
	    	},{
	    		text: '关闭',
	    		handler: function(){
	    			Ext.getCmp('userUpdateWinId').destroy();
	    		}
	    	}]
	    })
	}
});
updateUserSuccess = function(form, action){
	Ext.Msg.confirm('提示', action.result.msg, function(button, text){
		if(button == "yes"){
			form.reset();
			Ext.getCmp('userUpdateWinId').destroy();
			Ext.getCmp('userInfoPanelId').getStore().reload();//刷新部门显示列表
		}
	});
};
