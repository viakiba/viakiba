<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html lang="en">
<head>
<title>信用评价系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="Hisoft" />
<meta name="description" content="Hisoft" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- basic styles -->

<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->

<!-- fonts -->
<link rel="stylesheet"
	href="assets/css/cyrillic-ext.css?family=Open+Sans:400,300" />

<!-- ace styles -->

<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body class="login-layout">
	<form name="myform" action="login.action" method="post">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i> <span class="red">信用</span> <span
										class="white">评价系统</span>
								</h1>
								<h4 class="blue">© Credit evaluation systeme</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box"
									class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i> 请输入用户名和密码
											</h4>

											<div class="space-6"></div>

											<form>
												<fieldset>
													<label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															type="text" name="user.userName" class="form-control"
															placeholder="用户名" /> <i class="icon-user"></i>
													</span>
													</label> <label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															type="password" name="user.userPassword"
															class="form-control" placeholder="密码" /> <i
															class="icon-lock"></i>
													</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">

														<label class="inline"> <input type="checkbox"
															class="ace"> <span class="lbl"> 记住密码</span>
														</label>

														<button type="submit"
															class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i> 登录
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>
										</div>
										<!-- /widget-main -->

										<div class="toolbar clearfix">
											
										</div>
									</div>
									<!-- /widget-body -->
								</div>
								<!-- /login-box -->
							</div>
							<!-- /position-relative -->
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
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
									+ "<"+"/script>");
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

		<!-- inline scripts related to this page -->

		
		<div style="display:none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
				language='JavaScript' charset='gb2312'></script>
		</div>
	</form>
</body>

</html>
