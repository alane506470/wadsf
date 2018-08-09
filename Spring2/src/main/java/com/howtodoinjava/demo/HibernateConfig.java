package com.howtodoinjava.demo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.howtodoinjava.demo.model.User;

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
        sessionFactory.setAnnotatedClasses(User.class);//��J��/��M�g���
        return sessionFactory;
    }
 
    
    //�NHibernate Session�q���w���u�t�j�w��u�{�A�i�ह�\�C�Ӥu�t�@�ӽu�{�j�w��Session
    @Bean
    public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
    }
}