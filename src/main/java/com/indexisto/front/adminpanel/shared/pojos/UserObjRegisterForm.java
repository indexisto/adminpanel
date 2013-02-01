package com.indexisto.front.adminpanel.shared.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserObjRegisterForm extends UserObj {
	/**
	 * User object with password filed. Use it in login and registration forms.
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull (message="Password field must be filled")
	@Size(min = 3, message="Password must be 3 characters at least")
	@Pattern(regexp= "^[a-zA-Z0-9]*$", message="Only latin characters and digits please")
	private String pass1 = "";
	
	
	@NotNull (message="Password field must be filled")
	@Size(min = 3, message="Password must be 3 characters at least")
	@Pattern(regexp= "^[a-zA-Z0-9]*$", message="Only latin characters and digits please")
	private String pass2 = "";
	
	public String getPass1() {
		return pass1;
	}
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
}
