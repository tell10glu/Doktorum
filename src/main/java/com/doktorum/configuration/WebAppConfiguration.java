package com.doktorum.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com.doktorum")
@EnableAsync
@EnableScheduling
//@Import(MongoDBConfiguration.class)
@PropertySource(value = { "classpath:application.properties" })
public class WebAppConfiguration extends WebMvcConfigurerAdapter {
    
	@Bean
	@Description("Thymeleaf template resolver serving HTML 5")
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCacheable(false);
		templateResolver.setCharacterEncoding("UTF-8");
		return templateResolver;
	}
	
	@Bean
	@Description("Thymeleaf template engine with Spring integration")
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		
		return templateEngine;
	}
	
	@Bean
	@Description("Thymeleaf view resolver")
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
	
	@Bean
	@Description("Spring message resolver")
    public ResourceBundleMessageSource messageSource() {  
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();  
        messageSource.setBasename("i18n/messages");
        return messageSource;  
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
    }
}
