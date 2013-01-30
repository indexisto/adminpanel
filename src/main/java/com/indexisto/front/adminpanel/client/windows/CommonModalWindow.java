package com.indexisto.front.adminpanel.client.windows;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CommonModalWindow extends PopupPanel {

	
	private VerticalPanel panel;
	private boolean isAnimated;
	
	 public CommonModalWindow(String text, boolean isAnimated) {
		 this();
		 this.isAnimated = isAnimated;
		 setTextLabel(text);
		 
		 if (isAnimated) {
			 startProgressAnimation();
		 }
		 Log.debug("CommonModalWindow");
	 }
	
    public CommonModalWindow() {
      // PopupPanel's constructor takes 'auto-hide' as its boolean parameter.
      // If this is set, the panel closes itself automatically when the user
      // clicks outside of it.

    	super(false, true);
    	this.removeStyleName("gwt-PopupPanel");
    	this.addStyleName("cleanPopupModale");
    	
    	
    	//panel = new VerticalPanel();
        //RootPanel.add(panel);
        //panel.setStyleName("table-center");
        //panel.add(new Label("Registering and creating test index. Please wait"));
    	//wrapperScroll.getElement().getStyle().setProperty("width", Window.getClientWidth() + "px");
    			//wrapperScroll.getElement().getStyle().setProperty("height", Window.getClientHeight()-36 + "px");
    			//Window.getClientWidth(), Window.getClientHeight()-36 - 50);
    			//this.getElement().getStyle().setProperty("width", Window.getClientWidth() + "px");
    			//this.getElement().getStyle().setProperty("height", Window.getClientHeight() + "px");
      
      
    }
    
    public void setTextLabel(String text) {
    	Label label = new Label(text);
    	label.addStyleName("greyColor");
    	label.addStyleName("modalLabel");
    	//label.getElement().getStyle().setProperty("width", Window.getClientWidth() + "px");
    	//label.getElement().getStyle().setProperty("top", Window.getClientHeight()/2 + "px");

    	this.setWidget(label);
    }
    
    public void startProgressAnimation() {
    	this.addStyleName("preloader_anim");
    }
    
  }