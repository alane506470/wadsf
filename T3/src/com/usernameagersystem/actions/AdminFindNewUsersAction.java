package com.usernameagersystem.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class AdminFindNewUsersAction extends ActionSupport {
	
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
		}else{
			ImplUser interUser=new ImplUser();
			List newuserlist=interUser.findNewUsers();
			if(ActionContext.getContext().getSession().containsKey("newuserlist")){
				ActionContext.getContext().getSession().remove("newuserlist");
				ActionContext.getContext().getSession().put("newuserlist",newuserlist);
				return "success";
			}else{
				ActionContext.getContext().getSession().put("newuserlist",newuserlist);
				return "success";
			}
				
		}
	
		
		// TODO Auto-generated constructor stub
	}
}
