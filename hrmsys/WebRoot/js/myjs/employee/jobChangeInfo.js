/**
 * @author sux
 * @desc 职员调动信息
 * @date 2011-02-13
 */
Ext.namespace("hrmsys.jobChange");

var JobChangeInfoPanel = Ext.extend(Ext.grid.GridPanel,{
	id: 'jobChangeInfo',
	constructor: function(){
	Ext.QuickTips.init();
		var sm = new Ext.grid.CheckboxSelectionModel();
		var number = new Ext.grid.RowNumberer();
		var cm = new Ext.grid.ColumnModel([
			number, sm,
		{
			header: '员工',
			dataIndex: 'employee',
			align: 'center'
		},{
			header: '原部门',
			dataIndex: 'departmentByJcOldDept',
			align: 'center'
		},{
			header: '原职位',
			dataIndex: 'jobByJcOldJob',
			align: 'center'
		},{
			header: '新部门',
			dataIndex: 'departmentByJcNewDept',
			align: 'center'
		},{
			header: '新职位',
			dataIndex: 'jobByJcNewJob',
			align: 'center'
		}]);
		 jobChangeStore = new Ext.data.JsonStore({
			url: 'jobChange_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['jcId',{name: 'employee', convert: function(v){return v.empName}},
				{name: 'departmentByJcNewDept', convert: function(v){return v.deptName}},
				{name: 'departmentByJcOldDept', convert: function(v){return v.deptName}},
				{name: 'jobByJcNewJob', convert: function(v){return v.jobName}},
				{name: 'jobByJcOldJob', convert: function(v){return v.jobName}}]
		});
		JobChangeInfoPanel.superclass.constructor.call(this,{
			width: Ext.getCmp('mainTab').getActiveTab().getInnerWidth(),
			height: Ext.getCmp('mainTab').getActiveTab().getInnerHeight(),
			/**表格高度自适应 document.body.clientHeight浏览器页面高度 start**/
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight(document.body.clientHeight-140);
				Ext.grid.GridPanel.prototype.doLayout.call(this); 
			} ,
			viewConfig:{
				forceFit: true,
				enableRowBody:true//是否包含行体
			},
			//columns:[{header: 'kk',dataIndex: 'jcId'}],
			cm: cm,
			sm: sm,
			store: jobChangeStore,
			tbar: new Ext.Toolbar({
				items:['条目:',{
					width: 80,
					xtype: 'combo',
					mode: 'local',
					store: new Ext.data.SimpleStore({
						fields: ['name', 'value'],
						data: [['empId','员工工号'],['empName','员工姓名']]
					}),
					displayField: 'value',
					valueField: 'name',
					id: 'jc_condition',
					triggerAction: 'all',
					editable: false
						
				},'&nbsp;内容:',{
					xtype: 'textfield',
					id: 'jc_conditionValue',
					width: 80
				},{
					text: '查询',
					iconCls: 'search',
					id: 'jobch_query',
					handler: this.jobChangeQueryFn
				},{
					text: '删除',
					iconCls: 'delete',
					id: 'jobch_delete',
					hidden: 'true',
					handler: this.jobChangeDelFn
				},{
					text: '添加',
					iconCls: 'add',
					id: 'jobch_add',
					hidden: 'true',
					handler: this.jobChangeAddFn
				},{
					text: '修改',
					iconCls: 'update',
					id: 'jobch_update',
					hidden: 'true',
					handler: this.jobChangeUpdateFn
				},{
					text: '详情',
					iconCls: 'detail',
					id: 'jobch_detail',
					hidden: 'true',
					handler: this.jobChangeDetailFn
				}]
			}),
			bbar: new PagingToolbar(jobChangeStore, 20)
	});
		jobChangeStore.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	},
	jobChangeQueryFn: function(){
		var condition = Ext.getCmp('jc_condition').getValue();
		var conditionValue = Ext.getCmp('jc_conditionValue').getValue();
		jobChangeStore.load({
			params: {
				condition: condition,
				conditionValue: conditionValue,
				start: 0,
				limit: 20
			}
		});
	},
	jobChangeAddFn: function(){
		var jobChangeAddWin = new JobChangeAddWin();
		jobChangeAddWin.show();
	},
	jobChangeDelFn: function(){
		gridDel('jobChangeInfo','jcId','jobChange_delete.action');
	},
	jobChangeUpdateFn: function(){
		var jobChangeAddWin = new JobChangeAddWin();
		jobChangeAddWin.title = '员工职位变动修改';
		var selectionModel = Ext.getCmp('jobChangeInfo').getSelectionModel();
		var record = selectionModel.getSelections();
		if(record.length != 1){
			Ext.Msg.alert('提示','请选择一个');
			return;
		}
		var jcId = record[0].get('jcId');
		Ext.getCmp('jobChangeaAdd').getForm().load({
			url: 'jobChange_edit.action',
			params: {
				jcId: jcId
			},
			success: function(form, action){
				var obj = Ext.util.JSON.decode(action.response.responseText);
				//Ext.getCmp("jobValue旧职位").setRawValue(obj[0].jobByJcOldJob.jobName);
				//Ext.getCmp("deptValue旧部门").setRawValue(obj[0].departmentByJcOldDept.deptName);
				Ext.get('jc_oldDept').dom.value = obj[0].jobByJcOldJob.jobName;
				Ext.get('jc_oldJob').dom.value = obj[0].departmentByJcOldDept.deptName;
				Ext.getCmp("deptValue新部门").setRawValue(obj[0].departmentByJcNewDept.deptName);
				Ext.getCmp("jobValue新职位").setRawValue(obj[0].jobByJcNewJob.jobName);
			}
		})
		jobChangeAddWin.show();
	},
	jobChangeDetailFn: function(){
		var jobChangeDetailWin = new JobChangeDetailWin();
		var selectionModel = Ext.getCmp('jobChangeInfo').getSelectionModel();
		var record = selectionModel.getSelections();
		if(record.length != 1){
			Ext.Msg.alert('提示','请选择一个');
			return;
		}
		var jcId = record[0].get('jcId');
		Ext.getCmp('jobChangeaDetail').getForm().load({
			url: 'jobChange_edit.action',
			params: {
				jcId: jcId
			}
		})
		jobChangeDetailWin.show();
	}
})