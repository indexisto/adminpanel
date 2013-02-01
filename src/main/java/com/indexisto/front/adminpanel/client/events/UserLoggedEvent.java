package com.indexisto.front.adminpanel.client.events;



import com.google.gwt.event.shared.GwtEvent;
import com.indexisto.front.adminpanel.client.wigets.LeftMenuTypes;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;


public class UserLoggedEvent extends GwtEvent<UserLoggedEventHandler> {

    private final UserObj userObj;

    public UserLoggedEvent(UserObj userObj) {
        super();
        this.userObj = userObj; 
    }

    public static final Type<UserLoggedEventHandler> TYPE = new Type<UserLoggedEventHandler>();

    @Override
    protected void dispatch(UserLoggedEventHandler handler) {
        handler.onUserLogged(this);
    }

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<UserLoggedEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	public UserObj getUserObj() {
		return userObj;
	}



	


}