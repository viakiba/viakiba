
RecruitmentDetailWin = Ext.extend(Ext.Window,{
	id: 'recruitmentDetailWinId',
	width: 900,
	height: 380,
	constructor: function(){
		var recruitmentDetailPanel = new RecruitmentDetailPanel();
		RecruitmentDetailWin.superclass.constructor.call(this, {
			modal: true,
			items: [recruitmentDetailPanel]
		});
	}
});

RecruitmentDetailPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'recruitmentDetailPanelId',
	constructor: function(){
	Ext.QuickTips.init();
		var reader = new Ext.data.JsonReader({},[{
			name: 'recTitle', mapping: 'recTitle'
		},{
			name: 'recStart', mapping: 'recStart.time', dateFormat : 'time', type: 'date'
		},{
			name: 'recEnd', mapping: 'recEnd.time', dateFormat : 'time', type: 'date'
		},{
			name: 'recJob', mapping: 'recJob'
		},{
			name: 'recNum', mapping: 'recNum'
		},{
			name: 'recContent', mapping: 'recContent'
		},{
			name: 'recRemark', mapping: 'recRemark'
		},{
			name: 'recDate', mapping: 'recDate',  mapping: 'recDate.time', dateFormat : 'time', type: 'date'
		},{
			name: 'recPerson', mapping: 'recPerson'
		}]);
		RecruitmentDetailPanel.superclass.constructor.call(this, {
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
						layout: 'form',
						items: [{
							xtype: 'textfield',
							width: 100,
							fieldLabel: '标题',
							allowBlank: false,
							blankText: '不能为空',
							msgTarget: 'title',
							emptyText: '不能为空',
							name: 'recTitle',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]						
					},{
						layout: 'form',
						xtype: 'panel',
						items: [{
							xtype: 'datefield',
							fieldLabel: '开始时间',
							format: 'Y-m-d',
							width: 100,
							name: 'recStart',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]
					},{
						layout: 'form',
						items: [{
							xtype: 'datefield',
							fieldLabel: '结束时间',
							width: 100,
							format: 'Y-m-d',
							name: 'recEnd',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]
					},{
						layout: 'form',
						items: [{
							xtype: 'textfield',
							fieldLabel: '职位',
							allowBlank: false,
							blankText: '不能为空',
							msgTarget: 'title',
							emtyText: '不能为空',
							width: 100,
							name: 'recJob',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]
					},{
						layout: 'form',
						items: [{
							xtype: 'textfield',
							fieldLabel: '人数',
							width: 100,
							name: 'recNum',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]
					},{
						colspan: 3,
						layout: 'form',
						items: [{
							xtype: 'textarea',
							fieldLabel: '要求',
							allowBlank: false,
							blankText: '不能为空',
							msgTarget: 'title',
							emtyText: '不能为空',
							width: 430,
							height: 200,
							name: 'recContent',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]
					},{
						colspan: 2,
						layout: 'form',
						items: [{
							xtype: 'textarea',
							fieldLabel: '备注',
							width: 270,
							height: 200,
							name: 'recRemark',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]
					},{
						layout: 'form',
						items: [{
							xtype: 'textfield',
							width: 100,
							name: 'recPerson',
							fieldLabel: '录入人',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]
					},{
						layout: 'form',
						items: [{
							xtype: 'datefield',
							width: 100,
							name: 'recDate',
							fieldLabel: '录入时间',
							format: 'Y-m-d',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]
					},{
						colspan: 3
					},{
						colspan: 5,
						buttonAlign: 'center',
						buttons: [{
							text: '关闭',
							iconCls: 'cancel',
							handler: recCloseFn
						}]
					}]
				}]
		});
	}
});
recCloseFn = function(){
	Ext.getCmp('recruitmentDetailWinId').destroy();
}