//輸入校驗的國際化信息

package com.mxl.actions;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private String username;
	private String password;
	private int age;
	private String phone;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String execute()throws Exception{
		return SUCCESS;
		
	}
}
