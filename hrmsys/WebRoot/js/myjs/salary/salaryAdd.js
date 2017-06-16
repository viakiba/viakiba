Ext.namespace("hrmsys.salaryAdd");
SalaryAddPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'salaryAddPanelId',
	constructor: function(){
		Ext.form.Field.prototype.msgTarget = 'side';
		Ext.QuickTips.init();
		SalaryAddPanel.superclass.constructor.call(this, {
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
						fieldLabel: '员工工号',
						id: 'salEmpId',
						allowBlank: false,
						blankText: '不能为空',
						name: 'salary.employee.empId',
						listeners: {'change':changeFn}
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '员工姓名',
						id: 'salEmpName',
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
						id: 'salBasic',
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
						id: 'salJob',
						name: 'salary.salJob',
						style: 'background: #dfe8f6;',
						readOnly: true
					}]
				},{
					xtype:'hidden',
					name: 'salary.salId'
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
						allowBlank: false,
						blankText: '不能为空',
						id: 'salNormal',
						name: 'salary.salNormal'
					}]
				},{
					columnWidth: .25,
					layout: 'form',
					items:[{
						xtype: 'textfield',
						fieldLabel: '旷工工时',
						allowBlank: false,
						blankText: '不能为空',
						id: 'salAbsenteeism',
						name: 'salary.salAbsenteeism'
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '全勤奖',
						allowBlank: false,
						blankText: '不能为空',
						id: 'salAll',
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
							id: 'salAbsenteeismMoney',
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
						id: 'salEndowmentint',
						style: 'background: #dfe8f6;',
						readOnly: true
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '失业保险',
						id: 'salUnemploymentint',
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
						id: 'salHospitalizationint',
						style: 'background: #dfe8f6;',
						readOnly: true
					}]
				},{
					columnWidth: .25
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
						id: 'salEateryfloat',
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
						id: 'salTrafficfloat',
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
						id: 'salTelephone',
						readOnly: true
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '其它补贴',
						allowBlank: false,
						blankText: '不能为空',
						name: 'salary.salAllowance',
						id: 'salAllowance'
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
						width: 415,
						height: 100,
						name: 'salary.salRemark'
					}]
				},{
					layout: 'form',
					columnWidth: .25,
					items: [{
						xtype: 'textfield',
						fieldLabel: '个人税',
						name: 'salary.salRevenue',
						id: 'salRevenue',
						style: 'background: #dfe8f6;',
						readOnly: true
					},{
						xtype: 'textfield',
						fieldLabel: '月份',
						id: 'salMonth',
						allowBlank: false,
						blankText: '不能为空',
						name: 'salary.salMonth',
						listeners: {'blur': monthFn}
					}]
				},{
					layout: 'column',
					columnWidth: .25,
					items: [{
						columnWidth: .85,
						layout: 'form',
						items: [{
							xtype: 'textfield',
							fieldLabel: '实发工资',
							name: 'salary.salMoney',
							id: 'salMoney',
							style: 'background: #dfe8f6;',
							readOnly: true
						}]
					},{
						columnWidth: .15,
						layout: 'form',
						items: [{
							xtype: 'button',
							text: '计算',
							handler: salCaculateFn
						}]
					}]
				}]
			},{
				buttonAlign: 'center',
				buttons: [{
					text: '保存',
					iconCls: 'save',
					handler: saveSalaryFn
				}]
			}]
			}]
		})		
	}
});
/**
 * 员工工号失去焦点事件函数 
 */
changeFn = function(){
	var sal_empId = Ext.getCmp('salEmpId').getValue();
	Ext.Ajax.request({
			url: 'emp_isExist.action',
			success: function(response, options){
				if(response.responseText != ""){
					Ext.getCmp('salaryAddPanelId').getForm().reset();//清楚以前的数据
					Ext.Ajax.request({
						url: 'salary_distill.action',
						params: {
							empId: sal_empId
						},
						success: distillSuccessFn,
						failure: distillFailureFn
					})
				}else{
					Ext.getCmp('salEmpId').markInvalid('此工号不存在');
				}
			},
			failure: saveSalaryFailureFn,
			params: {
				empId: sal_empId
			}
		});
};
distillSuccessFn = function(response, options){
	var datas = Ext.util.JSON.decode(response.responseText);
	Ext.get('salEmpId').dom.value = datas.empId;
	Ext.get('salBasic').dom.value = datas.salBasic;
	Ext.get('salEmpName').dom.value = datas.empName;
	Ext.get('salJob').dom.value = datas.salJob;
	Ext.get('salEndowmentint').dom.value = datas.salEndowmentint;
	Ext.get('salUnemploymentint').dom.value = datas.salUnemploymentint;
	Ext.get('salHospitalizationint').dom.value = datas.salHospitalizationint;
	Ext.get('salEateryfloat').dom.value = datas.salEateryfloat;
	Ext.get('salTelephone').dom.value = datas.salTelephone;
	Ext.get('salTrafficfloat').dom.value = datas.salTrafficfloat;
};
distillFailureFn = function(response, options){
	Ext.Msg.alert('提示','数据提取连接后台失败...');
};
/**
 * 工资计算
 */
