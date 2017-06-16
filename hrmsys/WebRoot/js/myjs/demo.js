Ext.tree.TreeCheckNodeUI = function() {
	// 'multiple':多选; 'single':单选; 'cascade':级联多选 
	this.checkModel = 'multiple';

	// only leaf can checked 
	this.onlyLeafCheckable = false;

	Ext.tree.TreeCheckNodeUI.superclass.constructor.apply(this, arguments);
};

Ext.extend(
				Ext.tree.TreeCheckNodeUI,
				Ext.tree.TreeNodeUI,
				{

					renderElements : function(n, a, targetNode, bulkRender) {
						var tree = n.getOwnerTree();
						this.checkModel = tree.checkModel || this.checkModel;
						this.onlyLeafCheckable = tree.onlyLeafCheckable || false;

						// add some indent caching, this helps performance when 
						// rendering a large tree 
						this.indentMarkup = n.parentNode ? n.parentNode.ui
								.getChildIndent() : '';
						var href = a.href ? a.href : Ext.isGecko ? "" : "#";

						//var cb = (!this.onlyLeafCheckable || a.leaf); 

						// ////////////////////////////////////////////////// 
						var cb = a.leaf;// 作用是当节点为叶子节点的时候显示复选框，其他时候不显示	
						var resourcesStr = "";// 子菜单下面的权限 
						//alert("11"+n.attributes.resources+"22"); 
						if (n.attributes.resources != "") {
							// 子菜单下面的权限store 
							var resourcesStroe = new Ext.data.SimpleStore( {
								data : eval(n.attributes.resources),
								fields : [ "id", "name", "checked" ]
							});
							for ( var i = 0; i < resourcesStroe.getCount(); i++) {
								var record = resourcesStroe.getAt(i);
								resourcesStr += "<input class='x-tree-node-cb' onclick=resCheckChange(this,'"
										+ n.id
										+ "') name=res"
										+ n.id
										+ " id = '"
										+ record.get("id")
										+ "' type='checkbox' ";
								if (record.get("checked")) {
									resourcesStr += "checked=true/>"
											+ record.get("name");
								} else {
									resourcesStr += "/>" + record.get("name");
								}
							}
						}
						// alert(resourcesStr) 

						var buf = [
								'<li class="x-tree-node"><div ext:tree-node-id="',
								n.id,
								'" class="x-tree-node-el x-tree-node-leaf x-unselectable ',
								a.cls,
								'" unselectable="on">',
								'<span class="x-tree-node-indent">',
								this.indentMarkup,
								"</span>",
								'<img src="',
								this.emptyIcon,
								'" class="x-tree-ec-icon x-tree-elbow" />',
								'<img src="',
								a.icon || this.emptyIcon,
								'" class="x-tree-node-icon',
								(a.icon ? " x-tree-node-inline-icon" : ""),
								(a.iconCls ? " " + a.iconCls : ""),
								'" unselectable="on" />',
								cb ? ('<input class="x-tree-node-cb" type="checkbox" name="' + n.id + '" ' + (a.checked ? 'checked="checked" />'
										: '/>'))
										: '',
								'<a hidefocus="on" class="x-tree-node-anchor" href="',
								href,
								'" tabIndex="1" ',
								a.hrefTarget ? ' target="' + a.hrefTarget + '"'
										: "",
								'><span unselectable="on">',
								n.text,
								"</span></a><div style='display:inline; position:absolute;left:180px'>"
										+ resourcesStr + "</div></div>",
								'<ul class="x-tree-node-ct" style="display:none;"></ul>',
								"</li>" ].join('');

						var nel;
						if (bulkRender !== true && n.nextSibling
								&& (nel = n.nextSibling.ui.getEl())) {
							this.wrap = Ext.DomHelper.insertHtml("beforeBegin",
									nel, buf);
						} else {
							this.wrap = Ext.DomHelper.insertHtml("beforeEnd",
									targetNode, buf);
						}

						this.elNode = this.wrap.childNodes[0];
						this.ctNode = this.wrap.childNodes[1];
						var cs = this.elNode.childNodes;
						this.indentNode = cs[0];
						this.ecNode = cs[1];
						this.iconNode = cs[2];
						var index = 3;
						if (cb) {
							this.checkbox = cs[3];
							Ext.fly(this.checkbox).on('click',
									this.check.createDelegate(this, [ null ]));
							index++;
						}
						this.anchor = cs[index];
						this.textNode = cs[index].firstChild;
					},

					// private 
					check : function(checked) {
						var n = this.node;
						if (checked === null) {
							checked = this.checkbox.checked;
						} else {
							this.checkbox.checked = checked;
						}
						// 自定义，当选中叶子节点的时候，其后面的资源checkbox全都选中 
						var allChecks = Ext.getDoc().dom
								.getElementsByTagName("input");
						for ( var i = 0; i < allChecks.length; i++) {
							var check = allChecks[i];
							if (check.name == "res" + n.id) {
								check.checked = checked;
							}
						}
						n.attributes.checked = checked;
						//tree.fireEvent('check', n, checked); 
					}
				});

