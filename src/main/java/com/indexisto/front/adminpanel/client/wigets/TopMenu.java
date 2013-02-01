package com.indexisto.front.adminpanel.client.wigets;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.indexisto.front.adminpanel.client.blocks.Logo;
import com.indexisto.front.adminpanel.client.blocks.TopMenuUser;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.events.UserLoggedEvent;
import com.indexisto.front.adminpanel.client.events.UserLoggedEventHandler;

public class TopMenu extends Composite implements UserLoggedEventHandler {

	
	private FlowPanel panel = new FlowPanel();
	private Label showSomeStat;
	private Logo logo = new Logo();
	private TopMenuUser topMenuUser = null;

	public TopMenu() {

		super();
		InstrumentsFactoryImpl.getEventBus().addHandler(UserLoggedEvent.TYPE, this);
		
		panel.addStyleName("topMenu");
		panel.addStyleName("topMenuBack");
		
		showSomeStat = new Label("TopMenu");
		
		
		panel.add(logo); 
		//+ statObj.getLastAlbums() + " LastImgs " + statObj.getLastImgs());
		//showSomeStat.addStyleName("text11_White");
		
		//panel.add(showSomeStat);
		initWidget(panel);
	}

	public void onUserLogged(UserLoggedEvent event) {
		// TODO Auto-generated method stub
		if (event.getUserObj()!=null) {
			topMenuUser = new TopMenuUser(event.getUserObj());
			panel.add(topMenuUser);
		}
		else {
			if (topMenuUser!=null) {
				topMenuUser.removeFromParent();
				topMenuUser = null;
			}
		}
	}





}
