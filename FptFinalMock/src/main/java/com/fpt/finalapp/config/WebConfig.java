package com.fpt.finalapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/assets/css/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/assets/fonts/");
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/assets/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/assets/img/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
	

	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
	      LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
	      localeInterceptor.setParamName("lang");
	    
	    
	      registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
	  }
}
