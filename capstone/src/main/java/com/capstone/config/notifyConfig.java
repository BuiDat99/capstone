//package com.capstone.config;
//
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class notifyConfig implements WebMvcConfigurer {
//
//	//load message of file properties
//	   @Bean
//	    public MessageSource messageSource() {
//	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//	        // Tải file: validation.properties
//	        messageSource.setBasename("classpath:validation");
//	        messageSource.setDefaultEncoding("UTF-8");
//	        return messageSource;
//	    }
//}
