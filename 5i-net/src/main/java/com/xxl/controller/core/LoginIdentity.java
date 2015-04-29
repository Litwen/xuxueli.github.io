package com.xxl.controller.core;

import java.io.Serializable;

/**
 * 登陆身份
 * @author xuxueli
 */
@SuppressWarnings("serial")
public class LoginIdentity implements Serializable {
	
	private int userId;
	private String userName;
	private String password;
	private String userToken;
	private String realName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
}
