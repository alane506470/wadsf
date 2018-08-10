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
//���Spring�������X�ʪ��ưȺ޲z�\��C
public class HibernateConfig {
 
	//aop���c
    @Autowired
    private ApplicationContext context;
 
    //�Ыؤ@��Hibernate SessionFactory
    //�o�O�bSpring���ε{�ǤW�U�夤�]�m�@��Hibernate SessionFactory���`�Τ�k�C
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        System.out.print("�i�J+LocalSessionFactoryBean");
        sessionFactory.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));//�r�J�ƾڮw��T
        //sessionFactory.setAnnotatedClasses(News.class);
        //sessionFactory.setAnnotatedPackages("com.mynews.model");
        
        sessionFactory.setAnnotatedClasses(Category.class);//��J��/��M�g���
        return sessionFactory;
    }
 
    
    //�NHibernate Session�q���w���u�t�j�w��u�{�A�i�ह�\�C�Ӥu�t�@�ӽu�{�j�w��Session
    @Bean
    public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      System.out.print("�i�J+HibernateTransactionManager");
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
    }
}