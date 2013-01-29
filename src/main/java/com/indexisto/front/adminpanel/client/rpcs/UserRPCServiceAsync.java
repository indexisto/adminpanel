package com.indexisto.front.adminpanel.client.rpcs;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;

public interface UserRPCServiceAsync { 

	void doRegister(String name, String email, String pass1, AsyncCallback<UserObj> callback);


}
