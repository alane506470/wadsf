package com.howtodoinjava.demo.dao;

import java.util.List;

import com.howtodoinjava.demo.model.User;

public interface UserService {
	
	void save(User user);
	 
	   List<User> list();
}
