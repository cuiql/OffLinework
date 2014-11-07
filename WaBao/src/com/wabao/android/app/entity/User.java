package com.wabao.android.app.entity;

public class User {

	private String mUserId;
	private String mUserName;
	private String mUserPwd;
	private String mEmail;
	private String mSex;

	public void setUserId(String userId) {
		mUserId = userId;
	}
	
	public String getUserId(){
		return mUserId;
	}
	
	public void setUserName(String userName){
		mUserName = userName;
	}
	
	public String getUserName(){
		return mUserName;
	}
	
	public void setUserPwd(String pwd){
		mUserPwd = pwd;
	}
	
	public String getUserPwd(){
		return mUserPwd;
	}
	
	public void setEmail(String email){
		mEmail = email;
	}
	
	public String getEmail(){
		return mEmail;
	}
	
	public void setSex(String sex){
		mSex = sex;
	}
	
	public String getSex(){
		return mSex;
	}
	
	

}
