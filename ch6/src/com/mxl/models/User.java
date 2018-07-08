package com.mxl.models;

public class User {

	private String username;
	private String password;
	private String realname;
	private String phone;
	private String address;
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
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		if(realname==null||"".equals(realname)){
			this.realname = "°Î¦W";
		}else{
			this.realname = realname;
		}
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address==null||"".equals(address)){
			this.address = "«O±K";
		}else{
			this.address = address;
		}
	}
	
	
}
