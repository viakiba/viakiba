package com.tdvm.base.freemarker;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import com.tdvm.base.UpdateConst;


public class RichFreeMarkerView extends FreeMarkerView {

	protected void exposeHelpers(Map<String, Object> model,
			HttpServletRequest request) throws Exception {
		super.exposeHelpers(model, request);
		model.put(UpdateConst.VIEW_PATH, request.getContextPath());
	}
}