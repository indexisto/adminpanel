package com.indexisto.front.adminpanel.client.common;

import com.indexisto.front.adminpanel.client.pages.demolog.DemologView;
import com.indexisto.front.adminpanel.client.pages.demolog.DemologViewImpl;
import com.indexisto.front.adminpanel.client.pages.login.LoginView;
import com.indexisto.front.adminpanel.client.pages.login.LoginViewImpl;
import com.indexisto.front.adminpanel.client.pages.register.RegisterView;
import com.indexisto.front.adminpanel.client.pages.register.RegisterViewImpl;

public class ViewsFactoryImpl {
	//private final RegisterView registerView = new RegisterViewImpl();

	public static RegisterView getRegisterView() {
		// TODO Auto-generated method stub
		return new RegisterViewImpl();
	}
	
	
	public static LoginView getLoginView() {
		// TODO Auto-generated method stub
		return new LoginViewImpl();
	}
	
	public static DemologView getDemologView() {
		// TODO Auto-generated method stub
		return new DemologViewImpl();
	}
	

}
