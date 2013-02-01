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

public class LeftMenuHome extends Composite {

	
	private FlowPanel menuContainer = new FlowPanel();
	private LeftMenuUtilsBlock leftMenuUtilsBlock = new LeftMenuUtilsBlock();
	
	private  MenuBlock menuBlockIndexes = new MenuBlock(); 
	private  MenuBlock menuBlockAccount = new MenuBlock(); 

	//private Label showSomeStat;

	private MenuButt menuButtIndexes = new MenuButt ("Your indexes");
	private MenuButt menuButtAccount = new MenuButt ("Your account");

	
	public LeftMenuHome() {

		super();

		

		
		
		menuContainer.addStyleName("menuContainer");
		
		menuButtIndexes.addStyleName("menuButtUtils");
		menuButtAccount.addStyleName("menuButtUtils");
		
		
		
		
		menuButtIndexes.getFocusPanel().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				
				InstrumentsFactoryImpl.getEventBus().fireEvent(new NotificationEvent("Your indexes"));
				// TODO Auto-generated method stub
				//InstrumentsFactoryImpl.getPlaceController().goTo(new RegisterPlace("def"));
			}
			 
		});
		
		menuButtAccount.getFocusPanel().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				InstrumentsFactoryImpl.getEventBus().fireEvent(new NotificationEvent("Your account"));
				//InstrumentsFactoryImpl.getPlaceController().goTo(new LoginPlace("def"));
			}
			 
		});
		
		
		
		menuBlockIndexes.addMenuItem(menuButtIndexes);
		menuBlockIndexes.addSubMenuItem(new MenuSubButt("sub menu item 1"));
		menuBlockIndexes.addSubMenuItem(new MenuSubButt("sub menu item 2"));
		menuBlockIndexes.addSubMenuItem(new MenuSubButt("sub menu item 3"));
		
		menuBlockAccount.addMenuItem(menuButtAccount);
		menuBlockAccount.addSubMenuItem(new MenuSubButt("sub menu item 1"));
		menuBlockAccount.addSubMenuItem(new MenuSubButt("sub menu item 2"));
		menuBlockAccount.addSubMenuItem(new MenuSubButt("sub menu item 3"));
		
		
		menuContainer.add(menuBlockIndexes);
		menuContainer.add(menuBlockAccount);
		menuContainer.add(leftMenuUtilsBlock);

		initWidget(menuContainer);
	}





}
