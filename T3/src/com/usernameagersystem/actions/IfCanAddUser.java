package com.usernameagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.User;

public class IfCanAddUser extends ActionSupport {
	
private String tip;
	

	public String getTip() {
	return tip;
}


public void setTip(String tip) {
	this.tip = tip;
}


	public String execute() throws Exception {
		
		User user=(User)ActionContext.getContext().getSession().get("user");
		if(user.getRoleId()==0){
			this.setTip("普通用戶不具備添加新用戶權縣");
			return "failure";
		}else{
			return "success";
		}
		
		// TODO Auto-generated constructor stub
	}
}
