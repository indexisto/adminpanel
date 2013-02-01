package com.indexisto.front.adminpanel.client.events;


import com.google.gwt.event.shared.EventHandler;


public interface UserLoggedEventHandler extends EventHandler {
    void onUserLogged(UserLoggedEvent event);
}
