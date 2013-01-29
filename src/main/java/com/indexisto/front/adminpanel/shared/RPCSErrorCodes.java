package com.indexisto.front.adminpanel.shared;

import java.io.Serializable;

public enum RPCSErrorCodes implements Serializable {
	USER_REGISTER_EMAIL_EXIST,
	USER_REGISTER_VERIFICATION_FAIL,
	USER_REGISTER_NAME_VERIFICATION_FAIL,
	USER_REGISTER_PASS_VERIFICATION_FAIL
}
