Ext.namespace("hrmsys.encouragePunish.detail");
/**
 * 奖惩详情窗口
 * @author sux 2011-02-21
 * @memberOf {TypeName} 
 */
EPunishDetailWin = Ext.extend(Ext.Window,{
	id: 'ePunishAddWinId',
	constructor: function(){
		var ePunishDetailPanel = new EPunishDetailPanel();
		EPunishDetailWin.superclass.constructor.call(this, {
			title: '奖惩信息详情',
			resizable: false,
			width: 720,
			modal: true,
			items: [ePunishDetailPanel]
		})			
	}
});

EPunishDetailPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'ePunishDetailPanelId',
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
		},{
			name: 'epunish.epReleaseDate', mapping: 'epReleaseDate.time', dateFormat : 'time', type: 'date'
		},{
			name: 'epunish.epReleasePerson', mapping: 'epReleasePerson'
		}]);
		EPunishAddPanel.superclass.constructor.call(this,{
			padding: '10',
			width: 720,
			height: 400,
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
				items:[{
					xtype: 'hidden',
					name: 'epunish.epId'
				},{
					xtype: 'textfield',
					fieldLabel: '员工工号',
					style: 'background: #dfe8f6;',
					readOnly: true,
					width: 100,
					name: 'epunish.employee.empId'
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'combo',
					fieldLabel: '类别',
					width: 100,
					style: 'background: #dfe8f6;',
					readOnly: true,
					triggerAction: 'all',
					mode: 'local',
					hiddenName: 'epunish.epType',
					store: new Ext.data.SimpleStore({
						fields: ['name','value'],
						data: [["无","null"],["奖励","0"],["惩罚","1"]]
					}),
					displayField: 'name',
					valueField: 'value'
				}]
			},{
				layout:'form',
				items:[{
					xtype: 'textfield',
					fieldLabel: '主题',
					style: 'background: #dfe8f6;',
					readOnly: true,
					name: 'epunish.epTopic',
					width: 100
				}]
			},{
				layout:'form',
				items:[{
					xtype: 'textfield',
					fieldLabel: '奖惩金额',
					style: 'background: #dfe8f6;',
					readOnly: true,
					name: 'epunish.epMoney',
					width: 100
				}]
			},{
				colspan: 2,
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: '其它奖惩',
					style: 'background: #dfe8f6;',
					readOnly: true,
					name: 'epunish.epOther',
					width: 270,
					height:150
				}]
			},{
				colspan: 2,
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: '原因',
					style: 'background: #dfe8f6;',
					readOnly: true,
					width: 270,
					name: 'epunish.epReason',
					height:150
				}]
			},{
				colspan: 4,
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: '备注',
					style: 'background: #dfe8f6;',
					readOnly: true,
					name: 'epunish.epRemark',
					width: 610,
					height: 100
				}]
			},{
				colspan: 1,
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '添加人',
					style: 'background: #dfe8f6;',
					width: 100,
					name: 'epunish.epReleasePerson',
					readOnly: true
				}]
			},{
				colspan: 1,
				layout: 'form',
				items: [{
					xtype: 'datefield',
					format: 'Y-m-d',
					fieldLabel: '添加时间',
					name: 'epunish.epReleaseDate',
					width: 100,
					style: 'background: #dfe8f6;',
					readOnly: true
				}]
			}],
			buttonAlign: 'center',
			buttons: [{
				text: '关闭',
				iconCls: 'cancel',
				handler: function(){
					Ext.getCmp("ePunishAddWinId").destroy();
				}
			}]
		})
	}
});
