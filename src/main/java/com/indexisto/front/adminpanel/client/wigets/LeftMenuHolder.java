package com.indexisto.front.adminpanel.client.wigets;


import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.indexisto.front.adminpanel.client.butts.MenuButt;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.events.ShowMenuEvent;
import com.indexisto.front.adminpanel.client.events.ShowMenuEventHandler;

public class LeftMenuHolder extends Composite implements ShowMenuEventHandler{

	
	private FlowPanel panel = new FlowPanel();
	//private LeftMenuRegister leftMenuRegister;
	
	public LeftMenuHolder() {

		super();
		panel.addStyleName("leftMenu");
		panel.addStyleName("leftMenuBack");
		
	
		InstrumentsFactoryImpl.getEventBus().addHandler(ShowMenuEvent.TYPE, this);
		
		
		initWidget(panel);
		
		
		
	}

	public void setMenu(ShowMenuEvent event) {
		// TODO Auto-generated method stub
		if (event.getLeftMenuTypes() == LeftMenuTypes.UNLOGGED) {
			panel.clear();
			LeftMenuRegister leftMenuRegister = new LeftMenuRegister();
			Log.debug("Show Register menu");
			panel.add(leftMenuRegister);
		}
		
		else if (event.getLeftMenuTypes() == LeftMenuTypes.LOGGED_INDEXES) {
			panel.clear();
			LeftMenuHome leftMenuHome = new LeftMenuHome();
			
			Log.debug("Show Logged menu");
			panel.add(leftMenuHome);
		}
	}





}
