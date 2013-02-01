package com.indexisto.front.adminpanel.client.rpcs;

import java.util.ArrayList;



import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;
 

@RemoteServiceRelativePath("UserRPCService")
public interface UserRPCService extends RemoteService {
  
	public UserObj doLogin(UserObjRegisterForm userObjRegisterForm) throws RPCServiceExeption;
	public UserObj doRegister(UserObjRegisterForm userObjRegisterForm) throws RPCServiceExeption;
	public UserObj getUserFromCookie() throws RPCServiceExeption;

}
