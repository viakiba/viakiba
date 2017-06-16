/**
 * @author sux
 * @desc 登录
 */
Ext.onReady(function(){
	Ext.QuickTips.init(); //错误信息显示必须
	var loginForm = new Ext.form.FormPanel({
		//title: '用户登录',
		width: 290,
		height: 300,
		labelWidth: 50,
		labelAlign: 'right',
		defaults: {
			width: 210,
			layout: 'form',
			xtype: 'panel'
		},
		renderTo: 'loginForm',
		layout: 'table',
		frame: true, //背景
		buttonAlign: 'center',
		bodyStyle: 'padding: 75px 0px 0px 50px; background-image: url(img/login.jpg)',
		method: 'post',
		layoutConfig:{
			columns: 2
		},
		items: [{
			items:[{
			xtype: 'textfield',
			fieldLabel: '用户名', //form布局才显示出labelName
			name: 'username',
			id: 'indexUserName',
			allowBlank: false,
			msgTarget: 'side',
			blankText: '用户名不能为空',
			regex: /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/,
			regexText: '不能输入特殊字符'
			}],
			colspan: 2	
		},{
			items:[{
			xtype: 'textfield',
			fieldLabel: '密&nbsp;&nbsp;&nbsp;码',
			regex: /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/, //字母、数字、汉字、下画线
			regexText: '不能输入特殊字符',
			name: 'password',
			inputType: 'password',
			allowBlank: false,
			blankText: '用户密码不能为空',
			msgTarget: 'side'
			}],
			colspan: 2
		},{
			items:[{
			xtype: 'textfield',
			fieldLabel: '验证码',
			blankText: '验证码不能为空',
			name: 'validateCode',
			allowBlank: false,
			msgTarget: 'side',
			width: 50,
			 listeners : {
                specialkey : function(field, e) {//添加回车事件
                    if (e.getKey() == Ext.EventObject.ENTER) {
                        loginForm.getForm().getEl().dom.action="user_login.action";
						loginForm.getForm().getEl().dom.submit();
                    }
                }
            }
			}],
			width: 120
		},{
			items:[{
			xtype: 'panel',
			html: '<img src="/hrmsys/validate" title="点击刷新" style="cursor:hand" id="validate" onclick="refreshCode()"/>'
			}]
		},{
			layout: 'table',
			layoutConfig:{
				columns: 2
			},
			bodyStyle: 'margin-top: 10px;',
			colspan: 2,
			items: [{
				xtype: 'button',
				text: '确定',
				style: 'margin-left: 30px;',
				width: 60,
				handler: function(){
					loginForm.getForm().getEl().dom.action="user_login.action";
					loginForm.getForm().getEl().dom.submit();
				}
			},{
				xtype: 'button',
				width: 60,
				style: 'margin-left: 10px;',
				text: '取消',
				handler: function(){
				loginForm.getForm().reset();
			}
			}]
		}]
	});
	Ext.getCmp("indexUserName").focus(true, true);//初始化页面后用户名获取焦点
});

function refreshCode(){
	Ext.getDom('validate').src="/hrmsys/validate.jsp?code="+Math.random();
}
