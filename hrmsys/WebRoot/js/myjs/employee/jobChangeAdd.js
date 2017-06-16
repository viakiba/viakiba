Ext.namespace("hrmsys.jobChange.add");
/**
 * @author sux
 * @desc 职员调动录入
 * @date 2011-02-13
 */
JobChangeAddWin = Ext.extend(Ext.Window, {
	id: 'jobChangeAddWinId',
	title: '员工职位添加',
	constructor: function(){
	var jobChangeAddPanel = new JobChangeAddPanel();
	JobChangeAddWin.superclass.constructor.call(this, {
			resizable: false,
			modal: true,
			width: 850,
			height: 340,
			items: [jobChangeAddPanel ]
		})
	}
});
var JobChangeAddPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'jobChangeaAdd',
	constructor: function(){
		Ext.QuickTips.init();
		var reader = new Ext.data.JsonReader({},[{
			name: 'jobChange.jcId', mapping: 'jcId'
		},{
			name: 'jobChange.employee.empId', mapping: 'employee.empId'
		},{
			name: 'jobChange.employee.empName', mapping: 'employee.empName'
		},{
			name: 'jobChange.jcReason', mapping: 'jcReason'
		},{
			name: 'jobChange.jcRemark', mapping: 'jcRemark'
		},{
			name: 'jobChange.departmentByJcOldDept.deptId', mapping: 'departmentByJcOldDept.deptId'
		},{
			name: 'jobChange.jobByJcOldJob.jobId', mapping: 'jobByJcOldJob.jobId'
		},{
			name: 'jobChange.departmentByJcNewDept.deptId', mapping: 'departmentByJcNewDept.deptId'
		},{
			name: 'jobChange.jobByJcNewJob.jobId', mapping: 'jobByJcNewJob.jobId'
		}]);
		var oldDeptJC = new DepartJob("旧部门","jobChange.departmentByJcOldDept.deptId");
		var oldJobJC = new Job("旧职位","jobChange.jobByJcOldJob.jobId", oldDeptJC);
		oldJobJC.on('expand', function(comboBox){
			var deptId = Ext.getCmp("deptValue旧部门").getValue();
			this.getStore().load({
				params: {
					deptId: deptId
				}
			})
		});
		var newDeptJC = new DepartJob("新部门","jobChange.departmentByJcNewDept.deptId");
		var newJobJC = new Job("新职位","jobChange.jobByJcNewJob.jobId", newDeptJC);
		newJobJC.on('expand', function(comboBox){
			var deptId = Ext.getCmp("deptValue新部门").getValue();
			this.getStore().load({
				params: {
					deptId: deptId
				}
			})
		});
		JobChangeAddPanel.superclass.constructor.call(this,{
			//collapsible: true,
			//collapsed: true,
			frame: true,
			titile: '职员调动录入',
			labelWidth: 60,
			labelAlign: 'right',
			reader: reader,
			items:[{
				xtype: 'fieldset',
				title: '职员调动录入',
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
					emptyText: '不能为空',
					blankText: '请填写员工号',
					id: 'jc_empId',
					name: 'jobChange.employee.empId',
					listeners: {'blur': jcEmpFn}
				},{
					fieldLabel: '原部门',
					readOnly: true,
					msgTarget: 'side',
					blankText: '不能为空',
					allowBlank: false,
					id: 'jc_oldDept'
				},{
					xtype: 'hidden',
					id: 'jc_oldDeptId',
					name: 'jobChange.departmentByJcOldDept.deptId'
				}]
			},{
				layout: 'form',
				defaultType: 'textfield',
				defaults: {
					width: 100
				},
				width: 200,
				items: [{
					fieldLabel: '员工姓名',
					readOnly: true,
					id: 'jc_empName',
					name: 'jobChange.employee.empName'
				},{
					fieldLabel: '原职位',
					readOnly: true,
					allowBlank: false,
					msgTarget: 'side',
					blankText: '不能为空',
					id: 'jc_oldJob'
				},{
					xtype: 'hidden',
					id: 'jc_oldJobId',
					name: 'jobChange.jobByJcOldJob.jobId'
				}]
			},{
				layout: 'form',
				defaultType: 'textfield',
				defaults: {
					width: 100
				},
				width: 200,
				items: [{
					xtype: 'panel',
					height: 26
				},newDeptJC
				]
			},{
				layout: 'form',
				defaultType: 'textfield',
				defaults: {
					width: 100
				},
				width: 200,
				items: [{
					xtype: 'panel',
					height: 26
				},newJobJC ]
			},{
				layout: 'form',
				colspan: 2,
				items: [{
					xtype: 'textarea',
					fieldLabel: '调动原因',
					height: 150,
					width: '100%',
					name: 'jobChange.jcReason'
					}]
				},{
					layout: 'form',
					colspan: 2,
					items: [{
						xtype: 'textarea',
						fieldLabel: '备注',
						height: 150,
						width: '100%',
						name: 'jobChange.jcRemark'
					}]
				},{
					colspan: 4,
					buttonAlign: 'center',
					buttons: [{
						text: '保存',
						iconCls: 'save',
						handler: saveJCFn
					},{
						text: '关闭',
						iconCls: 'cancel',
						handler: cancelJCFn
					}]
				}]
				
			}]
			
		})
	}
});
	jcEmpFn = function(){
		var empId = Ext.get('jc_empId').dom.value;
		Ext.Ajax.request({
			url: 'emp_unique.action',
			success: empJuageSuccessFn,
			failure: failureFn,
			params: {
				empId: empId
			}
		})
	};
	empJuageSuccessFn = function(response, options){
		if("" != response.responseText){
			var obj = Ext.util.JSON.decode(response.responseText);
			Ext.get('jc_empName').dom.value = obj[0].empName;
			Ext.get('jc_oldDept').dom.value = obj[0].department.deptName;
			Ext.get('jc_oldJob').dom.value = obj[0].job.jobName;
			Ext.get('jc_oldDeptId').dom.value = obj[0].department.deptId;
			Ext.get('jc_oldJobId').dom.value = obj[0].job.jobId;
		}else{
			Ext.getCmp('jc_empId').markInvalid('此工号不存在');
		}
	};
	failureFn = function(respose, options){
		Ext.Msg.alert('提示','连接后台失败');
	};
	saveJCFn =  function(){
		if(!Ext.getCmp('jobChangeaAdd').getForm().isValid()){
			return;
		}
		Ext.getCmp("jobChangeaAdd").getForm().submit({
			url: 'jobChange_save.action',
			method: 'post',
			waitTitle: '提示',
			waitMsg: '正在保存数据...',
			success: saveJCSuccessFn,
			failure: failureFn
		})
	};
	saveJCSuccessFn = function(form, action){
		Ext.Msg.confirm("提示",action.result.msg, function(button, text){
			if(button == "yes"){
				Ext.getCmp("jobChangeAddWinId").destroy();
				Ext.getCmp("jobChangeInfo").getStore().load({
						params: {
					start: 0,
					limit: 20
				}
				});
			}
		});
	};
	cancelJCFn = function(){
		Ext.getCmp("jobChangeAddWinId").destroy();
	};
