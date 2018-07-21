package com.viakiba.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpringWebInitializer implements WebApplicationInitializer {

    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        //AnnotationConfigWebApplicationContext  直译：注解配置web应用上下文对象
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //注册配置项
        context.register(ThymeleafConfig.class);

        //公共步骤
        //把servletContext 注入到上下文中
        context.setServletContext(servletContext);
        // DispatcherServlet  Spring MVC front controller
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
