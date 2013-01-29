package com.indexisto.front.adminpanel.client.rpcs;

import java.util.ArrayList;



import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;
 

@RemoteServiceRelativePath("UserRPCService")
public interface UserRPCService extends RemoteService {
 
	
	public UserObj doRegister(String name, String email,String pass1) throws RPCServiceExeption;

}
