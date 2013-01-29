package com.indexisto.front.adminpanel.client.events;



import com.google.gwt.event.shared.GwtEvent;


public class NotificationEvent extends GwtEvent<NotificationEventHandler> {

    private final String notifText;

    public NotificationEvent(String notifText) {
        super();
        this.notifText = notifText;
    }

    public static final Type<NotificationEventHandler> TYPE = new Type<NotificationEventHandler>();

    @Override
    protected void dispatch(NotificationEventHandler handler) {
        handler.onNotificationSend(this);
    }

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<NotificationEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	public String getNotifText() {
		return notifText;
	}


	



}