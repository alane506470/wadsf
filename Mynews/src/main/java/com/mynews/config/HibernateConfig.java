package com.mynews.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mynews.model.Category;
import com.mynews.model.News;



@Configuration
@EnableTransactionManagement
//支持Spring的註釋驅動的事務管理功能。
public class HibernateConfig {
 
	//aop結構
    @Autowired
    private ApplicationContext context;
 
    //創建一個Hibernate SessionFactory
    //這是在Spring應用程序上下文中設置共享Hibernate SessionFactory的常用方法。
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        System.out.print("進入+LocalSessionFactoryBean");
        sessionFactory.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));//毒入數據庫資訊
        //sessionFactory.setAnnotatedClasses(News.class);
        //sessionFactory.setAnnotatedPackages("com.mynews.model");
        
        sessionFactory.setAnnotatedClasses(Category.class);//輸入類/表映射文件
        return sessionFactory;
    }
 
    
    //將Hibernate Session從指定的工廠綁定到線程，可能允許每個工廠一個線程綁定的Session
    @Bean
    public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      System.out.print("進入+HibernateTransactionManager");
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
    }
}