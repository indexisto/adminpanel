package com.indexisto.front.adminpanel.client.rpcs;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public interface UserRPCServiceAsync { 

	void getUserFromCookie(AsyncCallback<UserObj> callback);

	void doLogin(UserObjRegisterForm userObjRegisterForm,
			AsyncCallback<UserObj> callback);

	void doRegister(UserObjRegisterForm userObjRegisterForm,
			AsyncCallback<UserObj> callback);

 
}
