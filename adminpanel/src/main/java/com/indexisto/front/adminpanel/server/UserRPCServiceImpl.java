package com.indexisto.front.adminpanel.server;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.indexisto.front.adminpanel.client.rpcs.UserRPCService;
import com.indexisto.front.adminpanel.shared.RPCSErrorCodes;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;

public class UserRPCServiceImpl extends RemoteServiceServlet implements UserRPCService {

	public UserObj doRegister(String name, String email, String pass1) throws RPCServiceExeption {
		// TODO Auto-generated method stub
		if (true) {
			throw new RPCServiceExeption("Kosyaks", RPCSErrorCodes.USER_REGISTER_EMAIL_EXIST);
		}
		return null;
	}

}
