package com.indexisto.front.adminpanel.client.common;


import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class InstrumentsFactoryImpl {

	private final static SimpleEventBus eventBus = new SimpleEventBus();
	private final static PlaceController placeController = new PlaceController(eventBus);

	 
	public static SimpleEventBus getEventBus() {
		// TODO Auto-generated method stub
		return eventBus;
	}

	public static PlaceController getPlaceController() {
		// TODO Auto-generated method stub
		return placeController;
	}

}
