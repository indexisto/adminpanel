package com.indexisto.front.adminpanel.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.indexisto.front.adminpanel.client.common.AppActivityMapper;
import com.indexisto.front.adminpanel.client.common.AppPlaceHistoryMapper;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.pages.register.RegisterPlace;
import com.indexisto.front.adminpanel.client.wigets.LeftMenuHolder;
import com.indexisto.front.adminpanel.client.wigets.TopMenu;
import com.indexisto.front.adminpanel.client.windows.NotificationContainer;


public class adminpanel implements EntryPoint {

	private Place defaultPlace = new RegisterPlace("World!");
	private final FlowPanel mainContainer = new FlowPanel();
	private final SimplePanel MVPPanel = new SimplePanel();
	private final NotificationContainer notificationContainer = new NotificationContainer();
	
	//private final Button sendButton = new Button("Olona");
	private final TopMenu topMenu = new TopMenu();
	private final LeftMenuHolder leftMenuHolder = new LeftMenuHolder();
	

	public void onModuleLoad() {
		Log.debug("This is a 'DEBUG' test message");
 
		/*
	sendButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
    
      }
    });
	*/
	
	
    EventBus eventBus = InstrumentsFactoryImpl.getEventBus();
    PlaceController placeController = InstrumentsFactoryImpl.getPlaceController();

    // Start ActivityManager for the main widget with our ActivityMapper
    ActivityMapper activityMapper = new AppActivityMapper();
    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
    activityManager.setDisplay(MVPPanel);

    // Start PlaceHistoryHandler with our PlaceHistoryMapper
    AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, defaultPlace);

	
    mainContainer.addStyleName("mainContainer");
   
   // mainContainer.add(sendButton);
    mainContainer.add(leftMenuHolder);
    mainContainer.add(topMenu);
   
    
    mainContainer.add(MVPPanel);
    mainContainer.add(notificationContainer);
    
	RootPanel.get().add(mainContainer);

	 // Goes to the place represented on URL else default place
    historyHandler.handleCurrentHistory();

	
   }





}
