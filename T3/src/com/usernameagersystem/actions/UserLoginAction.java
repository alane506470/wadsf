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
		//利用帳號與密碼茶道用戶所有資料並且復職給User
		//所以現在的User是擁有用戶所有資訊的
		if(flag){
			System.out.print("有"+user.getId());
			System.out.print(user.getPassword());
			//將user放到session中
			ActionContext.getContext().getSession().put("user", user);
			return "success";
		}else{
			return "input";
		}
	
		
		// TODO Auto-generated constructor stub
	}
}
