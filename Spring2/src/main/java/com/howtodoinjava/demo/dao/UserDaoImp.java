package com.howtodoinjava.demo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.demo.model.User;

@Repository
public class UserDaoImp implements UserDao{
	
	   @Autowired
	    private SessionFactory sessionFactory;
	  

	public void save(User user) {
		// TODO Auto-generated method
		  sessionFactory.getCurrentSession().save(user);
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		 //@SuppressWarnings("unchecked")
		 //Query query = (Query) sessionFactory.getCurrentSession().createQuery("from User");
		 //List query1=(List) sessionFactory.getCurrentSession().createSQLQuery("select * from User");
		 
		 //javax.persistence.Query query=(Query) sessionFactory.getCurrentSession().createSQLQuery("select * from User");
	      //return query.getResultList();
	      return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	}

