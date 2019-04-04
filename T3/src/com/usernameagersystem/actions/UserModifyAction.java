package com.usernameagersystem.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class UserModifyAction extends ActionSupport {
	
	private User userinfo;
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	public String execute(){
		
		ImplUser interuser=new ImplUser();
		int id=interuser.getUserid(userinfo.getUsername(),userinfo.getPassword());
		//�d��Τ�id
		int roleid=interuser.getUserroleId(id);//�ھ�id�d��roleId
		userinfo.setId(id);
		userinfo.setRoleId(roleid);
		int count=interuser.modifyUserInfo(userinfo);
		
		if(count>0){
			return "success";
		}else{
			return "error";
		}
		
	}
}
