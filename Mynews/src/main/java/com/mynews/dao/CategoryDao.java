package com.mynews.dao;

import java.util.List;

import com.mynews.model.Category;



public interface CategoryDao {
	String test();
	List<Category> list();
	List<Category> selectListByTopId(int topId);
	Void insertCategory(Category category);
}
