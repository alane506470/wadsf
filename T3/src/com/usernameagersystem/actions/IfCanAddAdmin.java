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
			this.setTip("請以管理員身分登錄完成所需功能");
			return "failure";
			
		}else if(user.getRoleId()==1){
			this.setTip("請以管理員身分登錄完成所需功能");
			return "failure";
				
		}else{
			return "success";
		}
				
	}
		
}
