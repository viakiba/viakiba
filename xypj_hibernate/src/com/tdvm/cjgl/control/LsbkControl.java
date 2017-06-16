package com.tdvm.cjgl.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * Project Name：lsbk
 * ClassName：UpdateControl
 * Description�?
 * @author: 柳凯�?
 * note:
 *
 */
@Controller
@Scope("session")
public class LsbkControl {

	private static Logger log = LoggerFactory.getLogger(LsbkControl.class);


	@RequestMapping("/lsbk/index.do")
	public String toMainPage(HttpServletRequest request, HttpServletResponse response, String url, String versionId) {

		request.setAttribute("versionId", versionId);
		return url;

	}

	
}
