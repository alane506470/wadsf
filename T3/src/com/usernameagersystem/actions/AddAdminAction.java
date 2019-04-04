package com.usernameagersystem.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class AddAdminAction extends ActionSupport {
	
	private User admin;
	

	public User getAdmin() {
		return admin;
	}


	public void setAdmin(User admin) {
		this.admin = admin;
	}


	public String execute() throws Exception {
		ImplUser interUser=new ImplUser();
		int addSuccess=interUser.addAdmin(admin);
		List alladminList=interUser.findAllAdmins();
		if(addSuccess!=0){
			if(ActionContext.getContext().getSession().containsKey("alladminList")){
				ActionContext.getContext().getSession().remove("alladminList");
				ActionContext.getContext().getSession().put("alladminList",alladminList);
				return "success";
			}else{
				ActionContext.getContext().getSession().put("alladminList",alladminList);
				return "success";
			}
		}
		else{
			return "false";
		}
		
		// TODO Auto-generated constructor stub
	}
}
