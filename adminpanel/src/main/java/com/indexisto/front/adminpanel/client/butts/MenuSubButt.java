package com.indexisto.front.adminpanel.client.butts;

public class MenuSubButt extends IconButt {
	public MenuSubButt (String menuPoint) {
		super(menuPoint);
		this.setText(menuPoint);
		this.addPanelStyle("menuSubButt");
		this.addPanelStyle("greyColorLightestBack");
		
		this.addIconStyle("menuSubButtIcon");
		this.addTextStyle("menuSubButtText");
		this.addTextStyle("greyColorLigter");
	}
}
