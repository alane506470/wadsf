package com.usernameagersystem.actions;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class GetAllUsersAction extends ActionSupport {
	

	
	public String execute(){
		
			
		System.out.print("¶i¤Jgetallusersaction...");
		ImplUser interUser=new ImplUser();
		List alluserList=interUser.findAllUsers();
		if(ActionContext.getContext().getSession().containsKey("alluserList")){
			ActionContext.getContext().getSession().remove("alluserList");
		}
		ActionContext.getContext().getSession().put("alluserList",alluserList);
		User user=(User)ActionContext.getContext().getSession().get("user");
		if(user.getRoleId()==0)
		{
			System.out.print("ªð¦^main.jsp...");
			return "userselect";
		}else{
			return "adminselect";
		}
	}
}
