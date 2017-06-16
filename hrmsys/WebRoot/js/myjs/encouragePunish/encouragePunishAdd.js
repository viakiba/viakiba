Ext.namespace("hrmsys.encouragePunish.add");
/**
 * 奖惩添加窗口
 * @author sux 2011-02-21
 * @memberOf {TypeName} 
 */
EPunishAddWin = Ext.extend(Ext.Window,{
	id: 'ePunishAddWinId',
	constructor: function(){
		var ePunishAddPanel = new EPunishAddPanel();
		EPunishAddWin.superclass.constructor.call(this, {
			title: '奖惩录入',
			resizable: false,
			width: 810,
			modal: true,
			items: [ePunishAddPanel]
		})			
	}
});

EPunishAddPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'ePunishAddPanelId',
	constructor: function(){
		Ext.QuickTips.init();
		var reader = new Ext.data.JsonReader({},[{
			name: 'epunish.epId', mapping: 'epId'
		},{
			name: 'epunish.employee.empId', mapping: 'employee.empId'
		},{
			name: 'epunish.epType', mapping: 'epType'
		},{
			name: 'epunish.epTopic', mapping: 'epTopic'
		},{
			name: 'epunish.epMoney', mapping: 'epMoney'
		},{
			name: 'epunish.epOther', mapping: 'epOther'
		},{
			name: 'epunish.epReason', mapping: 'epReason'
		},{
			name: 'epunish.epRemark', mapping: 'epRemark'
		}]);
		EPunishAddPanel.superclass.constructor.call(this,{
			padding: '10',
			width: 800,
			height: 300,
			frame: true,
			layout: 'table',
			reader: reader,
			layoutConfig: {
				columns: 4
			},
			defaults: {
				labelWidth: 60,
				labelAlign: 'right'
			},
			items: [{
				layout:'form',
				width: 190,
				items:[{
					xtype: 'hidden',
					name: 'epunish.epId'
				},{
					xtype: 'textfield',
					fieldLabel: '员工工号',
					width: 100,
					id: 'ep_empId',
					allowBlank: false,
					msgTarget: 'side',
					emptyText: '不能为空',
					blankText: '请填写员工号',
					listeners: {'blur': epEmpFn},
					name: 'epunish.employee.empId'
				}]
			},{
				layout: 'form',
				width: 190,
				items: [{
					xtype: 'combo',
					fieldLabel: '类别',
					blankText: '请选择',
					msgTarget: 'side',
					width: 100,
					allowBlank: false,
					triggerAction: 'all',
					mode: 'local',
					editable: false,
					hiddenName: 'epunish.epType',
					store: new Ext.data.SimpleStore({
						fields: ['name','value'],
						data: [["奖励","0"],["惩罚","1"]]
					}),
					displayField: 'name',
					valueField: 'value'
				}]
			},{
				width: 190,
				layout:'form',
				items:[{
					xtype: 'textfield',
					fieldLabel: '主题',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '不能为空',
					name: 'epunish.epTopic',
					width: 100
				}]
			},{
				width: 190,
				layout:'form',
				items:[{
					xtype: 'textfield',
					msgTarget: 'side',
					allowBlank: false,
					blankText: '不能为空',
					fieldLabel: '奖惩金额',
					name: 'epunish.epMoney',
					width: 100
				}]
			},{
				colspan: 2,
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: '其它奖惩',
					name: 'epunish.epOther',
					width: 285,
					height:100
				}]
			},{
				colspan: 2,
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: '原因',
					width: 285,
					name: 'epunish.epReason',
					height:100
				}]
			},{
				colspan: 4,
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: '备注',
					name: 'epunish.epRemark',
					width: 665,
					height: 100
				}]
			}],
			buttonAlign: 'center',
			buttons: [{
				text: '保存',
				iconCls: 'save',
				handler: saveEPunishFn
			},{
				text: '关闭',
				iconCls: 'cancel',
				handler: cancelEPunishFn
			}]
		})
	}
});
saveEPunishFn = function(){
	if(!Ext.getCmp('ePunishAddPanelId').getForm().isValid()){
		return;
	}
	Ext.getCmp('ePunishAddPanelId').getForm().submit({
		url: 'ePunish_save.action',
		waitTitle: '提示',
		waitMsg: '正在保存数据...',
		method: 'post',
		success: saveEPunishSuccess,
		failure: saveEPunishFailure
	})
};
saveEPunishSuccess = function(form, action){
	Ext.Msg.confirm("提示", action.result.msg, function(button, text){
		if(button == "yes"){
			form.reset();
			Ext.getCmp('ePunishAddWinId').destroy();
			Ext.getCmp('ePunishGridPanelId').getStore().load({
			params: {
				start: 0,
				limit: 20
			}});
		}
	})
};
saveEPunishFailure = function(form, action){
	Ext.Msg.alert("提示","连接失败", function(button, text){});
};
cancelEPunishFn = function(){
	Ext.getCmp("ePunishAddWinId").destroy();
};
epEmpFn = function(){
		var empId = Ext.get('ep_empId').dom.value;
		Ext.Ajax.request({
			url: 'emp_isExist.action',
			success: juageSuccessFn,
			failure: failureFn,
			params: {
				empId: empId
			}
		})
	};
	juageSuccessFn = function(response, options){
		if(response.responseText != ""){
		}else{
			Ext.getCmp('ep_empId').markInvalid('此工号不存在');
		}
	};