Ext.namespace("hrmsys.trainRecord.detail");

TrainRecordDetailWin = Ext.extend(Ext.Window,{
	id: 'tRecordDetailWinId',
	constructor: function(){
		var trainRecordDetailPanel = new TrainRecordDetailPanel();
		TrainRecordDetailWin.superclass.constructor.call(this, {
			width: 500,
			height: 350,
			resizable: false, //不能改变窗体大小 
			title: '培训记录详情',
			collapsible: true,
			modal: true,
			items: [trainRecordDetailPanel]
		})
	}
})

TrainRecordDetailPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'tRecordDetailPanelId',
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
		},{
			name: 'trainRecord.trecordAddPerson', mapping: 'trecordAddPerson'
		},{
			name: 'trainRecord.trecordAddDate', mapping: 'trecordAddDate.time', dateFormat : 'time', type: 'date'
		}]);
		TrainRecordDetailPanel.superclass.constructor.call(this,{
			width: 520,
			border: false,
			height: 320,
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
					name: 'title',
					style: 'background: #dfe8f6;',
					readOnly: true,
					id: 'title'
				},{
					xtype: 'textfield',
					fieldLabel: '工号',
					style: 'background: #dfe8f6;',
					readOnly: true,
					width: 150,
					name: 'trainRecord.employee.empId'
				},{
					xtype: 'combo',
					fieldLabel: '培训结果',
					width: 150,
					style: 'background: #dfe8f6;',
					readOnly: true,
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
					xtype: 'textfield',
					fieldLabel: '添加人',
					style: 'background: #dfe8f6;',
					readOnly: true,
					width: 150,
					name: 'trainRecord.trecordAddPerson'
				},{
					xtype: 'datefield',
					fieldLabel: '添加时间',
					format: 'Y-m-d',
					style: 'background: #dfe8f6;',
					readOnly: true,
					width: 150,
					name: 'trainRecord.trecordAddDate'
				},{
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: '备注',
					width: 370,
					style: 'background: #dfe8f6;',
					readOnly: true,
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
				text: '关闭',
				iconCls: 'cancel',
				handler: function(){
					Ext.getCmp('tRecordDetailWinId').destroy();
				}
			}]
		})
	}
});

