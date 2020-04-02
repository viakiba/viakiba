package haust.vk.configuration;

import haust.vk.interceptor.AllInterceptor;
import haust.vk.interceptor.CityInterceptor;
import haust.vk.interceptor.ProvinceInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public AllInterceptor allInterceptor(){
		System.out.println("init allInterceptor");
		return new AllInterceptor();
	}
	
	@Bean
	public CityInterceptor cityInterceptor(){
		System.out.println("init cityInterceptor");
		return new CityInterceptor();
	}
	
	@Bean
	public ProvinceInterceptor provinceInterceptor(){
		System.out.println("init provinceInterceptor");
		return new ProvinceInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//设置进拦截器   病规定拦截url的规则
		registry.addInterceptor(allInterceptor()).addPathPatterns("/test/**");
		registry.addInterceptor(cityInterceptor()).addPathPatterns("/test/city");
		registry.addInterceptor(provinceInterceptor()).addPathPatterns("/test/province");
		System.out.println("init addInterceptors");
		super.addInterceptors(registry);
	}
}
