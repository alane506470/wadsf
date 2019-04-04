package com.usernameagersystem.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class AdminGetDataAction extends ActionSupport {
	
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public User getUserinfo() {
		return userinfo;
	}



	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	private User userinfo;
	
	public String execute() throws Exception {
		ImplUser interUser=new ImplUser();
		this.setUserinfo(interUser.selectUserInfo(id));
		return "success";
		
		
		// TODO Auto-generated constructor stub
	}
}
