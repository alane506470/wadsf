package com.usernameagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class UserLoginAction extends ActionSupport {
	
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		ImplUser interUser=new ImplUser();
		boolean flag=interUser.login(user);
		//�Q�αb���P�K�X���D�Τ�Ҧ���ƨåB�_¾��User
		//�ҥH�{�b��User�O�֦��Τ�Ҧ���T��
		if(flag){
			System.out.print("��"+user.getId());
			System.out.print(user.getPassword());
			//�Nuser���session��
			ActionContext.getContext().getSession().put("user", user);
			return "success";
		}else{
			return "input";
		}
	
		
		// TODO Auto-generated constructor stub
	}
}
