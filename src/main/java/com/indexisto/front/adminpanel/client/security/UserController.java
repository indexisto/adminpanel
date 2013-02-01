package com.indexisto.front.adminpanel.client.security;


import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.events.NotificationEvent;
import com.indexisto.front.adminpanel.client.events.ShowMenuEvent;
import com.indexisto.front.adminpanel.client.events.UserLoggedEvent;
import com.indexisto.front.adminpanel.client.pages.demolog.DemologPlace;
import com.indexisto.front.adminpanel.client.pages.home.HomePlace;
import com.indexisto.front.adminpanel.client.pages.login.LoginPlace;
import com.indexisto.front.adminpanel.client.pages.register.RegisterPlace;
import com.indexisto.front.adminpanel.client.rpcs.UserRPCService;
import com.indexisto.front.adminpanel.client.rpcs.UserRPCServiceAsync;
import com.indexisto.front.adminpanel.client.wigets.LeftMenuTypes;
import com.indexisto.front.adminpanel.shared.CookiesConstants;
import com.indexisto.front.adminpanel.shared.RPCSErrorCodes;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;

public class UserController {
	private String cookieSession;
	private String cookieEmail;
	private String cookieRole;
	private String cookieUid;
	private String cookieIsTestmode;

	public UserController() {



		//Cookies.setCookie(CookiesConstants.SESSION.getCookieName(), "allonatest");

		cookieSession = Cookies.getCookie(CookiesConstants.SESSION.getCookieName());
		cookieEmail = Cookies.getCookie(CookiesConstants.EMAIL.getCookieName());
		cookieUid = Cookies.getCookie(CookiesConstants.UID.getCookieName());

		Log.debug("cookieSession = " + cookieSession);
		Log.debug("cookieEmail = " + cookieSession);
		Log.debug("cookieUid = " + cookieUid);
	}


	public void routeUser() {
		if (cookieSession!=null) {

			getUserFromCookie();

		}
		else {
			InstrumentsFactoryImpl.getEventBus().fireEvent(new ShowMenuEvent(LeftMenuTypes.UNLOGGED));
			InstrumentsFactoryImpl.getPlaceController().goTo(new RegisterPlace("def"));
		}

	}



	private UserObj getUserFromCookie() {

		UserRPCServiceAsync communicatorSvc = GWT.create(UserRPCService.class);

		AsyncCallback <UserObj> callback = new AsyncCallback<UserObj>() {

			public void onFailure(Throwable caught) {
				if (caught instanceof RPCServiceExeption) {
					RPCServiceExeption caughtRPCExeption = (RPCServiceExeption) caught;
					String exeptionText = "Error code: " + caughtRPCExeption.getErrorReadableText() + " - " + caughtRPCExeption.getErrorCode();
					Log.debug("getUserFromCookie exeption!" + exeptionText);
					InstrumentsFactoryImpl.getEventBus().fireEvent(new NotificationEvent(exeptionText) );
				}

			}

			public void onSuccess(UserObj user) {
				Log.debug("getUserFromCookie onSuccess " + user.getName() + " " + user.getEmail() + " " + user.getUserRole()+ " " + user.getUid()+ " ");
				UserController.this.setCurrentUser(user);
			}


		};

		Log.debug("Make the call for the user by cookie");
		communicatorSvc.getUserFromCookie(callback);



		return null;

	}


	public void setCurrentUser(UserObj user) {
				
		InstrumentsFactoryImpl.getEventBus().fireEvent(new UserLoggedEvent(user));
		InstrumentsFactoryImpl.getEventBus().fireEvent(new ShowMenuEvent(LeftMenuTypes.LOGGED_INDEXES));
		InstrumentsFactoryImpl.setUserObj(user);
		InstrumentsFactoryImpl.getPlaceController().goTo(new HomePlace("def"));
	}
	
	public void doLogout() {
		Cookies.removeCookie(CookiesConstants.SESSION.getCookieName(), "/");
		Cookies.removeCookie(CookiesConstants.EMAIL.getCookieName(), "/");
		Cookies.removeCookie(CookiesConstants.UID.getCookieName(), "/");
		
		InstrumentsFactoryImpl.getEventBus().fireEvent(new UserLoggedEvent(null));
		InstrumentsFactoryImpl.getEventBus().fireEvent(new ShowMenuEvent(LeftMenuTypes.UNLOGGED));
		InstrumentsFactoryImpl.getPlaceController().goTo(new LoginPlace("def"));
		Log.debug("doLogout");
	}
}
