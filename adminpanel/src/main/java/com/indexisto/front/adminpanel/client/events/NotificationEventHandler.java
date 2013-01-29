package com.indexisto.front.adminpanel.client.events;


import com.google.gwt.event.shared.EventHandler;


public interface NotificationEventHandler extends EventHandler {
    void onNotificationSend(NotificationEvent event);
}
