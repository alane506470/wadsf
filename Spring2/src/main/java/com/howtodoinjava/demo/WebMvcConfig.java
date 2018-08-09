package com.howtodoinjava.demo;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration  //@Configuration表示一個類聲明了一個或多個@Bean方法，並且可以由Spring容器處理，以便在運行時為這些bean生成bean定義和服務請求。
@EnableWebMvc   //@EnableWebMvc啟用默認的Spring MVC配置並註冊所期望的Spring MVC基礎架構組件DispatcherServlet。
@ComponentScan(basePackages = { "com.howtodoinjava.demo"}) //@ComponentScan註釋用於指定要掃描的基礎包。
public class WebMvcConfig implements WebMvcConfigurer {
 
   @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
   
   //spring中实现了MessageSource接口的类可以配置信息源，常用的有ResourceBundleMessageSource
   //和ReloadableResourceBundleMessageSource
   @Bean
   public MessageSource messageSource() {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();  //使用指定的基本名稱訪問資源包（這裡是消息）
      source.setBasename("messages");
      return source;
   }
 
   
   //並通過Spring Validator接口以及JSR-303 Validator接口和ValidatorFactory接口本身公開它
   public Validator getValidator() {
      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
      validator.setValidationMessageSource(messageSource());
      return validator;
   }
}