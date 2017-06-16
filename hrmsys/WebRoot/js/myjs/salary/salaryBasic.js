/**
 * 员工工资基本信息管理
 * @author sux 2011-02-23
 * @memberOf {TypeName} 
 * @return {TypeName} 
 */
var SalaryBasic = Ext.extend(Ext.grid.EditorGridPanel,{
	id: 'salaryBasicId',
	constructor: function(){
		Ext.form.Field.prototype.msgTarget = 'title';
		var number = new Ext.grid.RowNumberer();
		var sm = new Ext.grid.CheckboxSelectionModel();
		var salBasicStore = new Ext.data.JsonStore({
			url: 'salBasic_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['sbId','employee','sbBasic','sbEndowment','sbHospitalization','sbUnemployment','sbInjury',
				'sbMaternity','sbHousing','sbTraffic','sbEatery','sbTelephone']
		})
		var cm = new Ext.grid.ColumnModel([
			number, sm,
		{
			header: '编号',
			dataIndex: 'sbId',
			align: 'center'
		},{
			header: '员工工号',
			dataIndex: 'employee',
			align: 'center',
			renderer: function(value){
				//判断其类型是否为object类型
				if(typeof(value) == "object"){
					return value.empId;
				}else{
					return value;
				}
			},
			editor: new Ext.form.TextField({
				allowBlank: false,
				blankText: '不能为空',	 
				id: 'salaryBasicEmp',
				listeners: {'blur':this.uniqueEmp}
			})
		},{
			header: '员工姓名',
			dataIndex: 'employee',
			align: 'center',
			renderer: function(value){
				if(value)
				return value.empName;
			}
		},{
			header: '基本工资',
			dataIndex: 'sbBasic',
			align: 'center',
			editor: new Ext.form.TextField()
		},{
			header: '养老保险',
			dataIndex: 'sbEndowment',
			align: 'center',
			editor: new Ext.form.ComboBox({
				mode: 'local',
				triggerAction: 'all',
				editable: false,
				store: new Ext.data.SimpleStore({
					fields: ['name','value'],
					data: [['是','1'],['否','0']]
				}),
				displayField: 'name',
				valueField: 'value'
			}),
			renderer: function(value){
				if(value == '1') return '是';
				return '否';
			}
		},{
			header: '医疗保险',
			dataIndex: 'sbHospitalization',
			align: 'center',
			editor: new Ext.form.ComboBox({
				mode: 'local',
				triggerAction: 'all',
				editable: false,
				store: new Ext.data.SimpleStore({
					fields: ['name','value'],
					data: [['是','1'],['否','0']]
				}),
				displayField: 'name',
				valueField: 'value'
			}),
			renderer: function(value){
				if(value == '1') return '是';
				return '否';
			}
		},{
			header: '失业保险',
			dataIndex: 'sbUnemployment',
			align: 'center',
			editor: new Ext.form.ComboBox({
				mode: 'local',
				editable: false,
				triggerAction: 'all',
				store: new Ext.data.SimpleStore({
					fields: ['name','value'],
					data: [['是','1'],['否','0']]
				}),
				displayField: 'name',
				valueField: 'value'
			}),
			renderer: function(value){
				if(value == '1') return '是';
				return '否';
			}
		},{
			header: '工伤保险',
			dataIndex: 'sbInjury',
			align: 'center',
			editor: new Ext.form.ComboBox({
				mode: 'local',
				triggerAction: 'all',
				editable: false,
				store: new Ext.data.SimpleStore({
					fields: ['name','value'],
					data: [['是','1'],['否','0']]
				}),
				displayField: 'name',
				valueField: 'value'
			}),
			renderer: function(value){
				if(value == '1') return '是';
				return '否';
			}
		},{
			header: '生育保险',
			dataIndex: 'sbMaternity',
			align: 'center',
			editor: new Ext.form.ComboBox({
				mode: 'local',
				triggerAction: 'all',
				editable: false,
				store: new Ext.data.SimpleStore({
					fields: ['name','value'],
					data: [['是','1'],['否','0']]
				}),
				displayField: 'name',
				valueField: 'value'
			}),
			renderer: function(value){
				if(value == '1') return '是';
				return '否';
			}
		},{
			header: '住房公积金',
			dataIndex: 'sbHousing',
			align: 'center',
			editor: new Ext.form.ComboBox({
				mode: 'local',
				editable: false,
				triggerAction: 'all',
				store: new Ext.data.SimpleStore({
					fields: ['name','value'],
					data: [['是','1'],['否','0']]
				}),
				displayField: 'name',
				valueField: 'value'
			}),
			renderer: function(value){
				if(value) return '是';
				return '否';
			}
		},{
			header: '交通补贴',
			dataIndex: 'sbTraffic',
			align: 'center',
			editor: new Ext.form.NumberField()
		},{
			header: '餐费补贴',
			dataIndex: 'sbEatery',
			align: 'center',
			editor: new Ext.form.NumberField()
		},{
			header: '通迅补贴',
			dataIndex: 'sbTelephone',
			align: 'center',
			editor: new Ext.form.NumberField()
		}])
		SalaryBasic.superclass.constructor.call(this, {
			width: Ext.getCmp('mainTab').getActiveTab().getInnerWidth(),
			height: Ext.getCmp('mainTab').getActiveTab().getInnerHeight(),
			/**表格高度自适应 document.body.clientHeight浏览器页面高度 start**/
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight(document.body.clientHeight-140);
				Ext.grid.GridPanel.prototype.doLayout.call(this); 
			} ,
			viewConfig: {
				forceFit: true
			},
			sm: sm, 
			cm: cm,
			store: salBasicStore,
			tbar: new Ext.Toolbar({
				items: ['条目:',{
					xtype: 'combo',
					width: 80,
					triggerAction: 'all',
					editable: false,
					mode: 'local',
					store: new Ext.data.SimpleStore({
						fields: ['name','value'],
						data: [[" "," "],["empId","员工工号"],["empName","员工姓名"]]
					}),
					id: 'sb_condition',
					displayField: 'value',
					valueField: 'name'
				},'内容',{
					xtype: 'textfield',
					id: 'sb_conditionValue',
					width: 80
				},{
					text: '查看',
					handler: salViewFn,
					iconCls: 'search'
				},{
					text: '删除',
					handler: salDelFn,
					id: 'salb_delete',
					hidden: 'true',
					iconCls: 'delete'
				},{
					text: '新增',
					id: 'salb_add',
					hidden: 'true',
					handler: salNewFn,
					iconCls: 'add'
				},{
					text: '修改或保存',
					iconCls: 'save',
					id: 'salb_saveorupdate',
					hidden: 'true',
					handler: salUpdateOrSaveFn
				}]				
			}),
			bbar: new PagingToolbar(salBasicStore, 20)
		})
		salBasicStore.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	},
	uniqueEmp: function(obj){
		var empId = obj.getValue();
		Ext.Ajax.request({
			url: 'salBasic_uniqueEmp.action',
			success: function(response, options){
				var obj = Ext.util.JSON.decode(response.responseText);
				if(obj.msg == false){
					Ext.Msg.alert("提示","此员工的工资已配置");
				}
			},
			failure: hrmsys.util.common.failure,
			params: {
				empId: empId
			}
		})
	}
});
salViewFn = function(){
	var condition = Ext.getCmp("sb_condition").getValue();
	var conditionValue = Ext.getCmp("sb_conditionValue").getValue();
	Ext.getCmp('salaryBasicId').getStore().load({
		params: {
			type: 'query',
			condition: condition,
			conditionValue: conditionValue,
			start: 0,
			limit: 20
		}
	});
};
salDelFn = function(){
	gridDel('salaryBasicId','sbId', 'salBasic_delete.action');
};
salNewFn = function(){
	var DefaultRecord = new Ext.data.Record.create([{name: 'sbId', mapping: 0},{name: 'employee', mapping: 1},
		{name: 'empName', mapping:2},{name: 'sbBasic', mapping: 3},{name: 'sbEndowment', mapping: 4},
		{name: 'sbHospitalization', mapping: 5},{name: 'sbUnemployment', mapping: 6},{name: 'sbInjury', mapping: 7},
		{name: 'sbMaternity', mapping: 8},{name: 'sbHousing', mapping:9},{name: 'sbTraffic', mapping: 10},
		{name: 'sbEatery', mapping: 11},{name: 'sbTelephone', mapping: 12}]);
	var num = Ext.getCmp('salaryBasicId').getStore().getCount();
	var newRecord = new DefaultRecord({
		sbId: num+1
	});
	Ext.getCmp('salaryBasicId').getStore().insert(0,newRecord);	
};
salUpdateOrSaveFn = function(){
	var modifiedRecords = Ext.getCmp('salaryBasicId').getStore().getModifiedRecords();
	var salBasics = reSalBasicJson(modifiedRecords);
	//alert(salBasics);
	Ext.Ajax.request({
		url: 'salBasic_save.action',
		method: 'post',
		waitTitle: '提示',
		waitMsg: '正在保存数据...',
		params: {
			json: salBasics
		},
		success: salBasicSuccessFn,
		failure: boonModifyfailureFn
	})
};
salBasicSuccessFn = function(response, options){
	var datas = Ext.util.JSON.decode(response.responseText);
	Ext.Msg.alert('提示',datas.msg,function(){
		Ext.getCmp('salaryBasicId').getStore().load({
			params: {
				start: 0,
				limit: 20
			}
		});
	});
};
reSalBasicJson = function(modifiedRecords){
	var count = modifiedRecords.length;
	var salBasics='';
	//有修改或保存
	if(count > 0){
		salBasics = "[";
		for(i=0; i<count; i++){
			salBasics += "{";
			var sbId = modifiedRecords[i].get('sbId');
			var employee = modifiedRecords[i].get('employee');
			if(typeof(employee) == "object"){
				var empId = employee.empId;
			}else{
				var empId = employee;
			}
			//var empName = modifiedRecords[i].get('empName');
			var sbBasic = modifiedRecords[i].get('sbBasic');
			var sbEndowment = modifiedRecords[i].get('sbEndowment');
			var sbHospitalization = modifiedRecords[i].get('sbHospitalization');
			var sbUnemployment = modifiedRecords[i].get('sbUnemployment');
			var sbInjury = modifiedRecords[i].get('sbInjury');
			var sbEatery = modifiedRecords[i].get('sbEatery');
			var sbMaternity = modifiedRecords[i].get('sbMaternity');
			var sbHousing = modifiedRecords[i].get('sbHousing');
			var sbTraffic = modifiedRecords[i].get('sbTraffic');
			var sbTelephone = modifiedRecords[i].get('sbTelephone');
			salBasics += '"sbId":'+sbId+', "empId":"'+empId+'","sbBasic":'+sbBasic+
			',"sbEndowment":'+sbEndowment+', "sbHospitalization":'+sbHospitalization+', "sbUnemployment":'+sbUnemployment+
			', "sbInjury":'+sbInjury+', "sbEatery":'+sbEatery+', "sbMaternity":'+sbMaternity+', "sbHousing":'+sbHousing+
			', "sbTraffic":'+sbTraffic+', "sbTelephone":'+sbTelephone+'}';
			if( i != count-1)
				salBasics += ","
		}
		salBasics += "]"
	}
	return salBasics;
}