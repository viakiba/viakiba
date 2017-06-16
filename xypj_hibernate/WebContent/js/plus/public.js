var np = 1;
// 分页的显示与隐藏
$("#xifenye").click(function(a) {
	$("#uljia").empty();
	$("#xab").toggle();
	// 显示出的一共多少页
	var uljia = $("#uljia");
	var page = parseInt($("#xiye").html());// 获取当前的页数
	var pages = parseInt($("#mo").html());// 获取当前的总页数
	for ( var i = 1; i <= pages; i++) {
		var H = "<li  onclick='fl(" + i + "," + pages + ")'>" + i + "</li>";// 添加一共多少页和点击事件

		uljia.append(H);
	}
	scrolltop(page);
	if (!check(page)) {
		if (updateCommon.queryType == "1") {
			txlJs.curPage = page;
			txlJs.getListPage();
		} else if (updateCommon.queryType == "2") {
			pluginJs.curPage = page;
			pluginJs.getListPage();
		} else {
			userJs.curPage = page;
			userJs.pageInit();
		}
	}

});
// 点击分页显示的方法
function fl(p1, p2) {
	// var p=p1;
	$("#xiye").empty();
	$("#xiye").html(p1);// 给显示的页数赋值

}
function check(p) {
	if (np == p) {
		return true;
	} else {
		np = p;
		return false;
	}
}
// 分页的的上一页和下一页
function topclick() {
	var v = document.getElementById("xiye");
	var num = v.innerHTML;
	if (num > 1) {
		num--;
		v.innerHTML = num;
		var hei = 25 * num - 25;
		$("#xab").scrollTop(hei);
	}
	if (!check(num)) {
		if (updateCommon.queryType == "1") {
			txlJs.curPage = num;
			txlJs.getListPage();
		} else if (updateCommon.queryType == "2") {
			pluginJs.curPage = num;
			pluginJs.getListPage();
		} else {
			userJs.curPage = num;
			userJs.pageInit();
		}

		// txlJs.curPage =num;
		// txlJs.getListPage();
	}
}

function downclick() {
	var pages = parseInt($("#mo").html());// 获取当前的总页数
	var v = $("#xiye");
	var num = parseInt(v.html());
	if (num < pages) {
		++num;
		v.html(num);
		scrolltop(num);
	}
	if (!check(num)) {
		if (updateCommon.queryType == "1") {
			txlJs.curPage = num;
			txlJs.getListPage();
		} else if (updateCommon.queryType == "2") {
			pluginJs.curPage = num;
			pluginJs.getListPage();
		} else {
			userJs.curPage = num;
			userJs.pageInit();
		}

		// txlJs.curPage =num;
		// txlJs.getListPage();
	}
}
// 分页的的首页和未页
$("#first").bind("click", function() {
	var v = document.getElementById("xiye");
	v.innerHTML = 1;
	scrolltop(v.innerHTML);
	if (!check(1)) {
		if (updateCommon.queryType == "1") {
			txlJs.curPage =1;
			txlJs.getListPage();
		} else if (updateCommon.queryType == "2") {
			pluginJs.curPage = 1;
			pluginJs.getListPage();
		} else {
			userJs.curPage = 1;
			userJs.pageInit();
		}
		
		//txlJs.curPage =num;
		//txlJs.getListPage();
	}
	
});
$("#last").bind("click", function() {
	var v = document.getElementById("xiye");
	var l = document.getElementById("mo");
	v.innerHTML = l.innerHTML;
	scrolltop(v.innerHTML);
	if (!check(l.innerHTML)) {
		
		if (updateCommon.queryType == "1") {
			txlJs.curPage =l.innerHTML;
			txlJs.getListPage();
		} else if (updateCommon.queryType == "2") {
			pluginJs.curPage = l.innerHTML;
			pluginJs.getListPage();
		} else {
			userJs.curPage = l.innerHTML;
			userJs.pageInit();
		}
		
		//txlJs.curPage =num;
		//txlJs.getListPage();
	
	}
});
// 滚动条
function scrolltop(top) {
	var hei = 25 * top - 25;
	$("#xab").scrollTop(hei);
}