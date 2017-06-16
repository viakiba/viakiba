/**
 * @author sux
 * @time 2011-1-15
 * @desc 部门职位管理
 */
jobInfoGrid = Ext.extend(Ext.grid.GridPanel,{
	id: 'jobGrid',
	constructor: function(){
		Ext.QuickTips.init();
		var dept = new depart("部门");
		var number = new Ext.grid.RowNumberer();
		var sm = new Ext.grid.CheckboxSelectionModel(),
		jobInfoStore = new Ext.data.JsonStore({
			url: 'job_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			//nocache: true,
			/*下面fields中利用convert获取json中嵌套的对象*/
			fields: [{name: 'department',convert: function(v){return v.deptName}},'jobId','jobName','jobBasicWage','jobRemark','operator']
		});
		jobInfoGrid.superclass.constructor.call(this,{
			width: Ext.getCmp('mainTab').getActiveTab().getInnerWidth(),
			height: Ext.getCmp('mainTab').getActiveTab().getInnerHeight(),
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight(document.body.clientHeight-140);
				Ext.grid.GridPanel.prototype.doLayout.call(this); 
			} ,
			viewConfig: {
				forceFit: true
			},
			autoWidth: true,
			sm : sm,
			/*这里不需要这设置此参数autoHeight: true，在相应的JSP文件中设置了Grid的宽度和高度，加了只会画蛇添足*/ 
			columns: [
				number, sm,
			{
				header: '部门名称',
				dataIndex: 'department',
				align: 'center'
			},{
				header: '职位编号',
				dataIndex: 'jobId',
				id: 'jobId',
				align: 'center'
			},{
				header: '职位名称',
				dataIndex: 'jobName',
				align: 'center'
			},{
					header: '岗位工资',
					dataIndex: 'jobBasicWage',
					align: 'center'
			},{
				header: '备注',
				dataIndex: 'jobRemark',
				renderer: Ext.hrmsys.grid.tooltip.subLength,
				align: 'center'
			}],
			store: jobInfoStore,
			loadMask: {msg: '数据正在加载中,请稍后!'},
			
			tbar: new Ext.Toolbar({
			style: 'padding-left: 5px;',
			items: ['部门:',dept,{
				text: '&nbsp;&nbsp;查询',
				tooltip: '查询职位',
				iconCls: 'search',
				id: 'job_query',
				hidden: 'true',
				handler: this.viewJob
			},{
				text: '删除',
				id: 'job_delete',
				iconCls: 'delete',
				tooltip: '删除职位',
				hidden: 'true',
				handler: this.delJobFn
			},{
				text: '添加',
				id: 'job_add',
				tooltip: '添加职位',
				iconCls: 'add',
				hidden: 'true',
				handler: this.addJobFn
			},{
				text: '修改',
				tooltip: '修改职位',
				hidden: 'true',
				iconCls: 'update',
				id: 'job_update',
				handler: this.updateFn
			}]
		  }),
		  
		  	bbar: new PagingToolbar(jobInfoStore, 20)
		});
		
		jobInfoStore.load({
			params: {
				deptId: "",
				start: 0,
				limit: 20
			}
		});
	},
	viewJob: function(){
		/*Ext.get('deptValue').dom.value
		  Ext.get('deptValue').getValue()
		  Ext.getCmp('deptValue').getRawValue()
		     以上三种可获得displayField
		    下面方法为获得valueField值
		*/
		var deptValue = Ext.getCmp('deptValue部门').getValue();
		//重新加载数据
		Ext.getCmp("jobGrid").getStore().load({
			params: {
				deptId: deptValue,
				start:	0,
				limit: 20
			}
		});
	},
	delJobFn: function(){
		gridDel('jobGrid','jobId', 'job_delete.action');
	},
	addJobFn: function(){
		var jobAddWin = new JobAddWin();
		jobAddWin.show();
	},
	updateFn: function(){
		var jobAddWin = new JobAddWin();
		jobAddWin.title = '职位信息修改';
		var selectionModel = Ext.getCmp('jobGrid').getSelectionModel();
		var record = selectionModel.getSelections();
		if(record.length != 1){
			Ext.Msg.alert('提示','请选择一个');
			return;
		}
		var jobId = record[0].get('jobId');
		//Ext.getCmp('jobAddFormId').dept.setValue(jobId);
		Ext.getCmp('jobAddFormId').getForm().load({
			url: 'job_intoUpdate.action',
			params: {
				jobId: jobId
			}
		})
		jobAddWin.show();
	}
});





