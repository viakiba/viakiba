
TrainAddWin = Ext.extend(Ext.Window,{
	id: 'trainAddWinId',
	constructor: function(){
		var trainAddPanel = new TrainAddPanel();
		TrainAddWin.superclass.constructor.call(this, {
			width: 460,
			height: 350,
			resizable: false, //不能改变窗体大小 
			title: '培训信息录入',
			collapsible: true,
			modal: true,
			items: [trainAddPanel]
		})
	}
})

TrainAddPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'trainAddPanelId',
	constructor: function(){
		Ext.form.Field.prototype.msgTarget = 'side';
		Ext.QuickTips.init();
		var reader = new Ext.data.JsonReader({},[{
			name: 'train.trainTitle',  mapping: 'trainTitle'
		},{
			name: 'train.trainDate',  mapping: 'trainDate'
		},{
			name: 'train.trainPerson', mapping: 'trainPerson'
		},{
			name: 'train.trainRemark', mapping: 'trainRemark'
		},{
			name: 'train.trainContent', mapping: 'trainContent'
		},{
			name: 'train.trainPlace', mapping: 'trainPlace'
		},{
			name: 'train.trainId', mapping: 'trainId'
		}]);
		TrainAddPanel.superclass.constructor.call(this,{
			width: 450,
			border: false,
			height: 320,
			frame: true,
			layout: 'table',
			reader: reader,
			layoutConfig: {
				columns: 2
			},
			defaults: {
				labelWidth: 60,
				labelAlign: 'right'
			},
			items:[{
				width: 200,
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '标题',
					allowBlank: false,
					emptyText: '不能为空',
					blankText: '不能为空',
					width: 100,
					name: 'train.trainTitle'
				},{
					xtype: 'datefield',
					fieldLabel: '时间',
					allowBlank: false,
					emptyText: '不能为空',
					blankText: '不能为空',
					width: 100,
					name: 'train.trainDate',
					format: 'Y-m-d'
				}]
			},{
				layout: 'form',
				width: 200,
				items: [{
					xtype: 'textfield',
					fieldLabel: '培训人',
					allowBlank: false,
					emptyText: '不能为空',
					blankText: '不能为空',
					width: 100,
					name: 'train.trainPerson'
				},{
					xtype: 'textfield',
					fieldLabel: '地点',
					allowBlank: false,
					emptyText: '不能为空',
					width: 100,
					blankText: '不能为空',
					name: 'train.trainPlace'
				}]
			},{
				colspan: 2,
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: '内容',
					allowBlank: false,
					emptyText: '不能为空',
					blankText: '不能为空',
					width: 300,
					height: 100,
					name: 'train.trainContent'
				},{
					xtype: 'textarea',
					fieldLabel: '备注',
					width: 300,
					height: 100,
					name: 'train.trainRemark'
				},{
					xtype: 'hidden',
					name: 'train.trainId'
				}]
			}],
			buttonAlign: 'center',
			buttons: [{
				columnWidth: .5,
				text: '保存',
				iconCls: 'save',
				handler: saveTrainFn
			},{
				columnWidth: .5,
				text: '关闭',
				iconCls: 'cancel',
				handler: function(){
					Ext.getCmp('trainAddWinId').destroy();
				}
			}]
		})
	}
});
saveTrainFn = function(){
	if(!Ext.getCmp('trainAddPanelId').getForm().isValid()){
			return;
		}
	Ext.getCmp('trainAddPanelId').getForm().submit({
		url: 'train_save.action',
		method: 'post',
		waitTitle: '提示',
		waitMsg: '正在保存数据...',
		success: saveTrainSuccessFn,
		failure: saveTrainFailureFn
	});
};
saveTrainSuccessFn = function(form, action){
	Ext.Msg.confirm('提示',action.result.msg, function(button, text){
		if(button == "yes"){
			form.reset();
			Ext.getCmp('trainAddWinId').destroy();
			Ext.getCmp('trainInfoGridId').getStore().reload();
		}
	})
};
saveTrainFailureFn = function(form, action){
	Ext.Msg.alert('提示','连接失败', function(button, text){});
};
