package com.mynews.service;

import java.util.List;

import com.mynews.model.Category;

public interface CategoryService {
	
	String test();
	List<Category> list();
	List<Category> selectListByTopId(int topId);
	Void insertCategory(Category category);
}
