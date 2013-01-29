package com.indexisto.front.adminpanel.shared;

import java.io.Serializable;

public class RPCServiceExeption extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;


	private String errorReadableText;
	private RPCSErrorCodes errorCode;


	public RPCServiceExeption() {};

	public RPCServiceExeption(String errorReadableText, RPCSErrorCodes errorCode) {

		this.setErrorCode(errorCode);
		this.setErrorReadableText(errorReadableText);
	}

	public String getErrorReadableText() {
		return errorReadableText;
	}

	public void setErrorReadableText(String errorReadableText) {
		this.errorReadableText = errorReadableText;
	}

	public RPCSErrorCodes getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(RPCSErrorCodes errorCode) {
		this.errorCode = errorCode;
	}


	


}	


