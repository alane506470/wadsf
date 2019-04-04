package com.usernameagersystem.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class AdminModifyAction extends ActionSupport {
	
private User userinfo;
	
	

	public User getUserinfo() {
	return userinfo;
}



public void setUserinfo(User userinfo) {
	this.userinfo = userinfo;
}



	public String execute() throws Exception {
		ImplUser interUser=new ImplUser();
		System.out.println(userinfo.getId());
		//�d��Τ�id
		int id=interUser.getUserid(userinfo.getUsername(),userinfo.getPassword());
		//��userinfo��Hid�Mroleid�ݩʴ_¾
		userinfo.setId(id);
		userinfo.setRoleId(1);
		interUser.modifyUserInfo(userinfo);
		return "success";
		
		
		// TODO Auto-generated constructor stub
	}
}
