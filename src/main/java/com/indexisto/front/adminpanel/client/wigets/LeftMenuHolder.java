package com.indexisto.front.adminpanel.client.wigets;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.indexisto.front.adminpanel.client.butts.MenuButt;

public class LeftMenuHolder extends Composite {

	
	private FlowPanel panel = new FlowPanel();
	private LeftMenuRegister leftMenuRegister = new LeftMenuRegister();
	
	public LeftMenuHolder() {

		super();
		panel.addStyleName("leftMenu");
		panel.addStyleName("leftMenuBack");
		panel.add(leftMenuRegister);
	
		initWidget(panel);
	}





}
