package com.indexisto.front.adminpanel.server.services;

import com.indexisto.front.adminpanel.shared.RPCServiceExeption;

public interface SecurityController {
	public void  AllowRoles(int[]allowedRoles) throws RPCServiceExeption;
}
