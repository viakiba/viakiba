/**
 * 招聘添加窗口
 * @author sux
 * @memberOf {TypeName} 
 */
RecruitmentAddWin = Ext.extend(Ext.Window,{
	id: 'recruitmentAddWinId',
	constructor: function(){
		var recruitmentAddPanel = new RecruitmentAddPanel();
		RecruitmentAddWin.superclass.constructor.call(this, {
			title: '招聘信息录入',
			resizable: false,
			modal: true,
			width: 1000,
			height: 300,
			items: [recruitmentAddPanel]
		})			
	}
});

RecruitmentAddPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'recruitmentAddPanelId',
	constructor: function(){
		Ext.QuickTips.init();
		var reader = new Ext.data.JsonReader({},[{
			name: 'recruitment.recTitle', mapping: 'recTitle'
		},{
			name: 'recruitment.recStart', mapping: 'recStart.time', dateFormat : 'time', type: 'date'
		},{
			name: 'recruitment.recEnd', mapping: 'recEnd.time', dateFormat : 'time', type: 'date'
		},{
			name: 'recruitment.recJob', mapping: 'recJob'
		},{
			name: 'recruitment.recNum', mapping: 'recNum'
		},{
			name: 'recruitment.recContent', mapping: 'recContent'
		},{
			name: 'recruitment.recRemark', mapping: 'recRemark'
		},{
			name: 'recruitment.recId', mapping: 'recId'
		}]);
		RecruitmentAddPanel.superclass.constructor.call(this,{
 			frame: true,
 			border: false,
 			reader: reader,
			items: [{
				xtype: 'fieldset',
				title: '招聘信息录入',
 				layout: 'table',
 				layoutConfig: {
					columns: 5
 				},
 				defaults: {
 					labelWidth: 60,
 					labelAlign: 'right'
 				},
				items: [{
						width: 190,
						layout: 'form',
						items: [{
							xtype: 'textfield',
							width: 100,
							fieldLabel: '标题',
							allowBlank: false,
							blankText: '不能为空',
							msgTarget: 'side',
							emptyText: '不能为空',
							name: 'recruitment.recTitle'
						}]						
					},{
						width: 190,
						layout: 'form',
						xtype: 'panel',
						items: [{
							xtype: 'datefield',
							editable: false,
							fieldLabel: '开始时间',
							format: 'Y-m-d',
							width: 100,
							name: 'recruitment.recStart'
						}]
					},{
						width: 190,
						layout: 'form',
						items: [{
							xtype: 'datefield',
							editable: false,
							fieldLabel: '结束时间',
							width: 100,
							format: 'Y-m-d',
							name: 'recruitment.recEnd'
						}]
					},{
						width: 200,
						layout: 'form',
						items: [{
							xtype: 'textfield',
							fieldLabel: '职位',
							allowBlank: false,
							blankText: '不能为空',
							msgTarget: 'side',
							emtyText: '不能为空',
							width: 100,
							name: 'recruitment.recJob'
						}]
					},{
						width: 200,
						layout: 'form',
						items: [{
							xtype: 'textfield',
							fieldLabel: '人数',
							width: 100,
							name: 'recruitment.recNum'
						}]
					},{
						colspan: 3,
						layout: 'form',
						items: [{
							xtype: 'textarea',
							fieldLabel: '要求',
							allowBlank: false,
							blankText: '不能为空',
							msgTarget: 'side',
							emtyText: '不能为空',
							width: 460,
							height: 140,
							name: 'recruitment.recContent'
						}]
					},{
						colspan: 2,
						layout: 'form',
						items: [{
							xtype: 'textarea',
							fieldLabel: '备注',
							width: 300,
							height: 140,
							name: 'recruitment.recRemark'
						},{
							xtype: 'hidden',
							name: 'recruitment.recId'
						}]
					},{
						colspan: 5,
						buttonAlign: 'center',
						buttons: [{
							text: '保存',
							iconCls: 'save',
							handler: reSubmit
						},{
							text: '关闭',
							iconCls: 'cancel',
							handler: reCancel
						}]
					}]
				}]
		});
	}
});
reSubmit = function(){
	if(!Ext.getCmp('recruitmentAddPanelId').getForm().isValid()){
			return;
		}
	Ext.getCmp('recruitmentAddPanelId').getForm().submit({
		url: 'recruitment_save.action',
		method: 'post',
		waitTitle: '提示',
		waitMsg: '正在保存数据...',
		success: function(form, action){
			Ext.Msg.confirm('提示',action.result.msg,function(button, text){
				if(button == 'yes'){
					Ext.getCmp('recruitmentAddWinId').destroy();
					Ext.getCmp('recruitmentGridId').getStore().reload();
				}
			})
		},
		failure: function(form, action){
			Ext.Msg.alert('提示','连接后台失败');
		}
	})
};
reCancel = function(){
	Ext.getCmp('recruitmentAddWinId').destroy();
};