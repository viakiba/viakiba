<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<title>企业基本信息</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
						<li class="active">主页</li>
					</ul>
					<!-- .breadcrumb -->
					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="icon-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- #nav-search -->
				</div>

				<div class="page-content">

                <h2 align="center">河南海融软件有限公司</h2>
                <div class="space-10"></div>
                <div id="left" style="float: left;width: 50%;">
                    <h3 class=" smaller red">信用等级及释义：</h3>
                    <div class="space-10"></div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <table id="sample-table-1" class="table table-striped table-bordered table-hover" style="width: 300px;margin-left: 50px">
                                    <tr>
                                        <th style="background-color: rosybrown">等级</th>
                                        <th>AAA级</th>
                                    </tr>

                                    <tr>
                                        <td style="background-color: rosybrown">释义</td>
                                        <td>公司信用管理基础完善，信用能力强，诚信度高，
                                            发展趋势乐观，综合能力处于行业领先水平
                                        </td>

                                    </tr>

                                    <tr>
                                        <td  style="background-color: rosybrown">领域</td>
                                        <td>建筑安装类</td>

                                    </tr>

                                </table>
                            </div><!-- /.table-responsive -->
                        </div><!-- /span -->

                    </div><!--/row -->
                    <h3 class=" smaller red">基本结论及风险提示：</h3>
             					<div class="space-10"></div>
                        <div class="widget-body" style="width: 300px;margin-left: 50px">
                            <textarea rows="10" cols="39">
             				</textarea>
                            
                            
                        </div>
                   <div class="space-4"></div>
                    <h3 class=" smaller red">企业经营情况：</h3>
					<div class="space-10"></div>
                    <div class="widget-body" style="width: 300px;margin-left: 50px">
                        <textarea rows="5" cols="39">
             				</textarea>
                    </div>
                  <div class="space-4"></div>
                    <h3 class=" smaller red">公共信用监管信息：</h3>
                 <div class="space-10"></div>
                    <div class="widget-body" style="width: 300px;margin-left: 50px">
                        <textarea rows="5" cols="39">
             				</textarea>
                    </div>
                    <div class="space-4"></div>
                    <h3 class=" smaller red">公益荣誉信息：</h3>
                    <div class="space-10"></div>
                    <div class="widget-body" style="width: 300px;margin-left: 50px">
                        <textarea rows="3" cols="39">
             				</textarea>
                    </div>


                </div>
                <div id="right" style="float: left;width: 50%;">
                    <h3 class=" smaller red">基本信息：</h3>
                    <div class="space-10"></div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <table id="sample-table-3" class="table table-striped table-bordered table-hover" style="width: 400px;margin-left: 50px">
                                    <tr>
                                        <th style="background-color: rosybrown">企业名称</th>
                                        <th>河南海融软件有限公司</th>
                                    </tr>
                                    <tr>
                                        <td style="background-color: rosybrown">企业住所</td>
                                        <td>大学科技园12号楼2楼</td>
                                    </tr>

                                    <tr>
                                        <td  style="background-color: rosybrown">法定代表人</td>
                                        <td>XXX</td>
                                    </tr>

                                    <tr>
                                        <td  style="background-color: rosybrown">注册资本</td>
                                        <td>壹仟万</td>
                                    </tr>

                                    <tr>
                                        <td  style="background-color: rosybrown">经济类型</td>
                                        <td>有限责任公司(自然人投资或控股)</td>
                                    </tr>

                                    <tr>
                                        <td  style="background-color: rosybrown">成立日期</td>
                                        <td>2009年10月10日</td>
                                    </tr>

                                    <tr>
                                        <td  style="background-color: rosybrown">工商注册号</td>
                                        <td>X6465165465465</td>
                                    </tr>

                                    <tr>
                                        <td  style="background-color: rosybrown">组织机构代码</td>
                                        <td>65465-X</td>
                                    </tr>
                                </table>
                            </div><!-- /.table-responsive -->
                        </div><!-- /span -->

                    </div><!--/row -->

                    <h3 class=" smaller red">主要财务数据与指标：　　　　　　<small>(人民币元)</small></h3>
                   <div class="space-10"></div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <table id="sample-table-2" class="table-striped table-bordered table-hover" style="width: 400px;margin-left: 50px;height: 500px">
                                    <tr>
                                        <th style="background-color: rosybrown">项目</th>
                                        <th style="background-color: rosybrown">2014年</th>
                                        <td style="background-color: rosybrown">2015年</td>
                                        <td style="background-color: rosybrown">2016年</td>
                                    </tr>
                                    <tr>
                                        <td>总资产(万元)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>主营业务收入(万元)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>资产负债率(%)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>现金流动债比率(%)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>速动比率(%)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>利息保障倍数(倍)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>总资产周转率(次)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>应收账款周转率(次)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>流动资产周转率(次)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>净资产收益率(%)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>主营业务利润率(%)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>总资产报酬率(%)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>营业收入增长率(%)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>利润增长率(%)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td>资本保值增值率(%)</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                </table>
                            </div><!-- /.table-responsive -->
                        </div><!-- /span -->

                    </div><!--/row -->

                    <div class="space-20"></div>
                </div><!-- /right-->

           			<div align="center">
           				
           				<a href="examapproval.jsp"><button class="btn btn-success ">通过</button></a>
           				
           				<button class="btn btn-pink butongguo">驳回</button>
           			</div>
							</div>
						</div>
					</div>
					<!-- /.main-content -->

					<div class="ace-settings-container" id="ace-settings-container">
						<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
							id="ace-settings-btn">
							<i class="icon-cog bigger-150"></i>
						</div>

						<div class="ace-settings-box" id="ace-settings-box">
							<div>
								<div class="pull-left">
									<select id="skin-colorpicker" class="hide">
										<option data-skin="default" value="#438EB9">#438EB9</option>
										<option data-skin="skin-1" value="#222A2D">#222A2D</option>
										<option data-skin="skin-2" value="#C6487E">#C6487E</option>
										<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
									</select>
								</div>
								<span>&nbsp; 选择皮肤</span>
							</div>

							<div>
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-navbar" /> <label class="lbl"
									for="ace-settings-navbar"> 固定导航条</label>
							</div>

							<div>
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-sidebar" /> <label class="lbl"
									for="ace-settings-sidebar"> 固定滑动条</label>
							</div>

							<div>
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-breadcrumbs" /> <label class="lbl"
									for="ace-settings-breadcrumbs">固定面包屑</label>
							</div>

							<div>
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-rtl" /> <label class="lbl"
									for="ace-settings-rtl">切换到左边</label>
							</div>

							<div>
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-add-container" /> <label class="lbl"
									for="ace-settings-add-container"> 切换窄屏 <b></b>
								</label>
							</div>
						</div>
					</div>
					<!-- /#ace-settings-container -->
				</div>
				<!-- /.main-container-inner -->

				<a href="#" id="btn-scroll-up"
					class="btn-scroll-up btn btn-sm btn-inverse"> <i
					class="icon-double-angle-up icon-only bigger-110"></i>
				</a>
			</div>
			<!-- /.main-container -->

			<!-- basic scripts -->

			<!--[if !IE]> -->

			<script src="assets/js/2.0.3/jquery.min.js"></script>

			<!-- <![endif]-->

			<!--[if IE]>
