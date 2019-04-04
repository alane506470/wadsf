package com.usernameagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.User;

public class IfCanAddAdmin extends ActionSupport {

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
			this.setTip("�ХH�޲z�������n�������һݥ\��");
			return "failure";
			
		}else if(user.getRoleId()==1){
			this.setTip("�ХH�޲z�������n�������һݥ\��");
			return "failure";
				
		}else{
			return "success";
		}
				
	}
		
}
