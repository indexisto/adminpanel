package com.indexisto.front.adminpanel.client.events;



import com.google.gwt.event.shared.GwtEvent;
import com.indexisto.front.adminpanel.client.blocks.MenuBlock;


public class LeftMenuSelectedEvent extends GwtEvent<LeftMenuSelectedEventHandler> {

    private final MenuBlock menuBlock;

    public LeftMenuSelectedEvent(MenuBlock menuBlock) {
        super();
        this.menuBlock = menuBlock;
    }

    public static final Type<LeftMenuSelectedEventHandler> TYPE = new Type<LeftMenuSelectedEventHandler>();

    @Override
    protected void dispatch(LeftMenuSelectedEventHandler handler) {
        handler.onLeftMenuSelected(this);
    }

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<LeftMenuSelectedEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}


	

	public MenuBlock getMenuBlock() {
		return menuBlock;
	}


}