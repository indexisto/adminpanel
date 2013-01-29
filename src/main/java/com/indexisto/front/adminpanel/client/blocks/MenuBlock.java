package com.indexisto.front.adminpanel.client.blocks;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.indexisto.front.adminpanel.client.butts.MenuButt;
import com.indexisto.front.adminpanel.client.butts.MenuSubButt;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.events.LeftMenuSelectedEvent;
import com.indexisto.front.adminpanel.client.events.LeftMenuSelectedEventHandler;

public class MenuBlock extends Composite implements LeftMenuSelectedEventHandler {

	
	private FlowPanel panel = new FlowPanel();
	private FlowPanel menuItem = new FlowPanel();
	private FlowPanel subMenus = new FlowPanel();
	
	//private Label showSomeStat;
	
	public MenuBlock() {

		InstrumentsFactoryImpl.getEventBus().addHandler(LeftMenuSelectedEvent.TYPE, this);
		panel.add(menuItem);
		panel.add(subMenus);
		setUnselectedAndMinimized();
		initWidget(panel);
	}
	
	
	public void addMenuItem(final MenuButt menuButt) {
		menuItem.add(menuButt);
		menuButt.getFocusPanel().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				InstrumentsFactoryImpl.getEventBus().fireEvent(new LeftMenuSelectedEvent(MenuBlock.this) );
				 subMenus.getElement().getStyle().setProperty("display", "block");
				menuButt.setSelectedBack();
			}
			 
		});
	}

	public void addSubMenuItem(MenuSubButt subMenuButt) {
		subMenus.add(subMenuButt);
	}


	public void onLeftMenuSelected(LeftMenuSelectedEvent event) {
		// TODO Auto-generated method stub
		if (event.getMenuBlock().equals(this)) {
			System.out.println("event eto ya");
		}
		else {
			setUnselectedAndMinimized();
		}
	}


	private void setUnselectedAndMinimized() {
		for (int i = 0; i < menuItem.getWidgetCount(); i++) {
			MenuButt w = (MenuButt)menuItem.getWidget(i);
		    w.setUnselectedBack();
		    // Do something with w
		    
		}
		
		subMenus.getElement().getStyle().setProperty("display", "none");
	}


}
