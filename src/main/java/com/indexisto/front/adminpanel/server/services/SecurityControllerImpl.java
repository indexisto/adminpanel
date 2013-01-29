package com.indexisto.front.adminpanel.server.services;

import com.indexisto.front.adminpanel.shared.RPCSErrorCodes;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;

public class SecurityControllerImpl implements SecurityController {

	public void AllowRoles(int[] allowedRoles) throws RPCServiceExeption {
		// TODO Auto-generated method stub
		if (true) {
			throw new RPCServiceExeption("Kosyak", RPCSErrorCodes.USER_REGISTER_EMAIL_EXIST);
		}
	}

}
