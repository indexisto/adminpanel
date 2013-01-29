package com.indexisto.front.adminpanel.shared.pojos;


import java.io.Serializable;

public class UserObj implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String uid = "504466d822d20bf487f5a592";
	private String nick= "Anonymous";
	private String email= "anonymous@anonymous.com";
	private boolean isFBUser= false;
	private int userRole= 0;
	private String FBaccess_token= null;
	private int FBexpires= 0;
	private boolean VIP = false;



	public UserObj() {

	}



	public String getUid() {
		return uid.trim();
	}



	public void setUid(String uid) {
		this.uid = uid.trim();
	}



	public String getNick() {
		return nick;
	}



	public void setNick(String nick) {
		this.nick = nick;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isFBUser() {
		return isFBUser;
	}



	public void setFBUser(boolean isFBUser) {
		this.isFBUser = isFBUser;
	}



	public int getUserRole() {
		return userRole;
	}



	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}



	public String getFBaccess_token() {
		return FBaccess_token;
	}



	public void setFBaccess_token(String fBaccess_token) {
		FBaccess_token = fBaccess_token;
	}



	public int getFBexpires() {
		return FBexpires;
	}



	public void setFBexpires(int fBexpires) {
		FBexpires = fBexpires;
	}
	
	public boolean isAnonymous() {
		if (this.nick.equals("Anonymous")) {
			return true;
		}
		else {
			return false;
		}
	}



	public boolean isVIP() {
		return VIP;
	}



	public void setVIP(boolean vIP) {
		VIP = vIP;
	}
	
	/*
	public void setUserRoleFromCookie(CookieObj cookieObj) {
		//this.email = "";
		//private String md5session = "";
		//private boolean isFBUser = false;
		this.userRole = cookieObj.getUserRole();
		//private String nick = "Anonymous";
	}*/
}