salCaculateFn = function(){
	if(!Ext.getCmp('salaryAddPanelId').getForm().isValid()){
		return;
	}
	//记住转为数字
	var salNormal = parseFloat(Ext.get('salNormal').dom.value);
	var salAbsenteeism = parseFloat(Ext.get('salAbsenteeism').dom.value);
	if(salNormal < salAbsenteeism){
		Ext.Msg.alert('提示','旷工时间大于正常工作时间');
		return;
	}
	var absenceMoney = 0;
	if(salNormal >= salAbsenteeism){
		var salBasic = Ext.get('salBasic').dom.value;
		//利用基本工资进行计算
		absenceMoney = (salBasic/salNormal)*salAbsenteeism;
		Ext.get('salAbsenteeismMoney').dom.value =  absenceMoney;	
	}
	//总工资计算
	var salBasic = parseFloat(Ext.get('salBasic').dom.value);
	var salJob = parseFloat(Ext.get('salJob').dom.value);
	var salEndowmentint = parseFloat(Ext.get('salEndowmentint').dom.value);
	var salUnemploymentint = parseFloat(Ext.get('salUnemploymentint').dom.value);
	var salHospitalizationint = parseFloat(Ext.get('salHospitalizationint').dom.value);
	var salEateryfloat = parseFloat(Ext.get('salEateryfloat').dom.value);
	var salTelephone = parseFloat(Ext.get('salTelephone').dom.value);
	var salTrafficfloat = parseFloat(Ext.get('salTrafficfloat').dom.value);
	var salAbsenteeismMoney = parseFloat(Ext.get('salAbsenteeismMoney').dom.value);
	var salAllowance = parseFloat(Ext.get('salAllowance').dom.value);
	var allMoney = salBasic+salJob-salEndowmentint-salUnemploymentint-salHospitalizationint+salEateryfloat+salTelephone+salTrafficfloat+salAllowance-absenceMoney;
	//五险一金免征税
	//console.log(allMoney);
	Ext.Ajax.request({
		url: 'salary_caculate.action',
		waitTitle: '提示',
		waitMsg: '正在保存数据...',
		params: {
			allMoney: allMoney
		},
		success: caculateSuccessFn,
		failure: caculateFailureFn
	})
};
caculateSuccessFn = function(response, options){
	var datas = Ext.util.JSON.decode(response.responseText);
	Ext.get('salRevenue').dom.value = datas.revenueMoney;
	Ext.get('salMoney').dom.value = datas.giveMoney;
};
caculateFailureFn = function(){
	Ext.Msg.alert('提示','计算数据连接后台失败');
}
/**
 * 保存工资记录
 */
var salaryFlag = true;
saveSalaryFn = function(){
	monthFn();
	//alert(salaryFlag);
	if(!Ext.getCmp('salaryAddPanelId').getForm().isValid()){
			return;
	}
	if(!salaryFlag){
		return;
	}
	Ext.getCmp('salaryAddPanelId').getForm().submit({
		url: 'salary_save.action',
		waitTitle: '提示',
		waitMsg: '正在保存数据...',
		method: 'post',
		success: saveSalarySuccessFn,
		failure: saveSalaryFailureFn
	})
};

saveSalarySuccessFn = function(form, action){
	Ext.Msg.confirm("提示",action.result.msg,function(value){
		if( value == 'yes'){
			form.reset();
			var win = Ext.getCmp("salaryUpdateWinId");
			if(win){
				win.destroy();
			}
		}
	})	
};
saveSalaryFailureFn = function(form, action){
	Ext.Msg.alert('提示','连接后台失败',function(){})
};
monthFn = function(obj){
	var value = Ext.getCmp('salMonth').getValue();
	var salEmpId = Ext.getCmp('salEmpId').getValue();
	if(salEmpId == ""){
		Ext.Msg.alert('提示','请先填写员工工号');
	}
	Ext.Ajax.request({
		url: 'salary_unique.action',
		method: 'post',
		params: {
			month: value,
			empId: salEmpId
		},
		success: function(response, options){
			var obj = Ext.util.JSON.decode(response.responseText);
			if(obj.msg == false){
				salaryFlag = false;
				Ext.getCmp('salMonth').markInvalid("该员工此月薪资已生成");
			}else{
				salaryFlag = true;
			}
		},
		failure: hrmsys.util.common.failure
	})
}
