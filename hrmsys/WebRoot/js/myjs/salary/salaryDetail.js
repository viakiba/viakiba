Ext.namespace("hrmsys.salaryDetail");

SalaryDetailWin = Ext.extend(Ext.Window, {
	id: 'salaryDetailWinId',
	constructor: function(){
		var salaryDetailPanel = new SalaryDetailPanel();
		SalaryDetailWin.superclass.constructor.call(this, {
			width: 1080,
			height: 550,
			modal: true,
			title: '员工薪水信息',
			items: [salaryDetailPanel]
		})
	}
});
SalaryDetailPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'salaryDetailPanelId',
	constructor: function(){
		Ext.QuickTips.init();
		SalaryDetailPanel.superclass.constructor.call(this, {
			frame: true,
			labelWidth: 80,
			labelAlign: 'right',
			padding: '30',
			reader: salaryReader,
			items: [{
				xtype: 'fieldset',
			items: [{
				xtype: 'fieldset',
				layout: 'column',
				title: '基本信息',
				items: [{
					columnWidth: .25,
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '员工编号',
						readOnly: true,
						style: 'background: #dfe8f6;',
						name: 'salary.employee.empId'
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '员工姓名',
						readOnly: true,
						style: 'background: #dfe8f6;',
						name: 'salary.employee.empName'
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '基本工资',
						style: 'background: #dfe8f6;',
						name: 'salary.salBasic',
						readOnly: true
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '岗位工资',
						name: 'salary.salJob',
						style: 'background: #dfe8f6;',
						readOnly: true
					}]
				}]
			},{
				xtype: 'fieldset',
				layout: 'column',
				title: '考勤信息',
				items:[{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '月度标准工时',
						readOnly: true,
						style: 'background: #dfe8f6;',
						name: 'salary.salNormal'
					}]
				},{
					columnWidth: .25,
					layout: 'form',
					items:[{
						xtype: 'textfield',
						fieldLabel: '旷工工时',
						readOnly: true,
						style: 'background: #dfe8f6;',
						name: 'salary.salAbsenteeism'
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '全勤奖',
						readOnly: true,
						style: 'background: #dfe8f6;',
						name: 'salary.salAll'
					}]
				},{
					columnWidth: .25,
						layout: 'form',
						items: [{
							xtype: 'textfield',
							fieldLabel: '缺勤扣金额',
							name: 'salary.salAbsenteeismMoney',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]
				}]
			},{
				xtype: 'fieldset',
				layout: 'column',
				title: '保险',
				items: [{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '养老保险',
						name: 'salary.salEndowmentint',
						style: 'background: #dfe8f6;',
						readOnly: true
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '失业保险',
						style: 'background: #dfe8f6;',
						name: 'salary.salUnemploymentint',
						readOnly: true
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '医疗保险',
						name: 'salary.salHospitalizationint',
						style: 'background: #dfe8f6;',
						readOnly: true
					}]
				},{
				}]
			},{
				xtype: 'fieldset',
				layout: 'column',
				title: '补贴',
				items: [{
					columnWidth: .25,
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '餐费补贴',
						style: 'background: #dfe8f6;',
						name: 'salary.salEateryfloat',
						readOnly: true
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '交通补贴',
						style: 'background: #dfe8f6;',
						name: 'salary.salTrafficfloat',
						readOnly: true
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '通讯补贴',
						style: 'background: #dfe8f6;',
						name: 'salary.salTelephone',
						readOnly: true
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '其它补贴',
						name: 'salary.salAllowance',
						readOnly: true,
						style: 'background: #dfe8f6;'
					}]
				}]
			},{
				layout: 'column',
				items:[{
					columnWidth: .5,
					layout: 'form',
					items:[{
						xtype: 'textarea',
						fieldLabel: '备注',
						width: 400,
						height: 100,
						name: 'salary.salRemark',
						style: 'background: #dfe8f6;',
						readOnly: true
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '个人税',
						name: 'salary.salRevenue',
						style: 'background: #dfe8f6;',
						readOnly: true
					},{
						xtype: 'textfield',
						fieldLabel: '实发工资',
						name: 'salary.salMoney',
						style: 'background: #dfe8f6;',
						readOnly: true
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '月份',
						readOnly: true,
						style: 'background: #dfe8f6;',
						name: 'salary.salMonth'
					},{
						xtype: 'textfield',
						fieldLabel: '添加人',
						name: 'salary.salReleasePerson',
						style: 'background: #dfe8f6;',
						readOnly: true
					},{
						xtype: 'datefield',
						format: 'Y-m-d',
						fieldLabel: '添加时间',
						name: 'salary.salReleaseDate',
						style: 'background: #dfe8f6;',
						readOnly: true
					}]
				}]
			},{
				buttonAlign: 'center',
				buttons: [{
					text: '关闭',
					iconCls: 'cancel',
					handler: function(){
						Ext.getCmp('salaryDetailWinId').destroy();
					}
				}]
			}]
			}]
		})		
	}
});
var salaryReader = new Ext.data.JsonReader({},[{
			name: 'salary.salId', mapping: 'salId'
		},{
			name: 'salary.employee.empId', mapping: 'employee.empId'
		},{
			name: 'salary.employee.empName', mapping: 'employee.empName'
		},{
			name: 'salary.salBasic', mapping: 'salBasic', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salJob', mapping: 'salJob', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salNormal', mapping: 'salNormal', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salAbsenteeism', mapping: 'salAbsenteeism', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salEndowmentint', mapping: 'salEndowmentint', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salUnemploymentint', mapping: 'salUnemploymentint', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salHospitalizationint', mapping: 'salHospitalizationint', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salEateryfloat', mapping: 'salEateryfloat', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salTrafficfloat', mapping: 'salTrafficfloat', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salTelephone', mapping: 'salTelephone'
		},{
			name: 'salary.salAllowance', mapping: 'salAllowance', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salRevenue', mapping: 'salRevenue', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salMoney', mapping: 'salMoney', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salMonth', mapping: 'salMonth'
		},{
			name: 'salary.salReleasePerson', mapping: 'salReleasePerson'
		},{
			name: 'salary.salReleaseDate', mapping: 'salReleaseDate.time', dateFormat: 'time', type: 'date'
		},{
			name: 'salary.salAbsenteeismMoney', mapping: 'salAbsenteeismMoney', convert: function(v){return v.toFixed(2);}
		},{
			name: 'salary.salAll', mapping: 'salAll', convert: function(v){return v.toFixed(2);}
		}])