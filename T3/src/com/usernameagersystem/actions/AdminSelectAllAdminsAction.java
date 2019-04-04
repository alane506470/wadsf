package com.usernameagersystem.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class AdminSelectAllAdminsAction extends ActionSupport {
	
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
		}else{
			ImplUser interUser=new ImplUser();
			List allAdminList=interUser.findAllAdmins();
			ActionContext.getContext().getSession().put("allAdminList",allAdminList);
			if(user.getRoleId()==1){
				return "smalladmin";
			}else{
				return "bigadmin";
			}
		}
		
		// TODO Auto-generated constructor stub
	}
}
