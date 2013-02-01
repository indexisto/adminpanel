package com.indexisto.front.adminpanel.client.events;



import com.google.gwt.event.shared.GwtEvent;
import com.indexisto.front.adminpanel.client.wigets.LeftMenuTypes;


public class ShowMenuEvent extends GwtEvent<ShowMenuEventHandler> {

    private final LeftMenuTypes leftMenuTypes;

    public ShowMenuEvent(LeftMenuTypes leftMenuTypes) {
        super();
        this.leftMenuTypes = leftMenuTypes;
    }

    public static final Type<ShowMenuEventHandler> TYPE = new Type<ShowMenuEventHandler>();

    @Override
    protected void dispatch(ShowMenuEventHandler handler) {
        handler.setMenu(this);
    }

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ShowMenuEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	public LeftMenuTypes getLeftMenuTypes() {
		return leftMenuTypes;
	}


	


}