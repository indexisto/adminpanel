package com.indexisto.front.adminpanel.client.pages.demolog;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.indexisto.front.adminpanel.client.common.ActivityExtended;
import com.indexisto.front.adminpanel.client.common.ViewsFactoryImpl;

public class DemologActivity extends ActivityExtended  implements DemologView.Presenter{

	

	private DemologPlace place;
	
	 public DemologActivity(DemologPlace place) {
	        //this.clientFactory = clientFactory;
		
		 this.place = place;
	    }

	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		
		DemologView registerView = ViewsFactoryImpl.getDemologView();
		//registerView.setName(place.g);
		registerView.setPresenter(this);
		panel.setWidget(registerView.asWidget());



	}

	public void emailChanged(String email) {
		// TODO Auto-generated method stub
		
	}

}
