package com.mynews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mynews.dao.CategoryDao;
import com.mynews.model.Category;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	 @Transactional (readOnly = true)
	public List<Category> selectListByTopId(int topId) {
		// TODO Auto-generated method stub
		   return categoryDao.selectListByTopId(topId);
	}

	public String test() {
		// TODO Auto-generated method stub
		return categoryDao.test();
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryDao.list();
	}

}
