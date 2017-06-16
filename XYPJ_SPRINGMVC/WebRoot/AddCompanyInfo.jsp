<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<script src="assets/js/fuelux/fuelux.wizard.min.js"></script>
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
					<div class="span12">
						<div class="widget-box">
							<div class="widget-header widget-header-blue widget-header-flat">
								<h4 class="lighter">信息采集</h4>


							</div>

							<div class="widget-body">
								<div class="widget-main">
									<div id="fuelux-wizard" class="row-fluid"
										data-target="#step-container">
										<ul class="wizard-steps">
											<li data-target="#step1" class="active"><span
												class="step">1</span> <span class="title">一般状况</span></li>

											<li data-target="#step2"><span class="step">2</span> <span
												class="title">财务状况</span></li>

											<li data-target="#step3"><span class="step">3</span> <span
												class="title">创新和发展能力状况</span></li>

											<li data-target="#step4"><span class="step">4</span> <span
												class="title">公共信用监管信息</span></li>
											<li data-target="#step5"><span class="step">5</span> <span
												class="title">企业荣誉</span></li>
											<li data-target="#step6"><span class="step">6</span> <span
												class="title">评分结果</span></li>

										</ul>
									</div>

									<hr>
									<div class="step-content row-fluid position-relative"
										id="step-container">
										<!-- 一般框框开始录入 -->
										<div class="step-pane active" id="step1">
											<h4 class="blue">一般状况填写</h4>

											<form class="form-horizontal" id="sample-form">
												<div class="form-group">

													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 成立年限 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-1" placeholder="请输入成立年限"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-3"> 企业规模 </label>

													<div class="col-sm-9">


														<select id="form-field-2" class="col-xs-10 col-sm-5">

															<option value="大型">大型</option>
															<option value="中型">中型</option>
															<option value="中小型">中小型</option>
															<option value="小型">小型</option>

														</select>

													</div>
												</div>

												<div class="space-4"></div>
												<div class="form-group">
													<h4 class="blue">人力资源</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-3"> 高管人员数</label>

													<div class="col-sm-9">
														<input type="text" id="form-field-3"
															placeholder="请输入高管人员数" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="space-4"></div>
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-4"> 本科及以上学历或中级及以上职称人数 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-4"
															placeholder="请输入本科及以上学历或中级及以上职称人数 "
															class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="space-4"></div>
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-5"> 高管人员获得人民政府或主管部 门荣誉奖项数（县、市级） </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-5"
															placeholder="请输入获得县市级奖项数" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-6"> 高管人员获得人民政府或主管部 门荣誉奖项数（省级） </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-6"
															placeholder="请输入获得省级奖项数" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-7"> 高管人员获得人民政府或主管部 门荣誉奖项数（国家级） </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-7"
															placeholder="请输入获得国家级奖项数" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-8"> 从业人员数量 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-8"
															placeholder="请输入从业人员数量" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-9"> 本科及以上学历或中级及以上职称人员数量 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-9"
															placeholder="请输入本科及以上学历或中级及以上职称人员数量 "
															class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-10"> 从业人员存在不良记录人数 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-10"
															placeholder="请输入从业人员存在不良记录人数 " class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<h4 class="blue">经营管理</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 法人治理结构及其运行情况 </label>

													<div class="col-sm-9">

														<select id="form-field-2" class="col-xs-10 col-sm-5">

															<option value="AL">优秀</option>
															<option value="AK">良好</option>
															<option value="AZ">一般</option>
															<option value="AR">差劲</option>


														</select>
													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-4"> 各项管理制度覆盖比率 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-12"
															placeholder="请输入各项管理制度覆盖比率 " class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-3"> 获奖项目项目数(地市级) </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-13"
															placeholder="请输入获奖项目项目数(地市级) " class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-4"> 获奖项目项目数(省级) </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-14"
															placeholder="请输入获奖项目项目数(省级)" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-5"> 获奖项目项目数(国家级) </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-15"
															placeholder="请输入 获奖项目项目数(国家级) "
															class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-6"> 主项资质 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-16"
															placeholder="分 高，中上，中，中下，下 级别" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-7"> 增项资质</label>

													<div class="col-sm-9">
														<input type="text" id="form-field-17"
															placeholder="分 高，中上，中，中下，下 级别" class="col-xs-10 col-sm-5" />

													</div>
												</div>


												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-8"> 质量管理体系认证</label>

													<div class="col-sm-9">

														<div class="control-group">

															<div class="radio">
																<label> <input name="form-field-radio1"
																	type="radio" class="ace" /> <span class="lbl">
																		已通过</span>
																</label> <label> <input name="form-field-radio1"
																	type="radio" class="ace" /> <span class="lbl">
																		未通过</span>
																</label>
															</div>
														</div>

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-9"> 安全管理体系认证</label>

													<div class="col-sm-9">

														<div class="control-group">

															<div class="radio">
																<label> <input name="form-field-radio2"
																	type="radio" class="ace" /> <span class="lbl">
																		已通过</span>
																</label> <label> <input name="form-field-radio2"
																	type="radio" class="ace" /> <span class="lbl">
																		未通过</span>
																</label>
															</div>
														</div>

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-10"> 环保质量体系认证</label>

													<div class="col-sm-9">
														<div class="control-group">

															<div class="radio">
																<label> <input name="form-field-radio3"
																	type="radio" class="ace" /> <span class="lbl">
																		已通过</span>
																</label> <label> <input name="form-field-radio3"
																	type="radio" class="ace" /> <span class="lbl">
																		未通过</span>
																</label>
															</div>
														</div>
													</div>
												</div>
											</form>
										</div>

										<!-- 一般状况录入完毕 -->



										<!--财务状况录入开始 -->
										<div class="step-pane" id="step2">
											<form class="form-horizontal" id="sample-form">
												<div class="form-group">
													<h4 class="blue">债权债务状况</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 负债总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-1" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>
												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 年经营现金净流量 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-3" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 年末流动负债 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-4" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 净销售额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-5" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 变动成本总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-6" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 固定经营成本 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-7" placeholder=请输入金额
															" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 营业费用 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-40" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 利息费用 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-8" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 流动资产 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-9" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 存货 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-10" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 流动负债 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-41" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 预付账款 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-11" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 待摊费用 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-12" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<h4 class="blue">资产营运状况</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 销售收入 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-13" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 总资产 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-14" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<h4 class="blue">财务效益状况</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 当期销售净收入 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-15" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 期初应收账款余额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-16" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 期末应收账款余额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-17" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 主营业务收入净额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-18" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 平均流动资产总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-19" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 报告期利润 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-20" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 报告期净利润 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-21" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 期初净资产 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-22" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 报告期发行新股 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-23" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 或债转股等新增净资产 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-24" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 报告期回购 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-25" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 现金分红等减少净资产 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-26" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 报告期月份数 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-27" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 新增净资产下一月份起至报告期期末月份数 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-28" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 减少净资产下一月份起至报告期期末月份数 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-29" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 主营业务收入 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-30" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 主营业务成本 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-31" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 主营业务税金及附加 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-32" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 利润总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-33" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 利息支出 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-34" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 平均资产总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-35" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 利润总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-36" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 成本费用总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-37" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 社会贡献总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-38" placeholder="请输入金额"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

											</form>
										</div>
										<!-- 财务状况录入完毕 -->




										<!-- 创新能力发展信息录入开始 -->
										<div class="step-pane" id="step3">

											<form class="form-horizontal" id="sample-form">
												<div class="form-group">
													<h4 class="blue">债务上限</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 所有者权益 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-1"
															placeholder="请输入所有者权益(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1">期末货币资金</label>

													<div class="col-sm-9">
														<input type="text" id="form-field-2"
															placeholder="请输入期末货币资金(金额)" class="col-xs-10 col-sm-5" />
														<span class="help-inline col-xs-12 col-sm-7"> <span
															class="middle"></span>
														</span>
													</div>
												</div>
												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 期末应收票据 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-3"
															placeholder="请输入期末应收票据(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 期末应收账款 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-4"
															placeholder="请输入期末应收账款(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 期末预付账款 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-5"
															placeholder="请输入期末预付账款(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 期末存货 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-6"
															placeholder="请输入期末存货(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 期末短期借款 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-7"
															placeholder="请输入期末短期借款(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1">期末应付账款</label>

													<div class="col-sm-9">
														<input type="text" id="form-field-40"
															placeholder="请输入期末应付账款(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 期末预收账款 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-8"
															placeholder="请输入期末预收账款(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<h4 class="blue">技术实力状况</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 自由机械设备净值 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-9"
															placeholder="请输入自由机械设备净值(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 年末在册全部职工人数 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-10"
															placeholder="请输入年末在册全部职工人数(人数)"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 获奖数（国家级） </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-41"
															placeholder="请输入获奖数（国家级）" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1">获奖数（省级）</label>

													<div class="col-sm-9">
														<input type="text" id="form-field-11"
															placeholder="请输入获奖数（省级）" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 获奖数（市级） </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-12"
															placeholder="请输入获奖数（市级）" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<h4 class="blue">发展能力状况</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1">年末所有者权益 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-13"
															placeholder="请输入年末所有者权益(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 年初所有者权益 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-14"
															placeholder="请输入年初所有者权益(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 本年营业利润总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-15"
															placeholder="请输入本年营业利润总额(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 上年营业利润总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-16"
															placeholder="请输入上年营业利润总额(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 本年销售额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-17"
															placeholder="请输入本年销售额(金额)" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 上年销售额</label>

													<div class="col-sm-9">
														<input type="text" id="form-field-18"
															placeholder="请输入上年销售额(金额)" class="col-xs-10 col-sm-5" />
													</div>
													<div class="space-4"></div>
												</div>
											</form>
										</div>
										<!-- 创新能力发展信息录入完毕 -->






										<!-- 公共信用监管信息填写录入开始 -->
										<div class="step-pane" id="step4">
											<form class="form-horizontal" id="sample-form">
												<div class="form-group">
													<h4 class="blue">行政监管信用记录</h4>

													<label class="col-sm-3 control-label no-padding-right">
														工商部门书面调查证明 </label>
													<div class="radio">
														<label> &nbsp;&nbsp;&nbsp;<input name="comCer"
															type="radio" class="ace" /> <span class="lbl"> 有</span>
														</label> <label> <input name="comCer" type="radio"
															class="ace" /> <span class="lbl">无</span>
														</label>
													</div>
												</div>
												<div class="space-4"></div>
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="comMinBroRecCnt"> 工商部失信记录次数 </label>

													<div class="col-sm-9">
														<input type="number" id="comMinBroRecCnt"
															placeholder="请输入整数" class="col-xs-10 col-sm-5" /> <span
															class="help-inline col-xs-12 col-sm-7"> <span
															class="middle"></span>
														</span>
													</div>
												</div>
												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">
														税务部门书面调查证明</label>
													<div class="radio">
														<label>&nbsp;&nbsp;&nbsp; <input name="taxCer"
															type="radio" class="ace" /> <span class="lbl"> 有</span>
														</label> <label> <input name="taxCer" type="radio"
															class="ace" /> <span class="lbl">无</span>
														</label>
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">
														纳税级别</label>&nbsp;&nbsp;&nbsp; <select id="taxLev">
														<option value="A">A</option>
														<option value="B">B</option>
														<option value="C">C</option>
														<option value="D">D</option>
													</select>

												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">
														建设部门书面调查证明</label>

													<div class="radio">
														<label>&nbsp;&nbsp;&nbsp; <input name="minConCer"
															type="radio" class="ace" /> <span class="lbl"> 有</span>
														</label> <label> <input name="minConCer" type="radio"
															class="ace" /> <span class="lbl">无</span>
														</label>
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="minConBroCnt"> 建设部失信记录次数</label>

													<div class="col-sm-9">
														<input type="number" id="minConBroCnt" placeholder="请输入整数"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">
														社保行政主管部门书面调查证明 </label>

													<div class="radio">
														<label>&nbsp;&nbsp;&nbsp; <input name="socSecCer"
															type="radio" class="ace" /> <span class="lbl"> 有</span>
														</label> <label> <input name="socSecCer" type="radio"
															class="ace" /> <span class="lbl">无</span>
														</label>
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">
														基本养老保险证明</label>

													<div class="radio">
														<label>&nbsp;&nbsp;&nbsp; <input name="basOldCer"
															type="radio" class="ace" /> <span class="lbl"> 有</span>
														</label> <label> <input name="basOldCer" type="radio"
															class="ace" /> <span class="lbl">无</span>
														</label>
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">
														基本医疗保险证明</label>

													<div class="radio">
														<label>&nbsp;&nbsp;&nbsp; <input name="basMedCer"
															type="radio" class="ace" /> <span class="lbl"> 有</span>
														</label> <label> <input name="basMedCer" type="radio"
															class="ace" /> <span class="lbl">无</span>
														</label>
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">
														工伤保险证明 </label>

													<div class="radio">
														<label>&nbsp;&nbsp;&nbsp; <input name="indInjCer"
															type="radio" class="ace" /> <span class="lbl"> 有</span>
														</label> <label> <input name="indInjCer" type="radio"
															class="ace" /> <span class="lbl">无</span>
														</label>
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">
														失业保险证明 </label>

													<div class="radio">
														<label>&nbsp;&nbsp;&nbsp; <input name="uneCer"
															type="radio" class="ace" /> <span class="lbl"> 有</span>
														</label> <label> <input name="uneCer" type="radio"
															class="ace" /> <span class="lbl">无</span>
														</label>
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<h4 class="blue">司法监管信用记录</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="hasPerCnt"> 已履行数量</label>

													<div class="col-sm-9">
														<input type="number" id="hasPerCnt" placeholder="请输入整数"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="nexThrCnt"> 三年以内案件数量 </label>

													<div class="col-sm-9">
														<input type="number" id="nexThrCnt" placeholder="请输入整数"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="nexThrNotTenCnt"> 三年以上十年以内涉案件数量</label>

													<div class="col-sm-9">
														<input type="number" id="nexThrNotTenCnt"
															placeholder="请输入整数" class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="faiPerCnt"> 未履行案件数量</label>

													<div class="col-sm-9">
														<input type="number" id="faiPerCnt" placeholder="请输入整数"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<h4 class="blue">金融、银行信誉情况</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 央行征信中心出具的企业信用报告 </label>

													<div class="radio">
														<label>&nbsp;&nbsp;&nbsp; <input name="entCreCer"
															type="radio" class="ace" /> <span class="lbl"> 有</span>
														</label> <label> <input name="entCreCer" type="radio"
															class="ace" /> <span class="lbl">无</span>
														</label>
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="notRepPriCnt"> 未能够按时偿还贷款本金及利息次数 </label>

													<div class="col-sm-9">
														<input type="number" id="notRepPriCnt" placeholder="请输入整数"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="banThaLev"> 开户银行认定的等级</label>&nbsp;&nbsp;&nbsp; <select
														id="banThaLev">
														<option value="AAA">AAA</option>
														<option value="AA">AA</option>
														<option value="A">A</option>
														<option value="BBB">BBB</option>
														<option value="BB">BB</option>
														<option value="B">B</option>
														<option value="CCC">CCC</option>
														<option value="CC">CC</option>
														<option value="C">C</option>
													</select>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<h4 class="blue">业务信息</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 注册地省外项目数 </label>

													<div class="col-sm-9">
														<input type="number" id="form-field-1" placeholder="请输入整数"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-3"> 注册地省内外市项目数 </label>

													<div class="col-sm-9">

														<input type="number" id="form-field-2" placeholder="请输入整数"
															class="col-xs-10 col-sm-5" />
													</div>
												</div>

												<div class="space-4"></div>
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-3"> 注册地以外省项目数</label>

													<div class="col-sm-9">
														<input type="number" id="form-field-3" placeholder="请输入整数"
															class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="space-4"></div>
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-4"> 注册地省内外市项目数 </label>

													<div class="col-sm-9">
														<input type="number" id="form-field-4" placeholder="请输入整数"
															class="col-xs-10 col-sm-5" />

													</div>
												</div>

											</form>
										</div>
										<!-- 公共信用监管信息录入结束 -->




										<!-- 企业荣誉附加录开始 -->
										<div class="step-pane" id="step5">
											<form class="form-horizontal" id="sample-form">
												<div class="space-4"></div>

												<div class="form-group">
													<h4 class="blue">社会公益</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-5"> 企业收入总额 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-5"
															placeholder="请输入企业收入总额" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-6"> 慈善与公益捐款 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-6"
															placeholder="请输入慈善与公益捐款额数" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-7">社会公益宣传活动</label>

													<div class="col-sm-9">
														<input type="text" id="form-field-7"
															placeholder="请输入社会公益活动" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-8"> 解决残疾人下岗人就业情况 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-8"
															placeholder="请输入解决残疾人下岗就业情况" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<h4 class="blue">企业荣誉</h4>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-9"> 国家级奖项 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-9"
															placeholder="请输入获得国家级奖项个数" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-10"> 省级奖项 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-10"
															placeholder="请输入获得省级奖项个数" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"> 地市级奖项 </label>

													<div class="col-sm-9">
														<input type="text" id="form-field-11"
															placeholder="请输入获得地方级奖项个数" class="col-xs-10 col-sm-5" />

													</div>
												</div>

												<div class="hr hr-24"></div>

											</form>
										</div>
										<div class="step-pane" id="step6">
											<div class="center">
												<form class="form-horizontal" role="form">
													<div class="row">
														<div class="col-sm-12">
															<div class="widget-box transparent">
																<div class="widget-header widget-header-flat">
																	<h4 class="lighter">
																		<i class="icon-star orange"></i> 评分结果
																	</h4>
																</div>

																<div style="margin-right: 50%">
																	<div class="col-sm-40" align="center">
																		<div class="tabbable">
																			<ul
																				class="nav nav-tabs padding-12 tab-color-blue background-blue"
																				id="myTab4">
																				<li class="active"><a data-toggle="tab"
																					href="#home4">一般状况</a></li>

																				<li class=""><a data-toggle="tab"
																					href="#profile4">财务状况</a></li>

																				<li class=""><a data-toggle="tab"
																					href="#dropdown14">创新和发展能力状况</a></li>

																				<li class=""><a data-toggle="tab"
																					href="#dropdown15">公共信用监管信息</a></li>

																				<li class=""><a data-toggle="tab"
																					href="#dropdown16">企业荣誉</a></li>
																			</ul>

																			<div class="tab-content">
																				<div id="home4" class="tab-pane active">
																					<div class="table-responsive"
																						style="margin-top: 50px">
																						<table id="sample-table-3"
																							class="table table-striped table-bordered table-hover"
																							style="width: 400px;margin-left: 50px">
																							<tbody>
																								<tr>
																									<h3>基本状况详细情况</h3>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">得分项</td>
																									<td>分数</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">历历史沿革</td>
																									<td>1</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">企业规模</td>
																									<td>1</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">高级管理者素
																										质、能力</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">从业人员素质</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">法人治理结构及其运行情况</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">管理制度完备程度和实施</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">项目管理</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">资质情况</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: aqua">质量管理</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: aqua">安全管理</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: aqua">环保</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: #7fff00">总分</td>
																									<td>31</td>
																								</tr>


																							</tbody>
																						</table>
																					</div>
																					<!-- 基本状况 -->
																				</div>

																				<div id="profile4" class="tab-pane">
																					<!-- 财务状况 -->
																					<div class="table-responsive" align="center"
																						style="margin-top: 50px">
																						<table id="sample-table-3"
																							class="table table-striped table-bordered table-hover"
																							style="width: 400px;margin-left: 50px">
																							<tbody>
																								<tr>
																									<h3>财务状况详细情况</h3>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">得分项</td>
																									<td>分数</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">资产负债率</td>
																									<td>1</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">现金流动负债比率</td>
																									<td>1</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">利息保障倍数</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">速动比率</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">总资产周转率</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">应收账款周转率</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">项目管理</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">应收账款周转率</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: aqua">流动资产周转率</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: aqua">净资产收益率</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: aqua">主营业务利润率</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: aqua">主营业务利润率</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: aqua">成本费用利润率</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: aqua">社会贡献率</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: #7fff00">总分</td>
																									<td>31</td>
																								</tr>


																							</tbody>
																						</table>
																					</div>
																					<!-- 财务状况 -->
																				</div>

																				<div id="dropdown14" class="tab-pane">
																					<!-- 创新和发展能力状况 -->
																					<div class="table-responsive" align="center"
																						style="margin-top: 50px">
																						<table id="sample-table-3"
																							class="table table-striped table-bordered table-hover"
																							style="width: 400px;margin-left: 50px">
																							<tbody>
																								<tr>
																									<h3>创新和发展能力详细情况</h3>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">得分项</td>
																									<td>分数</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">债务上限</td>
																									<td>1</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">技术装备率</td>
																									<td>1</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">研发成果</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">资本保值增值率</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">销售(营业)利润增值率</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">销售(营业)增值率</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: #7fff00">总分</td>
																									<td>31</td>
																								</tr>


																							</tbody>
																						</table>
																					</div>
																					<!-- 创新和发展能力状况 -->
																				</div>

																				<div id="dropdown15" class="tab-pane">
																					<!-- 公共信用监管信息和业务信息 -->
																					<div class="table-responsive" align="center"
																						style="margin-top: 50px">
																						<table id="sample-table-3"
																							class="table table-striped table-bordered table-hover"
																							style="width: 400px;margin-left: 50px">
																							<tbody>
																								<tr>
																									<h3>公共信用监管信息和业务信息详细情况</h3>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">得分项</td>
																									<td>分数</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">行政监管信用记录</td>
																									<td>1</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">司法监管信用记录</td>
																									<td>1</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">金融、银行信誉情况</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">其他业务合同
																									</td>
																									<td>4</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">政府采购项目履约情况</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: #7fff00">总分</td>
																									<td>31</td>
																								</tr>


																							</tbody>
																						</table>
																					</div>
																					<!-- 公共信用监管信息和业务信息 -->
																				</div>

																				<div id="dropdown16" class="tab-pane">
																					<!-- 企业荣誉 -->
																					<div class="table-responsive" align="center"
																						style="margin-top: 50px">
																						<table id="sample-table-3"
																							class="table table-striped table-bordered table-hover"
																							style="width: 400px;margin-left: 50px">
																							<tbody>
																								<tr>
																									<h3>企业荣誉详细情况</h3>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">得分项</td>
																									<td>分数</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">社会捐赠</td>
																									<td>1</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">解决残疾人下岗人就业情况</td>
																									<td>1</td>
																								</tr>
																								<tr>
																									<td style="background-color: aqua">获得荣誉</td>
																									<td>4</td>
																								</tr>

																								<tr>
																									<td style="background-color: #7fff00">总分</td>
																									<td>31</td>
																								</tr>


																							</tbody>
																						</table>
																					</div>
																					<!-- 企业荣誉 -->
																				</div>
																			</div>
																		</div>
																	</div>



																</div>
															</div>
															<!-- /widget-box -->
														</div>
													</div>
													<!-- /row -->

													<!-- PAGE CONTENT ENDS -->

												</form>
											</div>
										</div>
									</div>

									<hr>
									<div class="row-fluid wizard-actions">
										<button class="btn btn-prev">
											<i class="icon-arrow-left"></i> 上一项
										</button>

										<button class="btn btn-success btn-next" data-last="完成">
											下一项 <i class="icon-arrow-right icon-on-right"></i>
										</button>
									</div>
								</div>
								<!-- /widget-main -->
							</div>
							<!-- /widget-body -->
						</div>
					</div>
					<!-- .breadcrumb -->









					<!-- PAGE CONTENT ENDS -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>
	<!-- /.main-content -->

	<div class="ace-settings-container" id="ace-settings-container">
		<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
			id="ace-settings-btn">
			<i class="icon-cog bigger-150"></i>
		</div>

		<div class="ace-settings-box" id="ace-settings-box"></div>


		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery
					|| document
							.write("<script src='assets/js/jquery-2.0.3.min.js'>"
									+ "<"+"/script>");
		</script>
		<script type="text/javascript">
			
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if ("ontouchend" in document)
				document
						.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
								+ "<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<script src="assets/js/fuelux/fuelux.wizard.min.js"></script>
		<script src="assets/js/jquery.validate.min.js"></script>
		<script src="assets/js/additional-methods.min.js"></script>
		<script src="assets/js/bootbox.min.js"></script>
		<script src="assets/js/jquery.maskedinput.min.js"></script>
		<script src="assets/js/select2.min.js"></script>

		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			jQuery(function($) {

				$('[data-rel=tooltip]').tooltip();

				$(".select2").css('width', '200px').select2({
					allowClear : true
				}).on('change', function() {
					$(this).closest('form').validate().element($(this));
				});

				var $validation = false;
				$('#fuelux-wizard').ace_wizard().on('change',
						function(e, info) {
							if (info.step == 1 && $validation) {
								if (!$('#validation-form').valid())
									return false;
							}
						}).on('finished', function(e) {
					bootbox.dialog({
						message : "谢谢您! 您的信息已经成功保存!",
						buttons : {
							"success" : {
								"label" : "好的",
								"className" : "btn-sm btn-primary"
							}
						}
					});
				}).on('stepclick', function(e) {
					//return false;//prevent clicking on steps

				});

				$('#skip-validation').removeAttr('checked').on('click',
						function() {
							$validation = this.checked;
							if (this.checked) {
								$('#sample-form').hide();
								$('#validation-form').removeClass('hide');
							} else {
								$('#validation-form').addClass('hide');
								$('#sample-form').show();
							}
						});

				//documentation : http://docs.jquery.com/Plugins/Validation/validate

				$.mask.definitions['~'] = '[+-]';
				$('#phone').mask('(999) 999-9999');

				jQuery.validator.addMethod("phone", function(value, element) {
					return this.optional(element)
							|| /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/
									.test(value);
				}, "Enter a valid phone number.");

				$('#validation-form')
						.validate(
								{
									errorElement : 'div',
									errorClass : 'help-block',
									focusInvalid : false,
									rules : {
										email : {
											required : true,
											email : true
										},
										password : {
											required : true,
											minlength : 5
										},
										password2 : {
											required : true,
											minlength : 5,
											equalTo : "#password"
										},
										name : {
											required : true
										},
										phone : {
											required : true,
											phone : 'required'
										},
										url : {
											required : true,
											url : true
										},
										comment : {
											required : true
										},
										state : {
											required : true
										},
										platform : {
											required : true
										},
										subscription : {
											required : true
										},
										gender : 'required',
										agree : 'required'
									},

									messages : {
										email : {
											required : "Please provide a valid email.",
											email : "Please provide a valid email."
										},
										password : {
											required : "Please specify a password.",
											minlength : "Please specify a secure password."
										},
										subscription : "Please choose at least one option",
										gender : "Please choose gender",
										agree : "Please accept our policy"
									},

									invalidHandler : function(event, validator) { //display error alert on form submit   
										$('.alert-danger', $('.login-form'))
												.show();
									},

									highlight : function(e) {
										$(e).closest('.form-group')
												.removeClass('has-info')
												.addClass('has-error');
									},

									success : function(e) {
										$(e).closest('.form-group')
												.removeClass('has-error')
												.addClass('has-info');
										$(e).remove();
									},

									errorPlacement : function(error, element) {
										if (element.is(':checkbox')
												|| element.is(':radio')) {
											var controls = element
													.closest('div[class*="col-"]');
											if (controls
													.find(':checkbox,:radio').length > 1)
												controls.append(error);
											else
												error.insertAfter(element
														.nextAll('.lbl:eq(0)')
														.eq(0));
										} else if (element.is('.select2')) {
											error
													.insertAfter(element
															.siblings('[class*="select2-container"]:eq(0)'));
										} else if (element.is('.chosen-select')) {
											error
													.insertAfter(element
															.siblings('[class*="chosen-container"]:eq(0)'));
										} else
											error.insertAfter(element.parent());
									},

									submitHandler : function(form) {
									},
									invalidHandler : function(form) {
									}
								});

				$('#modal-wizard .modal-header').ace_wizard();
				$('#modal-wizard .wizard-actions .btn[data-dismiss=modal]')
						.removeAttr('disabled');
			})
		</script>
		<div style="display:none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
				language='JavaScript' charset='gb2312'></script>
		</div>
</body>
</html>