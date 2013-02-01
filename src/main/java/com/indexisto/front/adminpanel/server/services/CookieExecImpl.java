package com.indexisto.front.adminpanel.server.services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen_sauer.gwt.log.client.Log;
import com.indexisto.front.adminpanel.shared.CookiesConstants;
import com.indexisto.front.adminpanel.shared.RPCSErrorCodes;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;



public class CookieExecImpl implements CookieExec {

	public void checkCookiesValid(HttpServletRequest request) throws RPCServiceExeption {

		String session = null;
		String email = null;
		String uid = null;
		Cookie[] cookies=request.getCookies();


		if (cookies !=null) {
			for (int i=0; i<cookies.length; i++) {
				//if (true) throw new RPCServiceExeption("Error: Test exeption!", RPCSErrorCodes.NO_COOKIES);
				Log.info("cookies.length= " + cookies.length + " cookies[i].getName() " + cookies[i].getName());
				if (cookies[i].getName().equals(CookiesConstants.SESSION.getCookieName())) {
					session = cookies[i].getValue();
					Log.info("indexisto9session cookie Found " + session);
				}
				else if (cookies[i].getName().equals(CookiesConstants.EMAIL.getCookieName())) {
					email = cookies[i].getValue();
					Log.info("indexisto9email cookie Found " + email);
				}
				else if (cookies[i].getName().equals(CookiesConstants.UID.getCookieName())) {
					uid = cookies[i].getValue();
					Log.info("indexisto9uid cookie Found " + uid);
				}
			}

			if (session==null) {
				throw new RPCServiceExeption("Error: no session cookie!", RPCSErrorCodes.NO_SESSION_COOKIE);
			} 
			else if (email==null) {
				throw new RPCServiceExeption("Error: no email cookie!", RPCSErrorCodes.NO_EMAIL_COOKIE);
			}
			else if (uid==null) {
				throw new RPCServiceExeption("Error: no uid cookie!", RPCSErrorCodes.NO_UID_COOKIE);
			}
		}
		else {
			Log.info("Error: No any cookies!");
			throw new RPCServiceExeption("Error: No any cookies!", RPCSErrorCodes.NO_COOKIES);
		}

	}

	public void setCookies(HttpServletResponse response, UserObj userObj) throws RPCServiceExeption {

		//TODO - VALIDATE INPUT!!!
		
		//String md5session = CommonsServer.MD5(MongoPool.getSecretKey() + cookieObj.getEmail());
		String md5session = "123SECRETSESSION" + userObj.getName();
		
		
		Cookie cookieEmail=new Cookie(CookiesConstants.EMAIL.getCookieName(),userObj.getEmail());
		Cookie cookieUid=new Cookie(CookiesConstants.UID.getCookieName(),userObj.getUid());
		Cookie cookieSess=new Cookie(CookiesConstants.SESSION.getCookieName(),md5session);
		
		cookieEmail.setVersion(1);
		cookieEmail.setPath("/");
		cookieEmail.setMaxAge(999999999);
		
		cookieUid.setVersion(1);
		cookieUid.setPath("/");
		cookieUid.setMaxAge(999999999);
		
		cookieSess.setVersion(1);
		cookieSess.setPath("/");
		cookieSess.setMaxAge(999999999);
		
		response.addCookie(cookieEmail);
		response.addCookie(cookieUid);
		response.addCookie(cookieSess);
		
	}


}