<script src="assets/js/1.10.2/jquery.min.js"></script>
<![endif]-->

			<!--[if !IE]> -->

			<script type="text/javascript">
				window.jQuery
						|| document
								.write("<script src='assets/js/jquery-2.0.3.min.js'>"
										+ "<"+"script>");
			</script>

			<!-- <![endif]-->

			<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

			<script type="text/javascript">
				if ("ontouchend" in document)
					document
							.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
									+ "<"+"script>");
			</script>
			<script src="assets/js/bootstrap.min.js"></script>
			<script src="assets/js/typeahead-bs2.min.js"></script>

			<!-- page specific plugin scripts -->

			<!--[if lte IE 8]>
          <script src="assets/js/excanvas.min.js"></script>
        <![endif]-->

			<script src="assets/js/jquery-ui-1.10.3.custom.min.js"></script>
			<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
			<script src="assets/js/jquery.slimscroll.min.js"></script>
			<script src="assets/js/jquery.easy-pie-chart.min.js"></script>
			<script src="assets/js/jquery.sparkline.min.js"></script>
			<script src="assets/js/flot/jquery.flot.min.js"></script>
			<script src="assets/js/flot/jquery.flot.pie.min.js"></script>
			<script src="assets/js/flot/jquery.flot.resize.min.js"></script>

			<!-- ace scripts -->

			<script src="assets/js/ace-elements.min.js"></script>
			<script src="assets/js/ace.min.js"></script>

			<!-- inline scripts related to this page -->

			<script type="text/javascript">
			    $(function(){
	$('.butongguo').on('click', function(){
			var html = "<label>驳回的理由：<textarea class='confirm_input' rows='5' cols='25' placeholder='请输入'></textarea></label>";
			popTipShow.confirm('提示信息',html,['确 定','取 消'],
				function(e){
				  //callback 处理按钮事件
				  var button = $(e.target).attr('class');
				  if(button == 'ok'){
					if(null==$(".confirm_input").val() || ""==$(".confirm_input").val()){
						webToast("姓名不能为空！","bottom", 3000);
						return;
					}	
					
					this.hide();
					setTimeout(function() {
						webToast($(".confirm_input").val(),"bottom", 3000);
					}, 300);
					
					//按下确定按钮执行的操作
					//todo ....								
				  }

				  if(button == 'cancel') {
					//按下取消按钮执行的操作
					//todo ....
					this.hide();
					setTimeout(function() {
						webToast("您选择“取消”了","top", 2000);
					}, 300);
				  }
				}
			);
	   });
	  
	       });
			
				jQuery(function($) {
					$('.easy-pie-chart.percentage')
							.each(
									function() {
										var $box = $(this).closest('.infobox');
										var barColor = $(this).data('color')
												|| (!$box
														.hasClass('infobox-dark') ? $box
														.css('color')
														: 'rgba(255,255,255,0.95)');
										var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)'
												: '#E2E2E2';
										var size = parseInt($(this)
												.data('size')) || 50;
										$(this)
												.easyPieChart(
														{
															barColor : barColor,
															trackColor : trackColor,
															scaleColor : false,
															lineCap : 'butt',
															lineWidth : parseInt(size / 10),
															animate : /msie\s*(8|7|6)/
																	.test(navigator.userAgent
																			.toLowerCase()) ? false
																	: 1000,
															size : size
														});
									})

					$('.sparkline')
							.each(
									function() {
										var $box = $(this).closest('.infobox');
										var barColor = !$box
												.hasClass('infobox-dark') ? $box
												.css('color')
												: '#FFF';
										$(this)
												.sparkline(
														'html',
														{
															tagValuesAttribute : 'data-values',
															type : 'bar',
															barColor : barColor,
															chartRangeMin : $(
																	this).data(
																	'min') || 0
														});
									});

					var placeholder = $('#piechart-placeholder').css({
						'width' : '90%',
						'min-height' : '150px'
					});
					var data = [ {
						label : "social networks",
						data : 38.7,
						color : "#68BC31"
					}, {
						label : "search engines",
						data : 24.5,
						color : "#2091CF"
					}, {
						label : "ad campaigns",
						data : 8.2,
						color : "#AF4E96"
					}, {
						label : "direct traffic",
						data : 18.6,
						color : "#DA5430"
					}, {
						label : "other",
						data : 10,
						color : "#FEE074"
					} ]
					function drawPieChart(placeholder, data, position) {
						$.plot(placeholder, data, {
							series : {
								pie : {
									show : true,
									tilt : 0.8,
									highlight : {
										opacity : 0.25
									},
									stroke : {
										color : '#fff',
										width : 2
									},
									startAngle : 2
								}
							},
							legend : {
								show : true,
								position : position || "ne",
								labelBoxBorderColor : null,
								margin : [ -30, 15 ]
							},
							grid : {
								hoverable : true,
								clickable : true
							}
						})
					}
					drawPieChart(placeholder, data);

					/**
					we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
					so that's not needed actually.
					 */
					placeholder.data('chart', data);
					placeholder.data('draw', drawPieChart);

					var $tooltip = $(
							"<div class='tooltip top in'><div class='tooltip-inner'></div></div>")
							.hide().appendTo('body');
					var previousPoint = null;

					placeholder.on('plothover', function(event, pos, item) {
						if (item) {
							if (previousPoint != item.seriesIndex) {
								previousPoint = item.seriesIndex;
								var tip = item.series['label'] + " : "
										+ item.series['percent'] + '%';
								$tooltip.show().children(0).text(tip);
							}
							$tooltip.css({
								top : pos.pageY + 10,
								left : pos.pageX + 10
							});
						} else {
							$tooltip.hide();
							previousPoint = null;
						}

					});

					var d1 = [];
					for (var i = 0; i < Math.PI * 2; i += 0.5) {
						d1.push([ i, Math.sin(i) ]);
					}

					var d2 = [];
					for (var i = 0; i < Math.PI * 2; i += 0.5) {
						d2.push([ i, Math.cos(i) ]);
					}

					var d3 = [];
					for (var i = 0; i < Math.PI * 2; i += 0.2) {
						d3.push([ i, Math.tan(i) ]);
					}

					var sales_charts = $('#sales-charts').css({
						'width' : '100%',
						'height' : '220px'
					});
					$.plot("#sales-charts", [ {
						label : "Domains",
						data : d1
					}, {
						label : "Hosting",
						data : d2
					}, {
						label : "Services",
						data : d3
					} ], {
						hoverable : true,
						shadowSize : 0,
						series : {
							lines : {
								show : true
							},
							points : {
								show : true
							}
						},
						xaxis : {
							tickLength : 0
						},
						yaxis : {
							ticks : 10,
							min : -2,
							max : 2,
							tickDecimals : 3
						},
						grid : {
							backgroundColor : {
								colors : [ "#fff", "#fff" ]
							},
							borderWidth : 1,
							borderColor : '#555'
						}
					});

					$('#recent-box [data-rel="tooltip"]').tooltip({
						placement : tooltip_placement
					});
					function tooltip_placement(context, source) {
						var $source = $(source);
						var $parent = $source.closest('.tab-content')
						var off1 = $parent.offset();
						var w1 = $parent.width();

						var off2 = $source.offset();
						var w2 = $source.width();

						if (parseInt(off2.left) < parseInt(off1.left)
								+ parseInt(w1 / 2))
							return 'right';
						return 'left';
					}

					$('.dialogs,.comments').slimScroll({
						height : '300px'
					});

					//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
					//so disable dragging when clicking on label
					var agent = navigator.userAgent.toLowerCase();
					if ("ontouchstart" in document && /applewebkit/.test(agent)
							&& /android/.test(agent))
						$('#tasks').on(
								'touchstart',
								function(e) {
									var li = $(e.target).closest('#tasks li');
									if (li.length == 0)
										return;
									var label = li.find('label.inline').get(0);
									if (label == e.target
											|| $.contains(label, e.target))
										e.stopImmediatePropagation();
								});

					$('#tasks').sortable({
						opacity : 0.8,
						revert : true,
						forceHelperSize : true,
						placeholder : 'draggable-placeholder',
						forcePlaceholderSize : true,
						tolerance : 'pointer',
						stop : function(event, ui) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
							$(ui.item).css('z-index', 'auto');
						}
					});
					$('#tasks').disableSelection();
					$('#tasks input:checkbox').removeAttr('checked').on(
							'click',
							function() {
								if (this.checked)
									$(this).closest('li').addClass('selected');
								else
									$(this).closest('li').removeClass(
											'selected');
							});

				});
			</script>
			<div style="display:none">
				<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
					language='JavaScript' charset='utf-8'></script>
			</div>
</body>
</html>

