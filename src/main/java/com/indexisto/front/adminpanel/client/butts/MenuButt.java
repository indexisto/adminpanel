package com.indexisto.front.adminpanel.client.butts;

public class MenuButt extends IconButt {
	public MenuButt (String menuPoint) {
		super(menuPoint);
		this.setText(menuPoint);
		this.addPanelStyle("menuButt");
		this.addIconStyle("menuButtIcon");
		this.addTextStyle("menuButtText");
		this.addTextStyle("greyColor");
	}
	
	public void setSelectedBack () {
		this.addPanelStyle("greyColorSelectedBackground");
	}
	
	public void setUnselectedBack () {
		this.removePanelStyle("greyColorSelectedBackground");
	}
}
