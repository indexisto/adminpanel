package com.indexisto.front.adminpanel.client.security;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Cookies;

public class InitRouter {
	private String cookieSession;
	private String cookieEmail;
	private String cookieRole;
	private String cookieUid;
	private String cookieIsTestmode;
	
	public InitRouter() {
		
		
		cookieSession = Cookies.getCookie("indexisto9session");
		cookieEmail = Cookies.getCookie("indexisto9email");
		cookieRole = Cookies.getCookie("indexisto9role");
		cookieUid = Cookies.getCookie("indexisto9uid");
		cookieIsTestmode = Cookies.getCookie("indexisto9testmode");
		Log.debug("cookieSession = " + cookieSession);
		Log.debug("cookieEmail = " + cookieSession);
		Log.debug("cookieRole = " + cookieSession);
		Log.debug("cookieUid = " + cookieUid);
		Log.debug("cookieIsTestmode = " + cookieIsTestmode);
		
		
		if (cookieSession!=null && cookieEmail!=null && cookieRole!=null && cookieUid!=null) {
			Log.debug("User logged");  
		}
		else {
			Log.debug("User not logged");  
		}
	}
}
