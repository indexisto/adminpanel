package com.indexisto.front.adminpanel.server;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.indexisto.front.adminpanel.client.rpcs.UserRPCService;
import com.indexisto.front.adminpanel.server.services.UserExec;
import com.indexisto.front.adminpanel.server.services.UserExecImpl;
import com.indexisto.front.adminpanel.shared.RPCSErrorCodes;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public class UserRPCServiceImpl extends RemoteServiceServlet implements UserRPCService {

	

	
	
	
	
	public UserObj getUserFromCookie() throws RPCServiceExeption {
		
		UserExec userExec = new UserExecImpl();
		UserObj userObj = userExec.getUserFromCookie(this.getThreadLocalRequest());
		
		return userObj;
	}
	
	
	

	public UserObj doRegister(UserObjRegisterForm userObjRegisterForm) throws RPCServiceExeption {
		UserExec userExec = new UserExecImpl();
		
		// RemoteServiceUtil.
		UserObj userObj = userExec.createUserAndSetCookie(userObjRegisterForm, this.getThreadLocalResponse());
		return userObj;
	}




	public UserObj doLogin(UserObjRegisterForm userObjRegisterForm)
			throws RPCServiceExeption {
		UserExec userExec = new UserExecImpl();
		UserObj userObj = userExec.loginUserAndSetCookie(userObjRegisterForm);
		return userObj;
	}

}
