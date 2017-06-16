package com.tdvm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tdvm.base.UpdateConst;
import com.tdvm.cjgl.bean.UserBean;
import com.tdvm.tool.HelpFunctions;

/**
 * 系统过滤�?
 */
public class LsbkFilter implements Filter {

	private static Logger log = LoggerFactory.getLogger(LsbkFilter.class);

	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		String url = request.getRequestURI();
		
		try {
			if (!checkUrlExt(url)) {

				log.info("请求URI:" + url);
				if (url.equals(UpdateConst.LOGIN_URI) || url.equals(UpdateConst.LOGIN_CHECK_URL)) {
					log.debug("收到登录请求");
					session.removeAttribute(UpdateConst.SESSION_USER_NAME);
				} else {
					UserBean user = (UserBean) session.getAttribute(UpdateConst.SESSION_USER_NAME);
					if (url.equals(UpdateConst.ROOT_URI) ||user == null || HelpFunctions.isEmpty(user.getUserId())) {
						log.debug("尚未登录,跳转到登录页");
						response.sendRedirect(request.getContextPath() + UpdateConst.LOGIN_URL);
						return;
					}
					//servletRequest.setAttribute(UpdateConst.SYSTEM_VERSION, SysConfigInfo.getConfigInfoByPath(SysConfigNode.VERSIONINFO));
				}
			}
		} catch (Exception e) {
			log.error("登录过滤失败:" + e.getMessage(), e);
			response.sendRedirect(request.getContextPath() + UpdateConst.LOGIN_URL);
			return;
		}
		chain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {

	}

	/**
	 * 对免登陆后缀进行验证
	 * @param url
	 * @return
	 */
	private boolean checkUrlExt(String url) {

		url = url.trim().toLowerCase();
		boolean flag = false;
		for (String ext : UpdateConst.NO_LOGIN_EXT) {
			if (url.endsWith(ext)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

}
