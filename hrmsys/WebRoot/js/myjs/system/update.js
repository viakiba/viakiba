Ext.namespace("hrmsys.user.updatePwd");

var userMark1 = true;
var userMark2 = true;
var userMark3 = true;
UpdateFormPanel = Ext.extend(Ext.form.FormPanel, {
	id: 'updateFormId',
	constructor: function(username){
		Ext.form.Field.prototype.msgTarget = 'side';
		Ext.QuickTips.init();
		UpdateFormPanel.superclass.constructor.call(this, {
			style: 'margin-left: 30%; margin-top: 5%',
			items: [{
				width: 500,
				xtype: 'fieldset',
				title: '用户信息修改',
				labelAlign: 'right',
				labelWidth: 60,
				layout: 'form',
				padding: '10 0 0 110',
				items: [{
					xtype: 'textfield',
					fieldLabel: '用户名',
					id: 'userName',
					value: username,
					allowBlank: false,
					name: 'user.userName',
		    		blankText: '不能为空',
		    		emptyText: '不能为空'
				},{
					xtype: 'textfield',
					fieldLabel: '原密码',
					id: 'oldPassword',
					allowBlank: false,
					blankText: '不能为空',
					//validator: validatePassword
					listeners: {'blur': validatePassword}
				},{
					xtype: 'textfield',
					fieldLabel: '用户密码',
					name: 'user.userPwd',
					inputType: 'password',
					id: 'pwd',
					allowBlank: false,
		    		blankText: '不能为空',
		    		listeners: {'blur': pwd_blurFn}
				},{
					xtype: 'textfield',
					fieldLabel: '再次输入',
					inputType: 'password',
					allowBlank: false,
		    		blankText: '不能为空',
		    		id: 'rePwd',
		    		listeners: {'blur': rePwd_blurFn}
				}],
				buttonAlign: 'center',
				buttons: [{
					text: '确定',
					handler: this.saveSuccessFn
				},{
					text: '取消',
					handler: function(){
						Ext.getCmp('updateFormId').getForm().reset();
					}
				}]
			}]
		})
	},
	saveSuccessFn: function(){
		var form = Ext.getCmp('updateFormId').getForm();
		rePwd_blurFn();
		pwd_blurFn();
		validatePassword();
		//判断校验是否通过，在ff下校验失败会阻止提交，在ie需自己判断
		if(form.isValid() && userMark1 && userMark2 && userMark3){
		form.submit({
			url: 'user_updatePwd.action',
			success: function(form, action){
				Ext.Msg.alert('提示', action.result.msg, function(){
					form.reset();
				})
				},
			failure: save_failure
		});}
	}
});
rePwd_blurFn = function(){
	var pwd = Ext.getDom('pwd').value;
	var rePwd = Ext.getDom('rePwd').value;
	if(pwd != rePwd && pwd != ""){
		userMark2 = false;
		Ext.getCmp('rePwd').markInvalid('两次输入的密码不相同');
	}
	userMark = true;
	if(pwd == rePwd){
		userMark2 = true;
		Ext.getCmp('rePwd').clearInvalid();
		Ext.getCmp('pwd').clearInvalid();
	}
};
pwd_blurFn = function(){
	var pwd = Ext.getDom('pwd').value;
	var rePwd = Ext.getDom('rePwd').value;
	if(rePwd != "" && pwd != rePwd){
		userMark3 = false;
		Ext.getCmp('pwd').markInvalid('两次输入的密码不相同');
	}
	if(pwd == rePwd){
		userMark3 = true;
		Ext.getCmp('rePwd').clearInvalid();
		Ext.getCmp('pwd').clearInvalid();
	}
};
validatePassword = function(){
	var oldPassword = Ext.getDom("oldPassword").value;
	Ext.Ajax.request({
		url: 'user_validatePwd.action',
		params: {
			oldPassword: oldPassword
		},
		success: function(response, options){
			var datas = Ext.util.JSON.decode(response.responseText);
			if(datas.msg == false){
				userMark1 = false;
				Ext.getCmp("oldPassword").markInvalid("原密码不正确");
			}else{
				userMark1 = true;
			}
		}
	})	
}