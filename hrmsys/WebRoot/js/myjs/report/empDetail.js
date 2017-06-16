
EmpDetailPanel = Ext.extend(Ext.Panel,{
	id: 'empDetailPanelId',
	constructor: function(){
		EmpDetailPanel.superclass.constructor.call(this, {
			items: [{
				html: '<iframe src="" id="viewArea" width="100%" height="500" frameborder="0" scrolling="auto"></iframe>'
			}],
			tbar: new Ext.Toolbar({
				items: ['员工工号',{
					xtype: 'textfield',
					id: 'report_empId',
					width: 100,
					listeners: {'blur': blurFn2}
				},{
					text: '详细PDF单个预览',
					handler: this.viewFn
				},'-',{
					text: '简单PDF单个预览',
					handler: this.simpleViewFn	
				},'-',{
					text: '详细PDF单个导出',
					handler: this.exportFn
				},'-',{
					text: '详细PDF全部导出',
					handler: this.exportAllFn
				},'-',{
					text: '简单PDF导出',
					handler: this.simplePdfExportFn
				},'-',{
					text: '简单PDF全部导出',
					handler: this.simplePdfAllExportFn
				},'-',{
					text: '详细Excel全部导出',
					handler: this.detailXlsAllExportFn
				}]
			})
		})
	},
	viewFn: function(){
		var url = 'emp_detailPdfReport.action?empId=';
		var empId = Ext.get('report_empId').dom.value;
		if(empId == ''){
			Ext.Msg.alert('提示','请输入工号');
			return;
		}
		Ext.get('viewArea').dom.src = url+empId;
	},
	simpleViewFn: function(){
		var url = 'emp_simplePdfReport.action?empId=';
		var empId = Ext.get('report_empId').dom.value;
		if(empId == ''){
			Ext.Msg.alert('提示','请输入工号');
			return;
		}
		Ext.get('viewArea').dom.src = url+empId;
	},
	exportFn: function(){
		var empId = Ext.get('report_empId').dom.value;
		if(empId == ''){
			Ext.Msg.alert('提示','请输入工号');
			return;
		}
		document.location = 'emp_detailPdfExport.action?empId='+empId;
	},
	exportAllFn: function(){
		document.location = 'emp_detailPdfExport.action?empId=all';
	},
	simplePdfExportFn : function(){
		var empId = Ext.get('report_empId').dom.value;
		if(empId == ''){
			Ext.Msg.alert('提示','请输入工号');
			return;
		}
		document.location = 'emp_simplePdfExport.action?empId='+empId;
	},
	simplePdfAllExportFn: function(){
		document.location = 'emp_simplePdfExport.action?empId=all';
	},
	detailXlsAllExportFn: function(){
		document.location = 'emp_detailXlsExport.action';
	}
});
	blurFn2 = function(value){
		var empId = value.getRawValue();
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