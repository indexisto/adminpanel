package com.indexisto.front.adminpanel.client.blocks;


import java.awt.event.MouseEvent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.indexisto.front.adminpanel.client.butts.IconButt;

public class Logo extends Composite {

	private FlowPanel panel = new FlowPanel();
	private IconButt logoButt = new IconButt();
	private FlowPanel homeIcon = new FlowPanel();

	public Logo() {

		super();
		panel.addStyleName("logo");
		
		
		logoButt.addStyleName("logoButt");
		logoButt.addIconStyle("logoButtIcon");
		
		homeIcon.addStyleName("homeIcon");
		
		panel.add(homeIcon);
		panel.add(logoButt);
		
		

		
		
		
		
		
		logoButt.getFocusPanel().addMouseOverHandler(new MouseOverHandler() {

			public void onMouseOver(MouseOverEvent event) {
				// TODO Auto-generated method stub
				System.out.println("over");
				homeIcon.getElement().getStyle().setProperty("display", "block");
			}
			
		});
		
		
		logoButt.getFocusPanel().addMouseOutHandler(new MouseOutHandler() {


			public void onMouseOut(MouseOutEvent event) {
				// TODO Auto-generated method stub
				System.out.println("out");
				homeIcon.getElement().getStyle().setProperty("display", "none");
			}
			
		});
		
		
		
		
		
		initWidget(panel);
	}





}
