package com.usernameagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usernameagersystem.entity.ImplUser;
import com.usernameagersystem.entity.User;

public class UserScanAction extends ActionSupport {
	
	public String execute(){
		ImplUser interUser=new ImplUser();
		User user=(User)ActionContext.getContext().getSession().get("user");
		System.out.print("���ӬO��"+user.getPassword());
		//this.setId(user.getId());
		//��e�Τ�d�ݫȤH�H����ID���{��0�ѩ�O��e�Τ�ҥH�|��SESSION�����XUSER��H�ô_¾��USERINFO
		//�p�G�O��e�Τ�d�ݨ�L�Τ�H����STRUTS�t�m���]�|��즹Action�åB�|�ǤJ�@�ӰѼ�Id�]���b
		//userscanaction���n���F�@���ܶqid�B����set�Mget��k
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
