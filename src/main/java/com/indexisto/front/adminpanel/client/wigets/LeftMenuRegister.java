package com.indexisto.front.adminpanel.client.wigets;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.indexisto.front.adminpanel.client.blocks.MenuBlock;
import com.indexisto.front.adminpanel.client.butts.MenuButt;
import com.indexisto.front.adminpanel.client.butts.MenuSubButt;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.events.LeftMenuSelectedEvent;
import com.indexisto.front.adminpanel.client.events.NotificationEvent;
import com.indexisto.front.adminpanel.client.pages.demolog.DemologPlace;
import com.indexisto.front.adminpanel.client.pages.login.LoginPlace;
import com.indexisto.front.adminpanel.client.pages.register.RegisterPlace;
import com.indexisto.front.adminpanel.client.windows.CommonModalWindow;

public class LeftMenuRegister extends Composite {

	
	private FlowPanel menuContainer = new FlowPanel();
	
	
	private  MenuBlock menuBlockReg = new MenuBlock(); 
	private  MenuBlock menuBlockLog = new MenuBlock(); 
	private  MenuBlock menuBlockDemo = new MenuBlock();
	private  MenuBlock menuBlockUtils = new MenuBlock();
	//private Label showSomeStat;

	private MenuButt menuButtReg = new MenuButt ("Register");
	private MenuButt menuButtLog = new MenuButt ("Login");
	private MenuButt menuButtDemo = new MenuButt ("Demo");
	private MenuButt menuButtUtils = new MenuButt ("Dev utils");
	
	public LeftMenuRegister() {

		super();

		

		
		
		menuContainer.addStyleName("menuContainer");
		
		menuButtReg.addStyleName("menuButtReg");
		menuButtLog.addStyleName("menuButtLog");
		menuButtDemo.addStyleName("menuButtDemo");
		menuButtUtils.addStyleName("menuButtUtils");
		
		
		
		
		menuButtReg.getFocusPanel().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				InstrumentsFactoryImpl.getPlaceController().goTo(new RegisterPlace("def"));
			}
			 
		});
		
		menuButtLog.getFocusPanel().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				InstrumentsFactoryImpl.getPlaceController().goTo(new LoginPlace("def"));
			}
			 
		});
		
		
		menuButtDemo.getFocusPanel().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				InstrumentsFactoryImpl.getPlaceController().goTo(new DemologPlace("def"));
			}
			 
		});
		
		
		menuBlockReg.addMenuItem(menuButtReg);
		menuBlockReg.addSubMenuItem(new MenuSubButt("sub menu item 1"));
		menuBlockReg.addSubMenuItem(new MenuSubButt("sub menu item 2"));
		menuBlockReg.addSubMenuItem(new MenuSubButt("sub menu item 3"));
		
		menuBlockLog.addMenuItem(menuButtLog);
		menuBlockLog.addSubMenuItem(new MenuSubButt("sub menu item 1"));
		menuBlockLog.addSubMenuItem(new MenuSubButt("sub menu item 2"));
		menuBlockLog.addSubMenuItem(new MenuSubButt("sub menu item 3"));
		
		menuBlockDemo.addMenuItem(menuButtDemo);
		menuBlockDemo.addSubMenuItem(new MenuSubButt("sub menu item 1"));
		menuBlockDemo.addSubMenuItem(new MenuSubButt("sub menu item 2"));
		menuBlockDemo.addSubMenuItem(new MenuSubButt("sub menu item 3"));
		
		
		menuBlockUtils.addMenuItem(menuButtUtils);
		MenuSubButt subNotif = new MenuSubButt("Test notification");
		MenuSubButt subModal = new MenuSubButt("Test modal");
		menuBlockUtils.addSubMenuItem(subNotif);
		menuBlockUtils.addSubMenuItem(subModal);
		
		
		subNotif.getFocusPanel().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				InstrumentsFactoryImpl.getEventBus().fireEvent(new NotificationEvent("Privetiki Privetiki Privetiki " + Random.nextInt()) );
			}
			 
		});
		
		subModal.getFocusPanel().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				CommonModalWindow registerWaitingWindow = new CommonModalWindow("Registering. Please wait.", true);
				registerWaitingWindow.show();
			}
			 
		});
		
		
		
		/*
		showSomeStat = new Label("LeftMenu");
		//+ statObj.getLastAlbums() + " LastImgs " + statObj.getLastImgs());
		showSomeStat.addStyleName("text11_White");
		panel.add(showSomeStat);
		
		for (int i=0; i<140; i++) {
        	Label l = new Label("LeftMenu" + i);
        	panel.add(l);
        }*/
		menuContainer.add(menuBlockReg);
		menuContainer.add(menuBlockLog);
		menuContainer.add(menuBlockDemo);
		menuContainer.add(menuBlockUtils);
		initWidget(menuContainer);
	}





}
