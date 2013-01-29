package com.indexisto.front.adminpanel.client.wigets;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.indexisto.front.adminpanel.client.blocks.Logo;

public class TopMenu extends Composite {

	
	private FlowPanel panel = new FlowPanel();
	private Label showSomeStat;
	private Logo logo = new Logo();

	public TopMenu() {

		super();
		panel.addStyleName("topMenu");
		panel.addStyleName("topMenuBack");
		
		showSomeStat = new Label("TopMenu");
		
		
		panel.add(logo); 
		//+ statObj.getLastAlbums() + " LastImgs " + statObj.getLastImgs());
		//showSomeStat.addStyleName("text11_White");
		
		//panel.add(showSomeStat);
		initWidget(panel);
	}





}
