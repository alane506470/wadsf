package com.usernameagersystem.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;

public class AdminDeleteAdminAction extends ActionSupport {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	private String tip;
	
	public String execute() throws Exception {
		ImplUser interUser=new ImplUser();
		interUser.deleteUser(id);
		List alladminList=interUser.findAllAdmins();
		ActionContext.getContext().getSession().remove("alladminList");
		ActionContext.getContext().getSession().put("alladminList",alladminList);
		return "success";
		
		
		// TODO Auto-generated constructor stub
	}
}
