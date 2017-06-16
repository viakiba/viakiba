/**
 * @author sux
 * @time 2011-1-11
 * @desc main page
 */
 
 var mainPage = Ext.extend(Ext.Viewport,{
 
 
 	/**
 	 * 构造方法中进行整体布局
 	 */
 	constructor: function(username, date){
 		mainPage.superclass.constructor.call(this,{
 			layout: 'border',
 			items: [{
 				region: 'north',
 				xtype: 'panel',
 				//html: '人力资源管理系统',
 				bodyStyle: 'height: 66px;',
 				layout: 'absolute',
 				html: '<table class="header"><tr ><td class="header_left"></td><td class="header_center"></td>' +
 						'<td class="header_right"><div id="user_header">'+date+'&nbsp;<img src="img/user.png"/>&nbsp;' +
 					  		username+'&nbsp;&nbsp;<a href="user_exit.action">注销</a>' +
 					  	'</div></td>' +
 					  '</tr></table>'
 			},{
 				region: 'west',
 				frame: 'true',
 				width: '200',
 				id: 'menu_tree',
 				xtype: 'panel',
 				autoScroll: true,
 				title: '人力资源管理系统',
 				split: true,
 				collapsible: true,
 				items: [{
 					xtype: 'treepanel',
 					title: '',
 					autoScroll: true,
 					border: false,
 					id: 'tree',
 					rootVisible:true,//不隐藏根节点
// 					tools: [{
// 						id: 'refresh',
// 						handler: '',
// 						scope: this
// 					}],
 					loader: new Ext.tree.TreeLoader({
 						dataUrl: 'menu.action'
 					}),
 					//每加入进来的节点，若为非叶子节点则做为根节点继续进行查找
 					root: new Ext.tree.AsyncTreeNode({
 						text: '人力资源管理',
 						expanded :true,
 						id: '1' //加载数据时每次以变量node传入id的值如: node=1
 						//leaf: false //数据库中存储的为1/0
 					}),
 					listeners: {
 						'click': {
 							fn: this.clickNode,
 							scope: this
 						}
 					}
 				}]
 			},this.center,{
 				region: 'south',
 				width: '100%',
 				frame: true,
 				height: 30,
 				html: "<div id='author'>Copyright &copy J2EE &HRM</div>"
 			}]
 		});
 	},
 	
 	center: new Ext.TabPanel({
 		id: 'mainTab',
 		frame: true,
 		region: 'center',
 		activeTab: 0,
 		autoScroll: false,
 		enableTabScroll : true, //溢出时滚动tab
 		split: true,
 		//TabCloseMenu一个显示右键菜单的插件
 		plugins: new Ext.ux.TabCloseMenu(),
 		items: [{
 			closable: false,
 			title: '首页',
 			iconCls: 'main',
 			
 			html: '<iframe src="/hrmsys/jsp/first.jsp" frameborder=0 width=100% height=100%/>'
 		}]
 	}),
 	
 	/**
 	 * 在中间区域添加新的面板
 	 */
 	 addTab : function(nodeId, nodeUrl, nodeText, nodeIcon){
 	 	var tabId = 'tab_'+nodeId; //tabId为新建面板的id
 	 	var tabTitle = nodeText;
 	 	var tabUrl = nodeUrl;
 	 	var centerPanel = Ext.getCmp('mainTab');
 	 	var tab = centerPanel.getComponent(tabId);
 	 	if(parseInt(nodeId) == 28){
 	 		Ext.getCmp('mainTab').remove(Ext.getCmp('tab_30'));
 	 	}
 	 	if(parseInt(nodeId) == 30){
 	 		Ext.getCmp('mainTab').remove(Ext.getCmp('tab_28'));
 	 	}
 	 	//如果已存在此面板则只需要激活便可
 	 	if(!tab){
 	 	var newTab = centerPanel.add(
 	 		new Ext.Panel({
 	 			//bodyStyle: 'background-color:#dfe8f6;',
 	 			frame: true,
 	 			title: tabTitle,
 	 			iconCls: nodeIcon,
 	 			id: tabId,
 	 			closable: true
// 	 			listeners: {//监听激活事件设置页面大小
// 	 				active: this.activeTabSize,
// 	 				scope: this
// 	 			}
 	 		})
 	 	);
 	 	//激活新面板
 	 	centerPanel.setActiveTab(newTab); 
 	 	//加载页面数据
 	 	newTab.load({
 	 		url: tabUrl,
 	 		method: 'post',
 	 		scope: this,
 	 		nocache : true, // 不缓存
 	 		timeout: 3000,
 	 		scripts : true //设置允许加载的页面执行js,很重要
 	 	});   
 	 	}else{
 	 		centerPanel.setActiveTab(tab);
 	 	};
 	 	//this.juage(nodeId);
 	 },
 	
 	/**
 	 * 树结点的单击事件
 	 * 若为叶子节点则弹出一个窗口
 	 */
 	 clickNode : function(node, e){
 	 	if(node.attributes.leaf){
 	 		var nodeId = node.attributes.id;
 	 		var nodeUrl = node.attributes.menuUrl;
 	 		var nodeText = node.attributes.text;
 	 		var nodeIcon = node.attributes.menuIcon;
 	 		this.addTab(nodeId, nodeUrl, nodeText, nodeIcon);
 	 	};
 	 }

 	 /**
 	  * 激活页面时设置页面大小
 	  */
// 	  activeTabSize : function(){
// 		 console.log('jin ru');
// 	  		var w = Ext.getCmp('mainTab').getActiveTab().getInnerWidth();
// 	  		var h = Ext.getCmp('mainTab').getActiveTab().getInnerHeight();
// 	  		var activeTabId = Ext.getCmp('mainTab').getActiveTab().id;
// 	  		var activeTab = Ext.getCmp('activeTabId');
// 	  		if(activeTab){
// 	  			activeTab.setHeight(h);
// 	  			activeTab.setWidth(w);
// 	  		}
// 	  }
 });
 
