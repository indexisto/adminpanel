package com.indexisto.front.adminpanel.server.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indexisto.front.adminpanel.shared.RPCSErrorCodes;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public class UserExecImpl implements UserExec {


	public UserObj getUserFromCookie(HttpServletRequest request) throws RPCServiceExeption {
		
		CookieExec cookieService = new CookieExecImpl();
		cookieService.checkCookiesValid(request);
		
		UserObj userObj = new UserObj(); 
		userObj.setEmail("mail");
		userObj.setName("name");
		userObj.setUid("uid");
		userObj.setDemoRegistered(true);
		userObj.setUserRole(UserObj.UserRoles.REGISTERED);
		
		return userObj;
	}

	public UserObj createUser(UserObjRegisterForm userObjRegisterForm) throws RPCServiceExeption {
		
		UserObj userObj = new UserObj(); 
		userObj.setEmail(userObjRegisterForm.getEmail());
		userObj.setName(userObjRegisterForm.getName());
		userObj.setUid("vasuid");
		userObj.setDemoRegistered(false);
		userObj.setUserRole(UserObj.UserRoles.REGISTERED);

		return userObj;
	}

	public UserObj createUserAndSetCookie(UserObjRegisterForm userObjRegisterForm, HttpServletResponse response)
			throws RPCServiceExeption {
		
		UserObj userObj = createUser(userObjRegisterForm);
		CookieExec cookieService = new CookieExecImpl();
		cookieService.setCookies(response, userObj);
		
		return userObj;
	}

	public UserObj loginUserAndSetCookie(UserObjRegisterForm userObjRegisterForm)
			throws RPCServiceExeption {
		// TODO Auto-generated method stub
		if (true) {
			throw new RPCServiceExeption ("Wrong password", RPCSErrorCodes.WRONG_PASSWORD);
		}
		return null;
	}
	
	

}
