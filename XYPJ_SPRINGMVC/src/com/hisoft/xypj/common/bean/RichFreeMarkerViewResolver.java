package com.hisoft.xypj.common.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * ViewResolver for RichFreeMarkerView
 * 
 * Override buildView, if viewName start with / , then ignore prefix.
 * 
 */
public class RichFreeMarkerViewResolver extends AbstractTemplateViewResolver {
	private static final Logger log = LoggerFactory.getLogger(RichFreeMarkerViewResolver.class);

	public RichFreeMarkerViewResolver() {
		setViewClass(RichFreeMarkerView.class);
	}

	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		log.debug("##########RichFreeMarkerViewResolver<Start>##########");
		AbstractUrlBasedView view = super.buildView(viewName);
		if (viewName.startsWith("/")) {
			view.setUrl(viewName + getSuffix());
		}
		log.debug("##########RichFreeMarkerViewResolver<End>##########");
		return view;
	}
}