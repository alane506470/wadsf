package com.mxl.actions;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.mxl.models.*;

public class UserAction extends ActionSupport{

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String register(){
		return SUCCESS;
		
	}
	public void validateRegister(){
		String pattern="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		if(user.getUsername().trim()==null||"".equals(user.getUsername().
				trim())){
			this.addFieldError("username", "用戶名不能為空");
		}else if(user.getUsername().trim().length()<6||user.getUsername().trim().length()>20){
			this.addFieldError("username", "用戶名長度必須在6-20之間");
		
		}else if(user.getPassword().trim()==null||"".equals(user.getPassword().trim())){
			this.addFieldError("password", "密碼不能為空");
			
		}else if(user.getPassword().trim().length()<6||user.getPassword().trim().length()>20){
			this.addFieldError("password", "密碼長度必須在6-20之間");
		}else if(!Pattern.compile(pattern).matcher(user.getPhone().trim()).
				matches()){
			this.addFieldError("phone","電話輸入有誤");
		}
	
	}
}
