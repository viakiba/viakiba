
TrainDetailWin = Ext.extend(Ext.Window,{
	id: 'trainDetailWinId',
	constructor: function(){
		var trainDetailPanel = new TrainDetailPanel();
		TrainDetailWin.superclass.constructor.call(this, {
			width: 500,
			height: 400,
			resizable: false, //不能改变窗体大小 
			title: '培训信息录入',
			collapsible: true,
			modal: true,
			items: [trainDetailPanel]
		})
	}
})

TrainDetailPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'trainDetailPanelId',
	constructor: function(){
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
		},{
			name: 'train.trainAddDate', mapping: 'trainAddDate'
		},{
			name: 'train.trainAddPerson', mapping: 'trainAddPerson'
		}]);
		TrainDetailPanel.superclass.constructor.call(this,{
			width: 490,
			border: false,
			height: 370,
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
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '标题',
					style: 'background: #dfe8f6;',
					width: 150,
					name: 'train.trainTitle',
					readOnly: true
				},{
					xtype: 'datefield',
					fieldLabel: '时间',
					width: 150,
					style: 'background: #dfe8f6;',
					name: 'train.trainDate',
					format: 'Y-m-d',
					readOnly: true
				},{
					xtype: 'textfield',
					fieldLabel: '添加人',
					width: 150,
					style: 'background: #dfe8f6;',
					name: 'train.trainAddPerson',
					readOnly: true
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '培训人',
					width: 150,
					style: 'background: #dfe8f6;',
					name: 'train.trainPerson',
					readOnly: true
				},{
					xtype: 'textfield',
					fieldLabel: '地点',
					width: 150,
					style: 'background: #dfe8f6;',
					name: 'train.trainPlace',
					readOnly: true
				},{
					xtype: 'textfield',
					fieldLabel: '添加时间',
					width: 150,
					style: 'background: #dfe8f6;',
					name: 'train.trainAddDate',
					readOnly: true
				}]
			},{
				colspan: 2,
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: '内容',
					width: 370,
					height: 100,
					style: 'background: #dfe8f6;',
					name: 'train.trainContent',
					readOnly: true
				},{
					xtype: 'textarea',
					fieldLabel: '备注',
					width: 370,
					height: 100,
					style: 'background: #dfe8f6;',
					name: 'train.trainRemark',
					readOnly: true
				}]
			}],
			buttonAlign: 'center',
			buttons: [{
				text: '关闭',
				iconCls: 'cancel',
				handler: function(){
					Ext.getCmp("trainDetailWinId").destroy();
				}
			}]
		})
	}
});
