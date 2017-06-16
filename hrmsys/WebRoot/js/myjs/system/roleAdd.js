RoleAddWin = Ext.extend(Ext.Window, {
	id: 'RoleAddWinId',
	constructor: function(){
		var roleAddPanel = new RoleAddPanel();
		RoleAddWin.superclass.constructor.call(this, {
			width: 450,
			height: 255,
			modal: true,
			title: '角色添加',
			items: [roleAddPanel]
		})
	}
})

RoleAddPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'roleAddPanelId',
	constructor: function(){
		Ext.QuickTips.init();
		RoleAddPanel.superclass.constructor.call(this, {
			labelWidth: 60,
			frame: true,
			labelAlign: 'right',
			layout: 'form',
			items: [{
				xtype: 'textfield',
				name: 'role.roleName',
				id: 'role_roleName',
				allowBlank: false,
				msgTarget: 'side',
				blankText: '不能为空',
				fieldLabel: '角色名称'
			},{
				xtype: 'textarea',
				name: 'role.roleRemark',
				fieldLabel: '备注',
				width: 300,
				height: 150
			},{
				xtype: 'hidden',
				name: 'role.roleId',
				id: 'role_roleId'
			}],
			buttonAlign: 'center',
			buttons: [{
				text: '保存',
				iconCls: 'save',
				handler: this.saveRoleFn
			}]
		});
	},
	saveRoleFn : function(){
		if(!Ext.getCmp('roleAddPanelId').getForm().isValid()){
			return;
		}
		Ext.getCmp("roleAddPanelId").getForm().submit({
			url: 'role_save.action',
			waitTitle: '提示',
			waitMsg: '正在保存数据...',
			success: function(form, action){
				Ext.Msg.confirm('提示',action.result.msg,function(button, text){
					if(button == 'yes'){
						Ext.getCmp('RoleAddWinId').destroy();
						Ext.getCmp('roleTree').getLoader().dataUrl='role_list.action';
						Ext.getCmp('roleTree').getLoader().load(Ext.getCmp('roleTree').getRootNode(), function(){});
					}
				})
			},
			failure: function(form, action){
				Ext.Msg.alert('提示','连接后台失败！');
			}
		});
	}
});