/** 
 * 资源复选框，选择改变事件. 
 * 当选中资源的时候，子菜单选中。 
 */
function resCheckChange(obj, nodeId) {
	var allChecks = Ext.getDoc().dom.getElementsByTagName("input");
	if (obj.checked) {
		for ( var i = 0; i < allChecks.length; i++) {
			var check = allChecks[i];
			if (check.name == nodeId && !check.checked) {
				check.checked = true;
				var node = Ext.getCmp("tree").getNodeById(nodeId);
				node.attributes.checked = obj.checked;
			}
		}
	}
}

var roleId = "";
/** 
 * 生成角色分配权限的窗口 
 */
function _resourcesRoleMge(row) {
	roleId = row.get("pk");

	/** 
	 * 左侧的菜单树 
	 */
	var treeConfig = {
		region : "center",
		id : "tree",
		collapsible : true,
		border : false,
		layout : "fit",// 自动填充 
		height : 300,
		width : 200,
		autoScroll : true,
		frame : true,
		enableDrag : false,
		checkModel : 'cascade', // 对树的级联多选 
		onlyLeafCheckable : false, // 对树所有结点都可选 
		rootVisible : true, // 显示根节点 
		animate : true, // 有一种动态效果 
		enableDD : false,// true to enable drag and drop是否支持拖拽效果 
		loader : new Ext.tree.TreeLoader( {
			// 请求的地址 
			url : basePath + "admin/resourcesrolemge.do",
			baseParams : {
				key : "list",
				roleId : roleId
			},
			baseAttrs : {
				uiProvider : Ext.tree.TreeCheckNodeUI
			},
			listeners : {// 加载前变化参数 
				"beforeload" : function(treeLoader, node) {
					this.baseParams.roleId = roleId;
				}
			}
		}),
		root : new Ext.tree.AsyncTreeNode( {
			id : "00",
			text : "菜单资源",
			icon : basePath + "images/menuimages/totalMenu.png"
		})
	};
	var tree = new Ext.tree.TreePanel(treeConfig);

	var windowconfig = {
		title : "给角色【" + row.get("wtroleName") + "】分配权限",
		width : 500,
		//autoHeight:true, 
		height : 400,
		id : 'iwindow',
		modal : true,
		autoScroll : true,
		layout : "fit",
		items : [ tree ],
		buttonAlign : "center",
		buttons : [ {
			text : "提交",
			handler : _subRoleRights
		}, {
			text : "关闭",
			style : "margin-left:15px;",
			handler : function() {
				Ext.getCmp("iwindow").close();
			}
		} ]
	}
	var iwindow = new Ext.Window(windowconfig);
	iwindow.show();
	tree.expandAll();// 展开所有节点 
}

// 定义一个store 
var resourcesStore = new Ext.data.Store( {
	url : basePath + "admin/resources.do?key=list",
	reader : new Ext.data.JsonReader( {
		totalProperty : 'results',
		remoteSort : false,// 是否后台排序，会提交两个参数sort和dir 
		root : 'rows'
	}, [ {
		name : "wtresourceId"
	}, {
		name : "wtresName"
	}, {
		name : "wtresDescription"
	} ])
});

/** 
 * 获取数据并保存 
 * 获得的数据有  roleId 
 * 所有选中的子菜单的id 
 * 所有选中的资源id 
 */
function _subRoleRights() {
	// 所有选中的子菜单的id 
	var checkedNodesIds = "";// 选中的节点id 
	var checkedNodes = Ext.getCmp("tree").getChecked();
	for ( var i = checkedNodes.length - 1; i >= 0; i--) {
		var node = checkedNodes[i];
		if (node.leaf) {// 去掉非叶子节点 
			checkedNodesIds += "," + node.id;
		}
		if (i == 0) {
			checkedNodesIds = checkedNodesIds.substring(1);
		}
	}
	// 获得所有选中的资源id 
	var checkedResourcesIds = "";
	// 这里利用dom 
	var checkedResources = document.getElementsByTagName('input');
	// 移除未选中的 
	for ( var i = checkedResources.length - 1; i >= 0; i--) {
		var checkbox = checkedResources[i];
		if (checkbox.type == "checkbox" && checkbox.checked) {
			checkedResourcesIds += "," + checkbox.id
		}
		if (i == 0) {
			checkedResourcesIds = checkedResourcesIds.substring(1);
		}
	}
	// 提交数据后台 
	_saveData(roleId, checkedNodesIds, checkedResourcesIds);
}

/** 
 * 保存数据 
 */
function _saveData(roleId, checkedNodesIds, checkedResourcesIds) {
	Ext.Ajax.request( {
		url : basePath + "admin/resourcesrolemge.do?key=add",
		params : {
			roleId : roleId,
			checkedNodesIds : checkedNodesIds,
			checkedResourcesIds : checkedResourcesIds
		},
		method : "post",
		success : function(response) {
			Ext.MessageBox.alert(infoText, response.responseText);
			Ext.getCmp("iwindow").destroy();
		},
		failure : function(response) {
			Ext.MessageBox.alert(errorText, response.responseText);
		}
	});
}
//http://aijianfeng-1234-126-com.javaeye.com/blog/417986