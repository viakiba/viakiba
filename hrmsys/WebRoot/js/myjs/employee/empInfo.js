/**
 * @author sux
 * @time 2011-1-15
 * @desc 
 * 注意各个TabPanel中的id都不要相同，若有相同则造成显示异常
 */
Ext.namespace("hrmsys.employee")
empInfoGridPanel = Ext.extend(Ext.grid.GridPanel,{
	id: 'empInfo',
	constructor: function(){
		Ext.QuickTips.init();
		empInfoStore = new Ext.data.JsonStore({
			url: 'emp_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['empId','empName','empSex',
			{name: 'department', convert: function(v){return v.deptName}},
			{name: 'job', convert: function(v){return v.jobName}}]
		}); 
		var sm = new Ext.grid.CheckboxSelectionModel();
		var number = new Ext.grid.RowNumberer();
		empInfoGridPanel.superclass.constructor.call(this,{
			viewConfig: {
				forceFit: true
			},
			width: Ext.getCmp('mainTab').getActiveTab().getInnerWidth(),
			height: Ext.getCmp('mainTab').getActiveTab().getInnerHeight(),
			/**表格高度自适应 document.body.clientHeight浏览器页面高度 start**/
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight(document.body.clientHeight-140);
				Ext.grid.GridPanel.prototype.doLayout.call(this); 
			} ,
			sm: sm,
			columns: [
				number,sm,
			{
				header: '员工工号',
				dataIndex: 'empId',
				align: 'center'
			},{
				header: '员工姓名',
				dataIndex: 'empName',
				align: 'center'
			},{
				header: '员工性别',
				dataIndex: 'empSex',
				align: 'center',
				renderer: function(value){
					if(value == 1) 	return "男";
					else return "女";
				}
			},{
				header: '部门名称',
				dataIndex: 'department',
				align: 'center'
			},{
				header: '职位',
				dataIndex: 'job',
				align: 'center'
			}],
			store: empInfoStore,
			//添加遮罩
			loadMask: {msg: '数据正在加载中,请稍后!'},
			
			tbar: new Ext.Toolbar({
			bodyStyle: 'padding-left: 5px;',
			//depart.js中定义了depart
			items: ['部门:',new depart("员工"),'&nbsp;条目:',{
				xtype: 'combo',
				mode: 'local',//加载本地数据，必须加入
				store: new Ext.data.SimpleStore({
					fields: ['name','value'],
					data: [["","无"],['empId','工号'],['empName','姓名']]
				}),
				displayField: 'value',
				valueField: 'name',
				id: 'emp_condition',
				width: 50,
				autoLoad: true,
				listWidth: 50,
				editable: false,
				/*默认值 为query,当输入框有值时下拉列表将根据该值只显示过滤后的列表数据，可设置为all，不执行过滤*/
				triggerAction: 'all'
			},'&nbsp;内容:',{
				xtype: 'textfield',
				id: 'emp_conditionValue',
				width: 80,
				listeners : {
		                specialkey : function(field, e) {//添加回车事件
		                    if (e.getKey() == Ext.EventObject.ENTER) {
		                     // Ext.getCmp('empInfo').viewJob;
		                    }
		                }
					}
			},{
				text: '&nbsp;&nbsp;查询',
				tooltip: '查询员工信息',
				iconCls: 'search',
				id: 'emp_query',
				handler: this.viewJob
			},{
				text: '删除',
				tooltip: '删除员工信息',
				iconCls: 'delete',
				id: 'emp_delete',
				hidden: 'true',
				handler: this.empDelFn
			},{
				text: '添加',
				iconCls: 'add',
				id: 'emp_add',
				hidden: 'true',
				tooltip: '添加员工信息',
				handler: this.empAddFn
			},{
				text: '修改',
				iconCls: 'update',
				id: 'emp_update',
				tooltip: '修改员工信息',
				hidden: 'true',
				handler: this.empUpdateFn
			},{
				text: '详情',
				iconCls: 'detail',
				tooltip: '查看员工信息',
				id: 'emp_detail',
				hidden: 'true',
				handler: this.empDetailFn
			}]
		  }),
		  
		  	bbar: new PagingToolbar(empInfoStore, 20)
		});
		
		empInfoStore.load({
			params: {
				deptId: "",
				start: 0,
				limit: 20
			}
		}); 
	},
	viewJob: function(){
		var deptValue = Ext.getCmp('deptValue员工').getValue();
		var condition = Ext.getCmp('emp_condition').getValue();
		var conditionValue = Ext.getCmp('emp_conditionValue').getValue();
		//alert(deptValue+' '+condition+' '+conditionValue);
		empInfoStore.load({
			params: {
				deptId: deptValue,
				condition: condition,
				conditionValue: conditionValue,
				start: 0,
				limit: 20
			}
		});
	},
	empDelFn: function(){
		gridDel('empInfo','empId', 'emp_delete.action');
	},
	empAddFn: function(){
		var empUpdateWin = new EmpUpdateWin();
		empUpdateWin.show();
	},
	empUpdateFn: function(){
		var empUpdateWin = new EmpUpdateWin();
		empUpdateWin.title = '职员信息修改';
		var selectionModel = Ext.getCmp('empInfo').getSelectionModel();
		var record = selectionModel.getSelections();
		if(record.length != 1){
			Ext.Msg.alert('提示','请选择一个');
			return;
		}
		var empId = record[0].get('empId');
		Ext.getCmp('empForm').getForm().load({
			method: 'post',
			url: 'emp_intoUpdate.action',
			params: {
				empId: empId
			},
			success: function(form, action){
				var obj = Ext.util.JSON.decode(action.response.responseText);
				Ext.getCmp("deptValue所在部门").setRawValue(obj[0].department.deptName);
				Ext.getCmp("jobValue职位").setRawValue(obj[0].job.jobName);
			}
		})
		empUpdateWin.show();
	},
	empDetailFn: function(){
		var empDetailWin = new EmpDetailWin();
		var selectionModel = Ext.getCmp('empInfo').getSelectionModel();
		var record = selectionModel.getSelections();
		if(record.length != 1){
			Ext.Msg.alert('提示','请选择一个');
			return;
		}
		var empId = record[0].get('empId');
		Ext.getCmp('empDetailId').getForm().load({
			url: 'emp_intoUpdate.action',
			method: 'post',
			params: {
				empId: empId
			}
		})
		empDetailWin.show();
	}
});


//http://sichen84.javaeye.com/blog/408658


