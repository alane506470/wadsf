package com.usernameagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class UserScanAction extends ActionSupport {
	
	public String execute(){
		ImplUser interUser=new ImplUser();
		User user=(User)ActionContext.getContext().getSession().get("user");
		System.out.print("應該是有"+user.getPassword());
		//this.setId(user.getId());
		//當前用戶查看客人信息時ID莫認為0由於是當前用戶所以會重SESSION中取出USER對象並復職給USERINFO
		//如果是當前用戶查看其他用戶信息由STRUTS配置文件也會找到此Action並且會傳入一個參數Id因為在
		//userscanaction中聲明了一個變量id且提供set和get方法
		if(id!=0){
			this.setUserinfo(interUser.selectUserInfo(id));
			return SUCCESS;
		}else{
			this.setUserinfo(user);
			System.out.print(userinfo.getEmail());
			return SUCCESS;
		}
	}
	
	private int id;
	private User userinfo;
	
	public User getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
