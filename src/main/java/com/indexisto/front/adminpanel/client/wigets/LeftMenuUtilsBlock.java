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

public class LeftMenuUtilsBlock extends Composite {

	
	private FlowPanel menuContainer = new FlowPanel();
	
	
	private  MenuBlock menuBlockUtils = new MenuBlock();
	private MenuButt menuButtUtils = new MenuButt ("Dev utils");
	
	public LeftMenuUtilsBlock() {

		super();

		menuButtUtils.addStyleName("menuButtUtils");
	
		
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
		
		
		menuContainer.add(menuBlockUtils);
		initWidget(menuContainer);
	}





}
