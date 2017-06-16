Ext.namespace("hrmsys.jobChange.detail");
/**
 * @author sux
 * @desc 职员调动录入
 * @date 2011-02-13
 */
JobChangeDetailWin = Ext.extend(Ext.Window, {
	id: 'jobChangeDetailWinId',
	title: '职员变动详情',
	constructor: function(){
		var jobChangeDetailPanel = new JobChangeDetailPanel();
	JobChangeDetailWin.superclass.constructor.call(this, {
			resizable: false,
			modal: true,
			width: 800,
			height: 320,
			items: [jobChangeDetailPanel ]
		})
	}
});
var JobChangeDetailPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'jobChangeaDetail',
	constructor: function(){
		Ext.QuickTips.init();
		var reader = new Ext.data.JsonReader({},[{
			name: 'jobChange.jcId', mapping: 'jcId'
		},{
			name: 'jobChange.employee.empId', mapping: 'employee.empId'
		},{
			name: 'jobChange.employee.empName', mapping: 'employee.empName'
		},{
			name: 'oldDept', mapping: 'departmentByJcOldDept.deptName'
		},{
			name: 'oldJob', mapping: 'jobByJcOldJob.jobName'
		},{
			name: 'newDept', mapping: 'departmentByJcNewDept.deptName'
		},{
			name: 'newJob', mapping: 'jobByJcNewJob.jobName'
		},{
			name: 'jobChange.jcReason', mapping: 'jcReason'
		},{
			name: 'jobChange.jcRemark', mapping: 'jcRemark'
		},{
			name: 'jobChange.jcAddPerson', mapping: 'jcAddPerson'
		},{
			name: 'jobChange.jcDate', mapping: 'jcDate.time',  dateFormat : 'time', type: 'date'
		}]);
		JobChangeAddPanel.superclass.constructor.call(this,{
			//collapsible: true,
			//collapsed: true,
			frame: true,
			titile: '职员调动',
			labelWidth: 60,
			labelAlign: 'right',
			reader: reader,
			items:[{
				xtype: 'fieldset',
				title: '职员调动',
				layout: 'table',
				layoutConfig:{
					columns: 4
				},
			items: [{
				layout: 'form',
				defaultType: 'textfield',
				defaults: {
					width: 100
				},
				width: 200,
				items: [{
					xtype: 'hidden',
					name: 'jobChange.jcId'
				},{
					fieldLabel: '员工编号',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '请填写员工号',
					id: 'jc_empId',
					name: 'jobChange.employee.empId',
					style: 'background: #dfe8f6;',
					readOnly: true
				},{
					xtye: 'textfield',
					style: 'background: #dfe8f6;',
					readOnly: true,
					fieldLabel: '原部门',
					name: 'oldDept'
				}]
			},{
				layout: 'form',
				defaultType: 'textfield',
				defaults: {
					width: 100
				},
				items: [{
					fieldLabel: '员工姓名',
					readOnly: true,
					id: 'jc_empName',
					style: 'background: #dfe8f6;',
					readOnly: true,
					name: 'jobChange.employee.empName'
				},{
					xtype: 'textfield',
					style: 'background: #dfe8f6;',
					readOnly: true,
					fieldLabel: '原职位',
					name: 'oldJob'
				}]
			},{
				layout: 'form',
				defaultType: 'textfield',
				defaults: {
					width: 100
				},
				items: [{
					xtype: 'textfield',
					fieldLabel: '添加人',
					name: 'jobChange.jcAddPerson',
					style: 'background: #dfe8f6;',
					readOnly: true,
					height: 26
				},{
					xtype: 'textfield',
					style: 'background: #dfe8f6;',
					readOnly: true,
					fieldLabel: '新部门',
					name: 'newDept'
				}
				]
			},{
				layout: 'form',
				defaultType: 'textfield',
				defaults: {
					width: 100
				},
				items: [{
					xtype: 'datefield',
					style: 'background: #dfe8f6;',
					readOnly: true,
					format: 'Y-m-d',
					fieldLabel: '添加时间',
					name: 'jobChange.jcDate',
					height: 26
				},{
					xtype: 'textfield',
					fieldLabel: '新职位',
					style: 'background: #dfe8f6;',
					readOnly: true,
					name: 'newJob'
				} ]
			},{
				layout: 'form',
				colspan: 2,
				items: [{
					xtype: 'textarea',
					fieldLabel: '调动原因',
					height: 150,
					width: '100%',
					style: 'background: #dfe8f6;',
					readOnly: true,
					name: 'jobChange.jcReason'
					}]
				},{
					layout: 'form',
					colspan: 2,
					items: [{
						xtype: 'textarea',
						fieldLabel: '备注',
						height: 150,
						style: 'background: #dfe8f6;',
						readOnly: true,
						width: '100%',
						name: 'jobChange.jcRemark'
					}]
				},{
					colspan: 4,
					buttonAlign: 'center',
					buttons: [{
						text: '关闭',
						iconCls: 'cancel',
						handler: function(){
							Ext.getCmp("jobChangeDetailWinId").destroy();
						}
					}]
				}]
				
			}]
			
		})
	}
});