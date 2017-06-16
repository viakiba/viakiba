
SalaryPanel = Ext.extend(Ext.Panel,{
	id: 'salaryPanelId',
	constructor: function(){
		SalaryPanel.superclass.constructor.call(this, {
			items: [{
				html: '<iframe src="" id="viewArea" width="100%" height="500" frameborder="0" scrolling="auto"></iframe>'
			}],
			tbar: new Ext.Toolbar({
				items: ['员工工号',{
					xtype: 'textfield',
					id: 'report_empId',
					width: 80,
					listeners: {'blur': blurFn2}
				},'年份',{
					xtype: 'textfield',
					width: 80,
					id: 'year'
				},'月份',{
					xtype: 'combo',
					mode: 'local',
					editable: false,
					store: new Ext.data.SimpleStore({
						fields: ['name','value'],
						data: [[0,"全部"],[1,"一月"],[2,"二月"],[3,"三月"],[4,"四月"],[5,"五月"],
								[6,"六月"],[7,"七月"],[8,"八月"],[9,"九月"],[10,"十月"],[11,"十一月"],
								[12,"十二月"]]
					}),
					id: 'month',
					width: 70,
					triggerAction: 'all',
					displayField: 'value',
					valueField: 'name'
				},{
					text: '工资单预览',
					handler: this.viewFn
				},'-',{
					text: '工资单导出',
					handler: this.exportFn	
				}]
			})
		})
	},
	viewFn: function(){
		var url = 'salary_view.action?empId=';
		var empId = Ext.get('report_empId').dom.value;
		var year = Ext.get('year').dom.value;
		var month = Ext.getCmp('month').getValue();
		Ext.get('viewArea').dom.src = url+empId+"&year="+year+"&month="+month;
	},
	exportFn: function(){
		var url = 'emp_report.action?empId=';
		var empId = Ext.get('report_empId').dom.value;
		var year = Ext.get('year').dom.value;
		var month = Ext.getCmp('month').getValue();
		document.location = 'salary_export.action?empId='+empId+"&year="+year+"&month="+month;
	}
});
	blurFn2 = function(value){
		var empId = value.getRawValue();
		if(empId != '')
		Ext.Ajax.request({
			url: 'emp_isExist.action',
			method: 'post',
			params: {
				empId: empId
			},
			success: isExistSuccessFn2,
			failure: save_failure
		})
	};
	isExistSuccessFn2 = function(response, options){
		if(response.responseText == ''){
			Ext.Msg.alert('提示','此工号不存在');
		}
	}