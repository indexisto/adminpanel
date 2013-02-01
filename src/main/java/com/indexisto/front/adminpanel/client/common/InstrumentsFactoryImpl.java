package com.indexisto.front.adminpanel.client.common;


import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.indexisto.front.adminpanel.client.security.UserController;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;

public class InstrumentsFactoryImpl {

	private final static SimpleEventBus eventBus = new SimpleEventBus();
	private final static PlaceController placeController = new PlaceController(eventBus);
	private final static UserController userController  = new UserController();
	private static UserObj userObj;
	
	private static ValidatorFactory validationFactory = Validation.byDefaultProvider().configure().buildValidatorFactory();
	private static Validator validator = validationFactory.getValidator();
	
	 
	public static SimpleEventBus getEventBus() {
		// TODO Auto-generated method stub
		return eventBus;
	}

	public static PlaceController getPlaceController() {
		// TODO Auto-generated method stub
		return placeController;
	}

	public static UserController getUsercontroller() {
		return userController;
	}

	public static UserObj getUserObj() {
		return userObj;
	}
 
	public static void setUserObj(UserObj userObj) {
		InstrumentsFactoryImpl.userObj = userObj;
	}

	public static Validator getValidator() {
		return validator;
	}


}
