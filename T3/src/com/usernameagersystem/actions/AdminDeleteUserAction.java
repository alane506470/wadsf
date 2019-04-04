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
		//先刪除選取並且傳進來的id
		int count=interUser.deleteUser(id);
		//再重新查找所有users
		List alluserList=interUser.findAllUsers();
		if(count!=0){
			if(ActionContext.getContext().getSession().containsKey("alluserList")){
				ActionContext.getContext().getSession().remove("alluserList");
			}
			//把新的群放到session
				ActionContext.getContext().getSession().put("alluserList",alluserList);
				return "success";
			
		}
		return "failure";
		
		// TODO Auto-generated constructor stub
	}
}
