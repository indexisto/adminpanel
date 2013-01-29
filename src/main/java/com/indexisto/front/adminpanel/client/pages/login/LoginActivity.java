package com.indexisto.front.adminpanel.client.pages.login;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.indexisto.front.adminpanel.client.common.ActivityExtended;
import com.indexisto.front.adminpanel.client.common.ViewsFactoryImpl;

public class LoginActivity extends ActivityExtended  implements LoginView.Presenter{

	

	private LoginPlace place;
	
	 public LoginActivity(LoginPlace place) {
	        //this.clientFactory = clientFactory;
		
		 this.place = place;
	    }

	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		
		LoginView registerView = ViewsFactoryImpl.getLoginView();
		//registerView.setName(place.g);
		registerView.setPresenter(this);
		panel.setWidget(registerView.asWidget());



	}

	public void emailChanged(String email) {
		// TODO Auto-generated method stub
		
	}

}
