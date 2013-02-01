package com.indexisto.front.adminpanel.shared;

import com.google.gwt.user.client.Cookies;

public enum CookiesConstants {
	SESSION {
		public String getCookieName() {return "indexisto9session";}
	},
	EMAIL {
		public String getCookieName() {return "indexisto9email";}
	},
	UID {
		public String getCookieName() {return "indexisto9uid";}
	};
	
	public abstract String getCookieName();
	
	
}
