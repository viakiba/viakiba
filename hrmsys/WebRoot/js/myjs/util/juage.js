/**
 * 根据用户权限显示不同的页面
 * 前后得到的菜单节点id和后台用户的角色id查询数据库获得用户权限
 * @param {Object} id 页面id,本质是菜单节点的id
 * @param {Object} page 按钮id前缀
 * @param {Object} cmp 组件
 * @param {Object} renderId 渲染的id
 */
function juage(id,page,cmp, renderId){
		//设置遮罩，当按钮隐藏之后，再隐藏遮罩
		 var myMask = new Ext.LoadMask('mainTab', {msg:"请稍等..."});
		 myMask.show();
 		 Ext.Ajax.request({
 			 url: 'permission_permission.action',
 			 method: 'post',
 			 success: function (response, options){
				 		 var datas = response.responseText;
				 		 if(datas != ''){
					 		 var fn = datas.split(' ');
					 		 for(var i = 0; i< fn.length; i++){
					 			 var comp = Ext.getCmp(page+'_'+fn[i]);
					 			 if(comp){
					 				 comp.show(); //将没有权限的按钮隐藏hiden
					 			 }
					 		 }
				 		 }
				 		 cmp.render(renderId);
				 		 myMask.hide();
				 	 },
 			 failure: function(response, options){
				 		 Ext.Msg.alert('提示','连接后台失败');
 			 },
 			 params: {
 			 	menuId: id
 			 }
 		 })
 	 };