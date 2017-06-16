Ext.namespace("hrmsys.user.add");

UserAddWin = Ext.extend(Ext.Window,{
	id: 'userAddWinId',
	addForm: null,
	constructor: function(title){
		var addForm = new UserAddForm();
		UserAddWin.superclass.constructor.call(this,{
			title: title,
			width: 400,
			modal: true,
			height: 370,
			resizable: false,
			collapsible: true,
			colsable: true,
			layout: 'form',
			items: [addForm]
		})
	}
})
UserAddForm = Ext.extend(Ext.form.FormPanel,{
	id: 'userAddFormId', 
	constructor: function(){
	 	Ext.form.Field.prototype.msgTarget = 'side';
		Ext.QuickTips.init();
	    UserAddWin.superclass.constructor.call(this, {
	    	labelWidth: 80,
	    	padding: '20 0 0 50',
	    	labelAlign: 'right',
	    	border: false,
	    	frame: true,
	    	items: [{
	    		xtype: 'textfield',
	    		width: 150,
	    		fieldLabel: '员工工号',
	    		id: 'userEmpId',
	    		name: 'user.employee.empId',
	    		allowBlank: false,
	    		msgTarget: 'side',
	    		blankText: '不能为空',
	    		emptyText: '不能为空',
	    		listeners: {'blur': user_blurFn}
	    	},{
	    		xtype: 'textfield',
	    		fieldLabel: '员工名',
	    		width: 150,
	    		id: 'userEmpName',
	    		readOnly: true
	    	},{
	    		xtype: 'textfield',
	    		fieldLabel: '用户名',
	    		allowBlank: false,
	    		msgTarget: 'side',
	    		blankText: '不能为空',
	    		width: 150,
	    		id: 'userUserName',
	    		name: 'user.userName'
	    	},{
	    		xtype: 'combo',
	    		allowBlank: false,
	    		msgTarget: 'side',
	    		blankText: '不能为空',
	    		fieldLabel: '角色',
	    		store: new Ext.data.JsonStore({
	    			url: 'role_listAll.action',
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
	    	}],
	    	buttonAlign: 'center',
	    	buttons: [{
	    		text: '保存',
	    		handler: function(){
	    			if(!Ext.getCmp('userAddFormId').getForm().isValid()){
						return;
					}
	    			Ext.getCmp('userAddFormId').getForm().submit({
	    				url: 'user_save.action',
	    				method: 'post',
	    				waitMsg: '正在保存数据...',
	    				waitTitle: '提示',
	    				scope: this,
	    				success: saveUserSuccess,
	    				failure: save_failure
	    			})
	    		}
	    	},{
	    		text: '取消',
	    		handler: function(){
	    			Ext.getCmp('userAddFormId').getForm().reset();
	    		}
	    	}]
	    })
	}
});
saveUserSuccess = function(form, action){
	Ext.Msg.confirm('提示', action.result.msg, function(button, text){
		if(button == "yes"){
			form.reset();
			Ext.getCmp('userAddWinId').destroy();
			Ext.getCmp('userInfoPanelId').getStore().reload();//刷新部门显示列表
		}
	});
};

user_blurFn = function(value){
	var empId = value.getRawValue();
	Ext.Ajax.request({
		url: 'emp_isExist.action',
		method: 'post',
		params: {
			empId: empId
		},
		success: user_isExistSuccessFn,
		failure: save_failure
	})
};
user_isExistSuccessFn = function(response, options){
	if(response.responseText != ""){
		Ext.get('userEmpName').dom.value = response.responseText;
		Ext.get('userUserName').dom.value = response.responseText;
	}else{
		Ext.getCmp('userEmpId').markInvalid('此工号不存在');
	}
};
