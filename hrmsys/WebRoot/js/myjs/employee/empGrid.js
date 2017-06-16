/**
 * @author sux
 * @time 2011-04-04
 * @desc 
 */

EmpGridWin = Ext.extend(Ext.Window,{
	id: 'empGridWinId',
	constructor: function(){
		var empGridPanel = new EmpGridPanel();
		EmpGridWin.superclass.constructor.call(this, {
			width: 550,
			height: 350,
			resizable: false, //不能改变窗体大小 
			title: '员工信息',
			collapsible: true,
			modal: true,
			items: [empGridPanel]
		})
	}
});
EmpGridPanel = Ext.extend(Ext.grid.GridPanel,{
	id: 'empGridId',
	constructor: function(){
		empInfoStore = new Ext.data.JsonStore({
			url: 'emp_list.action',
			fields: ['empId','empName','empSex',
			{name: 'department', convert: function(v){return v.deptName}},
			{name: 'job', convert: function(v){return v.jobName}}]
		}); 
		var number = new Ext.grid.RowNumberer();
		EmpGridPanel.superclass.constructor.call(this,{
			height: 320,
			viewConfig: {
				forceFit: true
			},
			columns: [
				number,
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
					data: [["",""],['empId','工号'],['empName','姓名']]
				}),
				displayField: 'value',
				valueField: 'name',
				id: 'condition',
				width: 50,
				autoLoad: true,
				listWidth: 50,
				editable: false,
				/*默认值 为query,当输入框有值时下拉列表将根据该值只显示过滤后的列表数据，可设置为all，不执行过滤*/
				triggerAction: 'all'
			},'&nbsp;内容:',{
				xtype: 'textfield',
				id: 'conditionValue',
				width: 80
			},{
				text: '&nbsp;&nbsp;查询',
				iconCls: 'search',
				handler: this.viewJob
			}]
		  }),
		  	bbar: new PagingToolbar(empInfoStore, 10)
		});
		
		empInfoStore.load({
			params: {deptId: ""}
		}); 
	},
	viewJob: function(){
		var deptValue = Ext.getCmp('deptValue员工').getValue();
		var condition = Ext.getCmp('condition').getValue();
		var conditionValue = Ext.getCmp('conditionValue').getValue();
		empInfoStore.load({
			params: {
				deptId: deptValue,
				condition: condition,
				conditionValue: conditionValue
			}
		});
	}
});




