package com.indexisto.front.adminpanel.server.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public interface UserExec {
	//public void  AllowRoles(int[]allowedRoles) throws RPCServiceExeption;
	public UserObj getUserFromCookie(HttpServletRequest request) throws RPCServiceExeption;
	public UserObj createUser(UserObjRegisterForm userObjRegisterForm) throws RPCServiceExeption;
	public UserObj loginUserAndSetCookie(UserObjRegisterForm userObjRegisterForm) throws RPCServiceExeption;
	public UserObj createUserAndSetCookie(UserObjRegisterForm userObjRegisterForm, HttpServletResponse response) throws RPCServiceExeption;	
}
