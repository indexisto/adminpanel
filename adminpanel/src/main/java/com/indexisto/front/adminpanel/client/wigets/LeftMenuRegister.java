package com.indexisto.front.adminpanel.client.wigets;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.indexisto.front.adminpanel.client.blocks.MenuBlock;
import com.indexisto.front.adminpanel.client.butts.MenuButt;
import com.indexisto.front.adminpanel.client.butts.MenuSubButt;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.events.LeftMenuSelectedEvent;
import com.indexisto.front.adminpanel.client.pages.demolog.DemologPlace;
import com.indexisto.front.adminpanel.client.pages.login.LoginPlace;
import com.indexisto.front.adminpanel.client.pages.register.RegisterPlace;

public class LeftMenuRegister extends Composite {

	
	private FlowPanel menuContainer = new FlowPanel();
	
	
	private  MenuBlock menuBlockReg = new MenuBlock(); 
	private  MenuBlock menuBlockLog = new MenuBlock(); 
	private  MenuBlock menuBlockDemo = new MenuBlock();
	//private Label showSomeStat;

	private MenuButt menuButtReg = new MenuButt ("Register");
	private MenuButt menuButtLog = new MenuButt ("Login");
	private MenuButt menuButtDemo = new MenuButt ("Demo");
	
	public LeftMenuRegister() {

		super();

		

		
		
		menuContainer.addStyleName("menuContainer");
		
		menuButtReg.addStyleName("menuButtReg");
		menuButtLog.addStyleName("menuButtLog");
		menuButtDemo.addStyleName("menuButtDemo");
		
		
		
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
		initWidget(menuContainer);
	}





}
