package com.usernameagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class ModifyDispatchAction extends ActionSupport {
	
	
	private User userinfo;
	private int id;
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
	
	public String execute(){
		ImplUser interuser=new ImplUser();
		User user=(User)ActionContext.getContext().getSession().get("user");
		if(id!=0){//id������0��ܷ�e�Τᤣ�A�q�L�����ק�ӤH�H������즹action�W
			this.setUserinfo(interuser.selectUserInfo(id));
			return "othersmodify";
		}else{
			this.setUserinfo(user);
			return "usermodify";
		}
	}
}
