package com.hisoft.xypj.common.bean;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;


public class RichFreeMarkerView extends FreeMarkerView {

	protected void exposeHelpers(Map<String, Object> model,
			HttpServletRequest request) throws Exception {
		super.exposeHelpers(model, request);
		model.put("path", request.getContextPath());
	}
}