package com.indexisto.front.adminpanel.client.pages.home;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.indexisto.front.adminpanel.client.common.ActivityExtended;
import com.indexisto.front.adminpanel.client.common.ViewsFactoryImpl;

public class HomeActivity extends ActivityExtended  implements HomeView.Presenter{

	

	private HomePlace place;
	
	 public HomeActivity(HomePlace place) {
	        //this.clientFactory = clientFactory;
		
		 this.place = place;
	    }

	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		Log.debug("LoginActivity started");
		HomeView registerView = ViewsFactoryImpl.getHomeView();
		//registerView.setName(place.g);
		registerView.setPresenter(this);
		panel.setWidget(registerView.asWidget());



	}

	public void emailChanged(String email) {
		// TODO Auto-generated method stub
		
	}

}
