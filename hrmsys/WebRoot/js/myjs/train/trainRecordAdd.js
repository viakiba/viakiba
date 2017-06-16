
TrainRecordAddWin = Ext.extend(Ext.Window,{
	id: 'tRecordAddWinId',
	constructor: function(){
		var trainRecordAddPanel = new TrainRecordAddPanel();
		TrainRecordAddWin.superclass.constructor.call(this, {
			width: 500,
			height: 300,
			resizable: false, //不能改变窗体大小 
			title: '培训记录信息录入',
			collapsible: true,
			modal: true,
			items: [trainRecordAddPanel]
		})
	}
})

TrainRecordAddPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'tRecordAddPanelId',
	constructor: function(){
		Ext.QuickTips.init();
		var reader = new Ext.data.JsonReader({},[{
			name: 'trainRecord.trecordId', mapping: 'trecordId'
		},{
			name: 'title', mapping: 'train.trainTitle'
		},{
			name: 'trainRecord.train.trainId', mapping: 'train.trainId'
		},{
			name: 'trainRecord.employee.empId', mapping: 'employee.empId'
		},{
			name: 'trainRecord.trecordResult', mapping: 'trecordResult'
		},{
			name: 'trainRecord.trecordRemark', mapping: 'trecordRemark'
		}]);
		TrainRecordAddPanel.superclass.constructor.call(this,{
			width: 520,
			border: false,
			height: 270,
			frame: true,
			reader: reader,
			defaults: {
				labelWidth: 60,
				labelAlign: 'right'
			},
			items:[{
				layout: 'form',
				items: [{
					xtype: 'hidden',
					name: 'trainRecord.trecordId'
				},{
					xtype: 'textfield',
					fieldLabel: '培训主题',
					width: 150,
					allowBlank: false,
					msgTarget: 'side',
					blankText: '不能为空',
					name: 'title',
					id: 'title',
					listeners: {'focus': function(){
							var trainGridWin = new TrainGridWin();
							trainGridWin.show();
						}
					}
				},{
					xtype: 'textfield',
					fieldLabel: '工号',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '不能为空',
					width: 150,
					name: 'trainRecord.employee.empId'
				},{
					xtype: 'combo',
					fieldLabel: '培训结果',
					width: 150,
					allowBlank: false,
					msgTarget: 'side',
					blankText: '不能为空',
					triggerAction: 'all',
					editable: false,
					mode: 'local',
					store: new Ext.data.SimpleStore({
						fields: ['name','value'],
						data: [["未参加","0"],["优秀","1"],["良好","2"],["及格","3"],["不及格","4"]]
					}),
					displayField: 'name',
					valueField: 'value',
					hiddenName: 'trainRecord.trecordResult'
				},{
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: '备注',
					width: 370,
					height: 100,
					name: 'trainRecord.trecordRemark'
				},{
					xtype: 'hidden',
					name: 'trainRecord.train.trainId',
					id: 'trainId'
				}]
			}]
			}],
			buttonAlign: 'center',
			buttons: [{
				columnWidth: .5,
				text: '保存',
				iconCls: 'save',
				handler: this.saveTRecordFn
			},{
				columnWidth: .5,
				text: '关闭',
				iconCls: 'cancel',
				handler: this.cancelTRecordFn
			}]
		})
	},
	saveTRecordFn : function(){
		if(!Ext.getCmp('tRecordAddPanelId').getForm().isValid()){
			return;
		}
		Ext.getCmp('tRecordAddPanelId').getForm().submit({
			url: 'tRecord_save.action',
			method: 'post',
			waitTitle: '提示',
			waitMsg: '正在保存数据...',
			success: saveTRecordSuccessFn,
			failure: saveTRecordFailureFn
		})},
	cancelTRecordFn : function(){
		Ext.getCmp('tRecordAddWinId').destroy();
	}
});
	saveTRecordSuccessFn = function(form, action){
		Ext.Msg.confirm('提示',action.result.msg, function(button, text){
			if(button == "yes"){
				form.reset();
				Ext.getCmp('tRecordAddWinId').destroy();
				Ext.getCmp('tRecordInfoGridId').getStore().reload();
			}
		})
	};
	saveTRecordFailureFn = function(form, action){
		Ext.Msg.alert('提示','连接失败', function(button, text){});
	};

