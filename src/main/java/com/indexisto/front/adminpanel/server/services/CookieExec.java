package com.indexisto.front.adminpanel.server.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;

public interface CookieExec {
	void checkCookiesValid(HttpServletRequest request) throws RPCServiceExeption ;
	void setCookies(HttpServletResponse response, UserObj userObj) throws RPCServiceExeption ;
	
}
