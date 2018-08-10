package com.mynews.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mynews.model.Category;

@Repository
public class CategoryDaoImp implements CategoryDao{

	
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	 @Transactional
	public List<Category> selectListByTopId(int topId) {
		// TODO Auto-generated method stub
		 return sessionFactory.getCurrentSession().createQuery("from Category where topId="+topId+"order by id desc").list();
	}

	public String test() {
		// TODO Auto-generated method stub
		return "´ú¸Õservice";
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

}
