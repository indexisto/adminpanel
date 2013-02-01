package com.indexisto.front.adminpanel.server;

import org.apache.commons.lang3.StringEscapeUtils;

import com.allen_sauer.gwt.log.client.Log;

public class ServerInputValidator {
	
	public static boolean containXSS(String text) {
		String cleanText;
		cleanText = StringEscapeUtils.escapeHtml3(text);
		//StringEscapeUtils.escapeH
		Log.debug("cleanText " + cleanText);	 
		Log.debug("text " + text);	

		boolean isBad = true;
		if (text.equals(cleanText)) {
			isBad = false;
		}
		//StringEscapeUtils.
		return isBad;
	}
	
}
