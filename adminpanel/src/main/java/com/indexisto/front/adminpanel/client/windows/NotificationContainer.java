package com.indexisto.front.adminpanel.client.windows;


import java.awt.event.MouseEvent;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.indexisto.front.adminpanel.client.butts.IconButt;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.events.NotificationEvent;
import com.indexisto.front.adminpanel.client.events.NotificationEventHandler;

public class NotificationContainer extends Composite implements NotificationEventHandler {

	private FlowPanel panel = new FlowPanel();


	public NotificationContainer() {

	
		panel.addStyleName("notificationContainer");
		
		InstrumentsFactoryImpl.getEventBus().addHandler(NotificationEvent.TYPE, this);
		
		
		
		initWidget(panel);
	}


	public void onNotificationSend(NotificationEvent event) {
		// TODO Auto-generated method stub
		Log.debug("Notification getted");
		Notification notification =  new Notification("allo allo allo allo allo allo allo");
		panel.add(notification);
		//panel.add(new Label("olllo"));
	}





}
