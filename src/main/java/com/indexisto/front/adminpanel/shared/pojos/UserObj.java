package com.indexisto.front.adminpanel.shared.pojos;


import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserObj implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String uid = "";
	
	@NotNull (message="Name field must be filled")
	@Size(min = 2, message="Name must be 2 characters at least")
	@Pattern(regexp= "^[a-zA-Z0-9\\s]*$", message="Only latin characters and digits please")
	private String name= "";
	
	@NotNull (message="Email field must be filled")
	@Pattern(regexp= "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$",  message="Provide valid email please")
	private String email= "";
	

	
	
	private UserRoles userRole= UserObj.UserRoles.UNREGISTERED;
	private boolean isDemoRegistered = false;	


	public static enum UserRoles {
		REGISTERED, UNREGISTERED, ADMIN
	}
	

	public UserObj() {

	}



	public String getUid() {
		return uid.trim();
	}



	public void setUid(String uid) {
		this.uid = uid.trim();
	}




	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public UserRoles getUserRole() {
		return userRole;
	}



	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public boolean isDemoRegistered() {
		return isDemoRegistered;
	}



	public void setDemoRegistered(boolean isDemoRegistered) {
		this.isDemoRegistered = isDemoRegistered;
	}





}