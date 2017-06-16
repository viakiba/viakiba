<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<a class="menu-toggler" id="menu-toggler" href="#"> <span
	class="menu-text"></span>
</a>
         <script type="text/javascript" src="assets/js/1.10.2/jquery-1.10.1.min.js"></script>
  	    <script type="text/javascript" src="assets/js/1.10.2/alertPopShow.js"></script>

<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">


		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<!-- #sidebar-shortcuts -->

	<ul class="nav nav-list">
		<li><a href="index.jsp" class="dropdown-toggle"> <i
				class="icon-desktop"></i> <span class="menu-text"> 主页 </span>


		</a></li>
        <c:if test="${u.right==0 || u.right==3 || u.right==2 }">
		<li class="open"><a href="#" class="dropdown-toggle"> <i class="icon-list-alt"></i> <span class="menu-text"> 企业管理 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu" style="display: none;">
				<li><a href="companyType.action"> <i
						class="icon-double-angle-right"></i>添加企业
				</a></li>
				<li><a href="endCompanyInfo.action"> <i
						class="icon-double-angle-right"></i>完善企业信息
				</a></li>
			</ul></li>
			</c:if>
			
		<!-- <li><a href="addMechanism.jsp"> <i class="icon-edit"></i> <span
				class="menu-text"> 添加机构 </span>
		</a></li> -->
		
		<c:if test="${u.right==0 }">
		<li class="open"  id="li1"><a href="#" class="dropdown-toggle"> <i class="icon-edit"></i>  <span class="menu-text">机构管理 </span> <b
				class="arrow icon-angle-down"></b>
		</a>
			<ul class="submenu" style="display: none;">
				<li><a href="beforeAddMechanis.action"> <i
						class="icon-double-angle-right"></i>添加机构
				</a></li>
				<li><a href="getMechanism.action"> <i
						class="icon-double-angle-right"></i>删除机构
				</a></li>
			</ul></li>
		</c:if>
		
        <c:if test="${u.right==0 }">
		<li class="open"><a href="#" class="dropdown-toggle"> <i class="icon-list-alt"></i> <span class="menu-text"> 用户管理 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu" style="display: none;">
				<li><a href="beforeAddUser.action"> <i
						class="icon-double-angle-right"></i>添加用户
				</a></li>
				<li><a href="getUMR.action?userName=${u.userName }"> <i
						class="icon-double-angle-right"></i>删除用户
				</a></li>
			</ul>
			
			</li>
			</c:if>
		<c:if test="${u.right==0 || u.right==1 }">			
		<li><a href="examapproval.jsp"> <i class="icon-picture"></i>
				<span class="menu-text"> 审批 </span>
		</a></li>
        </c:if>

	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
			data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	
	</script>
	

</div>
