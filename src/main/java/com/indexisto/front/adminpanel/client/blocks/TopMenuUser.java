package com.indexisto.front.adminpanel.client.blocks;


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
import com.indexisto.front.adminpanel.client.pages.login.LoginPlace;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;

public class TopMenuUser extends Composite {

	private FlowPanel panel = new FlowPanel();
	private IconButt logOutButt = new IconButt();
	private Label userName = new Label();

	public TopMenuUser(UserObj user) {

		super();
		
		Log.debug("user.getName() " + user.getName());
		//System.out
		userName.setText(user.getName());
		
		userName.addStyleName("topMenuuUserName");
		userName.addStyleName("greyColorMenu");
		
		logOutButt.addStyleName("logOutButt");
		logOutButt.addIconStyle("logOutButtIcon");
		logOutButt.setHintText("Logout");
		
		panel.addStyleName("topMenuUser");
		
		
		panel.add(userName);
		panel.add(logOutButt);
		
		

		
		
		
		logOutButt.getFocusPanel().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				InstrumentsFactoryImpl.getUsercontroller().doLogout();
			}
			 
		});
		
		
		/*
		logOutButt.getFocusPanel().addMouseOverHandler(new MouseOverHandler() {

			public void onMouseOver(MouseOverEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});*/
		
		

		
		initWidget(panel);
	}





}
