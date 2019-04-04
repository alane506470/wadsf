package com.usernameagersystem.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;

public class AdminDeleteUserAction extends ActionSupport {
	
	private int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String execute() throws Exception {
		
		ImplUser interUser=new ImplUser();
		//���R������åB�Ƕi�Ӫ�id
		int count=interUser.deleteUser(id);
		//�A���s�d��Ҧ�users
		List alluserList=interUser.findAllUsers();
		if(count!=0){
			if(ActionContext.getContext().getSession().containsKey("alluserList")){
				ActionContext.getContext().getSession().remove("alluserList");
			}
			//��s���s���session
				ActionContext.getContext().getSession().put("alluserList",alluserList);
				return "success";
			
		}
		return "failure";
		
		// TODO Auto-generated constructor stub
	}
}
