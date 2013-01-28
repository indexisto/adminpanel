package com.indexisto.front.adminpanel.client.pages.register;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.indexisto.front.adminpanel.client.common.ActivityExtended;
import com.indexisto.front.adminpanel.client.common.ViewsFactoryImpl;

public class RegisterActivity extends ActivityExtended  implements RegisterView.Presenter{

	

	private RegisterPlace place;
	
	 public RegisterActivity(RegisterPlace place) {
	        //this.clientFactory = clientFactory;
		
		 this.place = place;
	    }

	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		
		RegisterView registerView = ViewsFactoryImpl.getRegisterView();
		//registerView.setName(place.g);
		registerView.setPresenter(this);
		panel.setWidget(registerView.asWidget());



	}

	public void emailChanged(String email) {
		// TODO Auto-generated method stub
		
	}

}
