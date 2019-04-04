package com.usernameagersystem.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class AddUserAction extends ActionSupport {
private User user;
	
public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


	public String execute() throws Exception {
		ImplUser interUser=new ImplUser();
		user.setRoleId(0);
		int count=interUser.addUser(user);
		System.out.print(count);
		if(count>0){
			return "success";
		}else{
			return "input";
		}
		
		// TODO Auto-generated constructor stub
	}
}
